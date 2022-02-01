package com.tencent.mobileqq.selectmember.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.Hashtable;
import mqq.app.MobileQQ;

public abstract class FacePreloadBaseAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private ListView a;
  private boolean b;
  private AbsListView.OnScrollListener c;
  private int d = 0;
  private int e;
  private boolean f;
  private Hashtable<String, Bitmap> g = new Hashtable();
  protected IFaceDecoder m;
  
  public FacePreloadBaseAdapter(Context paramContext, AppInterface paramAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.a = paramListView;
    this.e = paramInt;
    this.f = paramBoolean;
    this.a.setOnScrollListener(this);
    this.m = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.m.setDecodeTaskCompletionListener(this);
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (AppConstants.SEC_MSG_UIN.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130849320);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.m.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.b)
    {
      this.m.cancelPendingRequests();
      this.b = false;
    }
    if (!this.m.isPausing()) {
      this.m.requestDecodeFace(paramString, paramInt, true, paramByte);
    }
    return b();
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ListView)localObject).getOnScrollListener() == this)) {
      this.a.setOnScrollListener(null);
    }
    localObject = this.m;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    this.a = null;
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (this.d == 0)
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        int j = ((ListView)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject = (FacePreloadBaseAdapter.ViewHolder)this.a.getChildAt(i).getTag();
          if ((localObject != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).i != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).i.length() > 0) && (((FacePreloadBaseAdapter.ViewHolder)localObject).i.equals(paramString)))
          {
            ((FacePreloadBaseAdapter.ViewHolder)localObject).k.setImageBitmap(paramBitmap);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected Bitmap b()
  {
    return BaseImageUtil.k();
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.b;
    paramInt2 = 0;
    if (bool)
    {
      if (paramInt1 == 0) {
        this.b = false;
      }
    }
    else if (!this.m.isPausing())
    {
      if (paramBitmap != null) {
        this.g.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = this.d;
        if ((paramInt1 == 0) || (paramInt1 == 1))
        {
          int i = this.a.getChildCount();
          paramInt1 = paramInt2;
          while (paramInt1 < i)
          {
            paramString = this.a.getChildAt(paramInt1).getTag();
            if ((paramString != null) && ((paramString instanceof FacePreloadBaseAdapter.ViewHolder)))
            {
              paramString = (FacePreloadBaseAdapter.ViewHolder)paramString;
              if ((paramString != null) && (paramString.i != null) && (paramString.i.length() > 0))
              {
                paramBitmap = (Bitmap)this.g.get(paramString.i);
                if (paramBitmap != null) {
                  paramString.k.setImageBitmap(paramBitmap);
                }
              }
            }
            paramInt1 += 1;
          }
        }
        this.g.clear();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.c;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.d = paramInt;
    int i = 0;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.b = false;
      this.m.cancelPendingRequests();
      this.m.pause();
    }
    else
    {
      if (this.m.isPausing()) {
        this.m.resume();
      }
      localObject = this.a;
      if (localObject != null)
      {
        int j = ((ListView)localObject).getChildCount();
        while (i < j)
        {
          localObject = this.a.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof FacePreloadBaseAdapter.ViewHolder)))
          {
            localObject = (FacePreloadBaseAdapter.ViewHolder)localObject;
            if ((localObject != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).i != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).i.length() > 0)) {
              ((FacePreloadBaseAdapter.ViewHolder)localObject).k.setImageBitmap(a(((FacePreloadBaseAdapter.ViewHolder)localObject).j, ((FacePreloadBaseAdapter.ViewHolder)localObject).i));
            }
          }
          i += 1;
        }
      }
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.adapter.FacePreloadBaseAdapter
 * JD-Core Version:    0.7.0.1
 */