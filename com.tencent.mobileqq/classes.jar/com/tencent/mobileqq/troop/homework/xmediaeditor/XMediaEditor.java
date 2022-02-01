package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HeaderInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HomeWorkInfoInterface;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase.OnEditItemListener;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.HeaderItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class XMediaEditor
  extends RecyclerView
{
  XMediaEditorAdapter a;
  EditItemBase.OnEditItemListener b = new XMediaEditor.3(this);
  private boolean c = true;
  private boolean d = true;
  private String e;
  private XMediaEditor.ICommitStateChangeListener f;
  private XMediaEditor.IContentLengthChangeListener g;
  private XMediaEditor.IFocusChangeListener h;
  private boolean i = false;
  private int j = 0;
  private int k = 0;
  private Bundle l = new Bundle();
  private HeaderItem m;
  private int n = 2147483647;
  private int o;
  private TextInfo p;
  private View q;
  
  public XMediaEditor(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new LinearLayoutManager(paramContext);
    addItemDecoration(new XMediaEditor.SpaceItemDecoration(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.m = new HeaderItem(this, paramContext);
    this.m.a(this.b);
    paramAttributeSet.put(-1, this.m);
    paramAttributeSet.put(0, new TextItem(this, paramContext).a(this.b));
    paramAttributeSet.put(3, new AudioItem(this, paramContext).a(this.b));
    paramAttributeSet.put(1, new ImageItem(this).a(this.b));
    paramAttributeSet.put(2, new VideoItem(this).a(this.b));
    this.a = new XMediaEditorAdapter(paramAttributeSet);
    setAdapter(this.a);
    setDefaultContent();
  }
  
  private <T extends View> T a(Class<T> paramClass, View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (paramClass.isInstance(paramView)) {
      return (View)paramClass.cast(paramView);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = paramView.getChildCount();
      if (i1 > 0) {
        return a(paramClass, paramView.getChildAt(i1 - 1));
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    return this.l.getString(paramString);
  }
  
  public void a()
  {
    Object localObject = this.p;
    ((TextInfo)localObject).c = true;
    localObject = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(((TextInfo)localObject).g);
    if (localObject != null)
    {
      ((TextItem.TextViewHolder)localObject).b.setFocusable(true);
      ((TextItem.TextViewHolder)localObject).b.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, (TextItem.TextViewHolder)localObject));
    }
  }
  
  public void a(int paramInt)
  {
    int i2 = 0;
    if (paramInt == 0)
    {
      this.a.b(0);
      this.a.notifyDataSetChanged();
      this.b.a(null, false);
      return;
    }
    Object localObject1 = this.a;
    int i1 = paramInt - 1;
    Object localObject2 = ((XMediaEditorAdapter)localObject1).c(i1);
    int i3 = paramInt + 1;
    if (i3 < this.a.getItemCount()) {
      localObject1 = this.a.c(i3);
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      if ((localObject2 instanceof TextInfo))
      {
        localObject1 = this.p;
        if (localObject1 != null) {
          ((TextInfo)localObject1).c = false;
        }
        this.p = ((TextInfo)localObject2);
        this.p.c = true;
      }
      this.a.b(paramInt);
      this.a.notifyDataSetChanged();
      this.b.a(null, false);
      return;
    }
    if (((localObject1 instanceof TextInfo)) && ((localObject2 instanceof TextInfo)))
    {
      localObject1 = (TextInfo)localObject1;
      localObject2 = (TextInfo)localObject2;
      ((TextInfo)localObject2).b = ((TextInfo)localObject2).a.length();
      Object localObject3 = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(((TextInfo)localObject2).g);
      if (localObject3 != null) {
        ((TextItem.TextViewHolder)localObject3).b.setSelection(((TextInfo)localObject2).b);
      }
      if (!TextUtils.isEmpty(((TextInfo)localObject1).a)) {
        if (TextUtils.isEmpty(((TextInfo)localObject2).a))
        {
          ((TextInfo)localObject2).a = ((TextInfo)localObject1).a;
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((TextInfo)localObject2).a);
          ((StringBuilder)localObject3).append(((TextInfo)localObject1).a);
          ((TextInfo)localObject2).a = ((StringBuilder)localObject3).toString();
        }
      }
      localObject1 = this.p;
      if (localObject1 != null) {
        ((TextInfo)localObject1).c = false;
      }
      this.p = ((TextInfo)localObject2);
      this.p.c = true;
      this.a.b(i3);
      this.a.b(paramInt);
      this.a.notifyDataSetChanged();
      this.b.a(null, false);
      paramInt = i2;
      if (i1 >= 0) {
        paramInt = i1;
      }
      scrollToPosition(paramInt);
      return;
    }
    this.a.b(paramInt);
    this.a.notifyDataSetChanged();
    this.b.a(null, false);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
    this.b.a(null, false);
  }
  
  public void a(EditItemInfoBase paramEditItemInfoBase)
  {
    if (paramEditItemInfoBase == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    int i1 = this.a.getItemCount();
    Object localObject1 = "";
    if (i1 == 0)
    {
      if ((paramEditItemInfoBase instanceof TextInfo))
      {
        this.a.a(paramEditItemInfoBase);
        this.a.notifyDataSetChanged();
        this.p = ((TextInfo)paramEditItemInfoBase);
        paramEditItemInfoBase = this.p;
        paramEditItemInfoBase.g = 0;
        paramEditItemInfoBase.c = true;
        return;
      }
      localObject1 = new TextInfo("");
      localObject2 = new TextInfo("");
      this.a.a((EditItemInfoBase)localObject1);
      this.a.a(paramEditItemInfoBase);
      this.a.a((EditItemInfoBase)localObject2);
      this.p = ((TextInfo)localObject2);
      paramEditItemInfoBase = this.p;
      paramEditItemInfoBase.c = true;
      paramEditItemInfoBase.g = 2;
      this.a.notifyDataSetChanged();
      this.b.a(null, false);
      scrollToPosition(this.p.g);
      return;
    }
    if (this.p == null)
    {
      localObject2 = this.a;
      localObject2 = ((XMediaEditorAdapter)localObject2).c(((XMediaEditorAdapter)localObject2).getItemCount() - 1);
      if ((localObject2 instanceof TextInfo))
      {
        this.p = ((TextInfo)localObject2);
      }
      else
      {
        localObject2 = new TextInfo("");
        this.p = ((TextInfo)localObject2);
        this.p.g = this.a.getItemCount();
        this.a.a((EditItemInfoBase)localObject2);
      }
      this.p.c = true;
    }
    int i2 = this.p.g;
    if (this.p.b < 0) {
      this.p.b = 0;
    }
    i1 = this.p.b;
    Object localObject2 = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(i2);
    if (localObject2 != null) {
      i1 = ((TextItem.TextViewHolder)localObject2).b.getSelectionStart();
    }
    Object localObject3;
    if (i1 == 0)
    {
      if (this.p.a.length() == 0)
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        localObject3 = this.p.a;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    else
    {
      localObject2 = this.p.a.substring(0, i1);
      if (this.p.a.length() != i1) {
        localObject1 = this.p.a.substring(i1);
      }
    }
    if ((paramEditItemInfoBase instanceof TextInfo))
    {
      paramEditItemInfoBase = (TextInfo)paramEditItemInfoBase;
      localObject3 = this.p;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(paramEditItemInfoBase.a);
      localStringBuilder.append((String)localObject1);
      ((TextInfo)localObject3).a(localStringBuilder.toString());
      localObject1 = this.p;
      ((TextInfo)localObject1).b += paramEditItemInfoBase.a.length();
    }
    else
    {
      localObject3 = this.a.c(i2);
      if ((localObject3 instanceof TextInfo))
      {
        ((TextInfo)localObject3).a((String)localObject2);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("insert item 类型不对 insertPosition");
        ((StringBuilder)localObject2).append(i2);
        QLog.d("XMediaEditor", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new TextInfo((String)localObject1);
      this.p.c = false;
      ((TextInfo)localObject1).c = true;
      ((TextInfo)localObject1).b = 0;
      this.p = ((TextInfo)localObject1);
      localObject2 = this.a;
      i1 = i2 + 1;
      ((XMediaEditorAdapter)localObject2).a(i1, (EditItemInfoBase)localObject1);
      this.a.a(i1, paramEditItemInfoBase);
      this.p.g = (i2 + 2);
      this.a.notifyDataSetChanged();
    }
    scrollToPosition(this.p.g);
    this.b.a(null, false);
  }
  
  public void a(ArrayList<UploadEditItemInfo> paramArrayList)
  {
    this.a.a(paramArrayList);
  }
  
  public void a(List<EditItemInfoBase> paramList)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      a((EditItemInfoBase)paramList.get(i1));
      i1 += 1;
    }
  }
  
  public int b(int paramInt)
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.a.getItemCount(); i2 = i3)
    {
      i3 = i2;
      if (this.a.c(i1) != null)
      {
        i3 = i2;
        if (this.a.c(i1).b() == paramInt) {
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void b()
  {
    Object localObject = this.p;
    ((TextInfo)localObject).c = false;
    localObject = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(((TextInfo)localObject).g);
    if (localObject != null)
    {
      ((TextItem.TextViewHolder)localObject).b.setFocusable(false);
      ((TextItem.TextViewHolder)localObject).b.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, (TextItem.TextViewHolder)localObject));
    }
  }
  
  public ArrayList<EditItemInfoBase> c(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.a.getItemCount())
    {
      if ((this.a.c(i1) != null) && (this.a.c(i1).b() == paramInt)) {
        localArrayList.add(this.a.c(i1));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public void c()
  {
    setDefaultContent();
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return (this.c) && (super.canScrollVertically(paramInt));
  }
  
  public void d()
  {
    this.q = null;
    this.m.a(null);
    if (this.a.h())
    {
      this.a.b(0);
      this.a.notifyDataSetChanged();
    }
  }
  
  public boolean e()
  {
    return this.a.h();
  }
  
  public int getContentLength()
  {
    return this.j;
  }
  
  public String getData()
  {
    return this.a.b();
  }
  
  public String getHint()
  {
    return this.e;
  }
  
  public ArrayList<HomeWorkInfoInterface> getHomeWorkItemList()
  {
    return this.a.g();
  }
  
  public int getLeftRightPadding()
  {
    return this.o;
  }
  
  public int getShowType()
  {
    return this.a.a();
  }
  
  public int getSizeLimit()
  {
    return this.k;
  }
  
  public ArrayList<UploadEditItemInfo> getUploadErrorItemList()
  {
    return this.a.f();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.c();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.d) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = this.n;
    if (i1 != 2147483647) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getShowType() == 0) && (paramMotionEvent.getAction() == 1))
    {
      EditText localEditText = (EditText)a(EditText.class, this);
      if (localEditText != null)
      {
        int[] arrayOfInt = new int[2];
        localEditText.getLocationOnScreen(arrayOfInt);
        float f1 = paramMotionEvent.getRawY();
        if (arrayOfInt[1] <= f1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("XMediaEditor", 2, "Oops! found et");
          }
          if (!localEditText.isFocused())
          {
            localEditText.setFocusable(true);
            localEditText.setFocusableInTouchMode(true);
            localEditText.requestFocus();
          }
          InputMethodUtil.a(localEditText);
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setCommitStateChangeListener(XMediaEditor.ICommitStateChangeListener paramICommitStateChangeListener)
  {
    this.f = paramICommitStateChangeListener;
  }
  
  public void setContentLengthChangeListener(XMediaEditor.IContentLengthChangeListener paramIContentLengthChangeListener)
  {
    this.g = paramIContentLengthChangeListener;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.a.a(new JSONArray(paramString));
      this.b.a(null, false);
      int i1 = this.a.e();
      this.b.a(this.j, i1);
      this.j = i1;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDataByEdit(JSONArray paramJSONArray)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < paramJSONArray.length())
        {
          EditItemInfoBase localEditItemInfoBase = EditItemInfoFactory.a(paramJSONArray.getJSONObject(i1));
          if (localEditItemInfoBase != null)
          {
            if ((localEditItemInfoBase instanceof UploadEditItemInfo))
            {
              ((UploadEditItemInfo)localEditItemInfoBase).o = 3;
              if ((localEditItemInfoBase instanceof ImageInfo)) {
                ((ImageInfo)localEditItemInfoBase).l = 100;
              }
            }
            if ((localEditItemInfoBase instanceof TextInfo))
            {
              this.p.a(((TextInfo)localEditItemInfoBase).a);
              this.p.b = ((TextInfo)localEditItemInfoBase).a.length();
              this.p.c = false;
              this.a.notifyDataSetChanged();
            }
            else
            {
              a(localEditItemInfoBase);
            }
          }
        }
        else
        {
          int i2 = this.a.e();
          i1 = 0;
          if (i1 < i2)
          {
            paramJSONArray = this.a.c(i1);
            if (!(paramJSONArray instanceof TextInfo)) {
              break label204;
            }
            this.p = ((TextInfo)paramJSONArray);
            this.p.c = true;
          }
          this.a.notifyDataSetChanged();
          scrollToPosition(0);
          return;
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      i1 += 1;
      continue;
      label204:
      i1 += 1;
    }
  }
  
  public void setDefaultContent()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(new TextInfo("").toString());
    localStringBuilder.append("]");
    setData(localStringBuilder.toString());
    this.p = ((TextInfo)this.a.c(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.l.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(XMediaEditor.IFocusChangeListener paramIFocusChangeListener)
  {
    this.h = paramIFocusChangeListener;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.q = paramView;
    this.m.a(this.q);
    if (this.a.h())
    {
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.a(0, new HeaderInfo());
    this.a.notifyDataSetChanged();
  }
  
  public void setHint(String paramString)
  {
    this.e = paramString;
  }
  
  public void setLeftRightPadding(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setShowType(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */