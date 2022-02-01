package com.tencent.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class XCursorAdapter
  extends XBaseAdapter
  implements Filterable, CursorFilter.CursorFilterClient
{
  @Deprecated
  public static final int FLAG_AUTO_REQUERY = 1;
  public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
  protected boolean mAutoRequery;
  protected XCursorAdapter.ChangeObserver mChangeObserver;
  protected Context mContext;
  protected Cursor mCursor;
  protected CursorFilter mCursorFilter;
  protected DataSetObserver mDataSetObserver;
  protected boolean mDataValid;
  protected FilterQueryProvider mFilterQueryProvider;
  protected int mRowIDColumn;
  
  @Deprecated
  public XCursorAdapter(Context paramContext, Cursor paramCursor)
  {
    init(paramContext, paramCursor, 1);
  }
  
  public XCursorAdapter(Context paramContext, Cursor paramCursor, int paramInt)
  {
    init(paramContext, paramCursor, paramInt);
  }
  
  public XCursorAdapter(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    init(paramContext, paramCursor, i);
  }
  
  public abstract void bindView(View paramView, Context paramContext, Cursor paramCursor);
  
  public int changeCursor(Cursor paramCursor, int paramInt)
  {
    Cursor localCursor = this.mCursor;
    if ((localCursor != null) && (localCursor.moveToFirst()) && (paramCursor != null))
    {
      long l = this.mCursor.getLong(0);
      paramInt = 0;
      while (paramInt < paramCursor.getCount())
      {
        if ((paramCursor.moveToPosition(paramInt)) && (paramCursor.getLong(0) == l))
        {
          paramCursor = swapCursor(paramCursor, paramInt);
          if (paramCursor != null) {
            paramCursor.close();
          }
          return paramInt;
        }
        paramInt += 1;
      }
    }
    changeCursor(paramCursor);
    return 0;
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    paramCursor = swapCursor(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  public int getCount()
  {
    if (this.mDataValid)
    {
      Cursor localCursor = this.mCursor;
      if (localCursor != null) {
        return localCursor.getCount();
      }
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    return this.mCursor;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mDataValid)
    {
      this.mCursor.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(this.mContext, this.mCursor, paramViewGroup);
      }
      bindView(localView, this.mContext, this.mCursor);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (this.mCursorFilter == null) {
      this.mCursorFilter = new CursorFilter(this);
    }
    return this.mCursorFilter;
  }
  
  public FilterQueryProvider getFilterQueryProvider()
  {
    return this.mFilterQueryProvider;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.mDataValid)
    {
      Cursor localCursor = this.mCursor;
      if (localCursor != null)
      {
        localCursor.moveToPosition(paramInt);
        return this.mCursor;
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mDataValid)
    {
      Cursor localCursor = this.mCursor;
      if ((localCursor != null) && (localCursor.moveToPosition(paramInt))) {
        return this.mCursor.getLong(this.mRowIDColumn);
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mDataValid)
    {
      if (this.mCursor.moveToPosition(paramInt))
      {
        View localView;
        if (paramView == null) {
          localView = newView(this.mContext, this.mCursor, paramViewGroup);
        } else {
          localView = paramView;
        }
        bindView(localView, this.mContext, this.mCursor);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
      }
      paramView = new StringBuilder();
      paramView.append("couldn't move cursor to position ");
      paramView.append(paramInt);
      throw new IllegalStateException(paramView.toString());
    }
    throw new IllegalStateException("this should only be called when the cursor is valid");
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  void init(Context paramContext, Cursor paramCursor, int paramInt)
  {
    boolean bool = false;
    if ((paramInt & 0x1) == 1)
    {
      paramInt |= 0x2;
      this.mAutoRequery = true;
    }
    else
    {
      this.mAutoRequery = false;
    }
    if (paramCursor != null) {
      bool = true;
    }
    this.mCursor = paramCursor;
    this.mDataValid = bool;
    this.mContext = paramContext;
    int i;
    if (bool) {
      i = paramCursor.getColumnIndexOrThrow("_id");
    } else {
      i = -1;
    }
    this.mRowIDColumn = i;
    if ((paramInt & 0x2) == 2)
    {
      this.mChangeObserver = new XCursorAdapter.ChangeObserver(this);
      this.mDataSetObserver = new XCursorAdapter.MyDataSetObserver(this, null);
    }
    else
    {
      this.mChangeObserver = null;
      this.mDataSetObserver = null;
    }
    if (bool)
    {
      paramContext = this.mChangeObserver;
      if (paramContext != null) {
        paramCursor.registerContentObserver(paramContext);
      }
      paramContext = this.mDataSetObserver;
      if (paramContext != null) {
        paramCursor.registerDataSetObserver(paramContext);
      }
    }
  }
  
  @Deprecated
  protected void init(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    init(paramContext, paramCursor, i);
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected void onContentChanged()
  {
    if (this.mAutoRequery)
    {
      Cursor localCursor = this.mCursor;
      if ((localCursor != null) && (!localCursor.isClosed())) {
        this.mDataValid = this.mCursor.requery();
      }
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    FilterQueryProvider localFilterQueryProvider = this.mFilterQueryProvider;
    if (localFilterQueryProvider != null) {
      return localFilterQueryProvider.runQuery(paramCharSequence);
    }
    return this.mCursor;
  }
  
  public void setFilterQueryProvider(FilterQueryProvider paramFilterQueryProvider)
  {
    this.mFilterQueryProvider = paramFilterQueryProvider;
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    Cursor localCursor = this.mCursor;
    if (paramCursor == localCursor) {
      return null;
    }
    Object localObject;
    if (localCursor != null)
    {
      localObject = this.mChangeObserver;
      if (localObject != null) {
        localCursor.unregisterContentObserver((ContentObserver)localObject);
      }
      localObject = this.mDataSetObserver;
      if (localObject != null) {
        localCursor.unregisterDataSetObserver((DataSetObserver)localObject);
      }
    }
    this.mCursor = paramCursor;
    if (paramCursor != null)
    {
      localObject = this.mChangeObserver;
      if (localObject != null) {
        paramCursor.registerContentObserver((ContentObserver)localObject);
      }
      localObject = this.mDataSetObserver;
      if (localObject != null) {
        paramCursor.registerDataSetObserver((DataSetObserver)localObject);
      }
      this.mRowIDColumn = paramCursor.getColumnIndexOrThrow("_id");
      this.mDataValid = true;
      notifyDataSetChanged();
      return localCursor;
    }
    this.mRowIDColumn = -1;
    this.mDataValid = false;
    notifyDataSetInvalidated();
    return localCursor;
  }
  
  public Cursor swapCursor(Cursor paramCursor, int paramInt)
  {
    Cursor localCursor = this.mCursor;
    if (paramCursor == localCursor) {
      return null;
    }
    Object localObject;
    if (localCursor != null)
    {
      localObject = this.mChangeObserver;
      if (localObject != null) {
        localCursor.unregisterContentObserver((ContentObserver)localObject);
      }
      localObject = this.mDataSetObserver;
      if (localObject != null) {
        localCursor.unregisterDataSetObserver((DataSetObserver)localObject);
      }
    }
    this.mCursor = paramCursor;
    if (paramCursor != null)
    {
      localObject = this.mChangeObserver;
      if (localObject != null) {
        paramCursor.registerContentObserver((ContentObserver)localObject);
      }
      localObject = this.mDataSetObserver;
      if (localObject != null) {
        paramCursor.registerDataSetObserver((DataSetObserver)localObject);
      }
      this.mRowIDColumn = paramCursor.getColumnIndexOrThrow("_id");
      this.mDataValid = true;
      if (paramInt > 0) {
        notifyRowInserted(0, paramInt - 1);
      }
      notifyDataSetChanged();
      return localCursor;
    }
    this.mRowIDColumn = -1;
    this.mDataValid = false;
    notifyDataSetInvalidated();
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XCursorAdapter
 * JD-Core Version:    0.7.0.1
 */