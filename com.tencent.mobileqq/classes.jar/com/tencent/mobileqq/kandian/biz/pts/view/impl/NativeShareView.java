package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NativeShareView
  extends LinearLayout
  implements IView
{
  private Context jdField_a_of_type_AndroidContentContext;
  protected AdapterView.OnItemClickListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public NativeShareView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new NativeShareView.2(this);
    a(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new NativeShareView.2(this);
    a(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new NativeShareView.2(this);
    a(paramContext);
  }
  
  protected static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > paramInt)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, paramInt));
        ((StringBuilder)localObject).append("\n");
        ((StringBuilder)localObject).append(paramString.substring(paramInt));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Object localObject1 = inflate(getContext(), 2131560170, this);
    int j = ViewUtils.b(44.0F);
    localObject1 = (GridView)((View)localObject1).findViewById(2131367811);
    List localList = a(paramContext)[0];
    Object localObject2 = new TextPaint();
    ((TextPaint)localObject2).setTextSize(paramContext.getResources().getDimensionPixelSize(2131299101));
    new StaticLayout(a(a(localList), 6), (TextPaint)localObject2, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0, true);
    localObject2 = localList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility == 0) {
        i += 1;
      }
    }
    int k = ViewUtils.b(14.0F);
    j = j + k + k;
    ((GridView)localObject1).setColumnWidth(j);
    ((GridView)localObject1).setNumColumns(i);
    localObject2 = ((GridView)localObject1).getLayoutParams();
    ((GridView)localObject1).setPadding(16, ((GridView)localObject1).getPaddingTop(), 16, ((GridView)localObject1).getPaddingBottom());
    ((ViewGroup.LayoutParams)localObject2).width = (i * j + 0 + 0);
    ((GridView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((GridView)localObject1).setAdapter(new NativeShareView.ActionSheetItemAdapter(paramContext, localList));
    ((GridView)localObject1).setSelector(new ColorDrawable(0));
    ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    ((GridView)localObject1).setOnTouchListener(new NativeShareView.1(this));
    ShareImageUtils.a();
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      Object localObject2 = localObject1;
      if (str.length() > ((String)localObject1).length()) {
        localObject2 = str;
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = HardCodeUtil.a(2131707109);
    localActionSheetItem.icon = 2130842933;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 47;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696399);
    localActionSheetItem.icon = 2130842935;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696413);
    localActionSheetItem.icon = 2130842936;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696420);
    localActionSheetItem.icon = 2130842937;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696402);
    localActionSheetItem.icon = 2130842934;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ShareImageUtils.b();
  }
  
  public void setCurrentPath(String paramString)
  {
    ShareImageUtils.a(paramString);
  }
  
  public void setInitRunnable(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setScreenBitmap(Bitmap paramBitmap)
  {
    ShareImageUtils.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeShareView
 * JD-Core Version:    0.7.0.1
 */