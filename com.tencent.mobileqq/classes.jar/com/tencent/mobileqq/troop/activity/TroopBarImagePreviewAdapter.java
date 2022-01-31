package com.tencent.mobileqq.troop.activity;

import aijb;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TroopBarImagePreviewAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  protected int a;
  public Bitmap a;
  protected Drawable a;
  protected LayoutInflater a;
  protected URLDrawable.URLDrawableOptions a;
  protected ExtendGridView a;
  protected CharSequence a;
  private HashMap a;
  protected List a;
  protected boolean a;
  protected int b;
  protected CharSequence b;
  
  public TroopBarImagePreviewAdapter(Context paramContext, ExtendGridView paramExtendGridView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 9;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView = paramExtendGridView;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844380);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getText(2131430320);
    this.jdField_b_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131432657);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mUseMemoryCache = false;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    a(paramContext);
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(str))) {
        localHashMap.put(str, this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap);
    localHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "!!!clearDirtyCache time is " + (System.currentTimeMillis() - l));
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @TargetApi(16)
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView == null) {
      return;
    }
    int j = getCount();
    int i = j;
    if (j == this.jdField_a_of_type_Int + 1) {
      i = j - 1;
    }
    i = (int)Math.ceil(i / this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getNumColumns());
    Object localObject = getView(0, null, this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView);
    ((View)localObject).measure(0, 0);
    this.jdField_b_of_type_Int = ((View)localObject).getMeasuredHeight();
    j = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getVerticalSpacing();
    int k = this.jdField_b_of_type_Int;
    int m = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getPaddingTop();
    int n = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getPaddingBottom();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i * k + j * (i - 1) + m + n);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  protected void a(Context paramContext)
  {
    int i = (int)DisplayUtils.a(paramContext, 60.0F);
    int j = (int)DisplayUtils.a(paramContext, 5.0F);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    paramContext = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    RectF localRectF = new RectF(0.0F, 0.0F, i, i);
    localPaint.setAlpha(0);
    paramContext.drawRect(0.0F, 0.0F, i, i, localPaint);
    localPaint.setARGB(255, 255, 255, 255);
    Path localPath = new Path();
    localPath.addRoundRect(localRectF, j, j, Path.Direction.CW);
    localPath.setFillType(Path.FillType.INVERSE_WINDING);
    paramContext.drawPath(localPath, localPaint);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    if (paramBoolean2) {
      notifyDataSetChanged();
    }
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_Boolean) && (paramInt == getCount() - 1);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
    int j = i;
    if (this.jdField_a_of_type_Boolean) {
      j = i + 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (a(paramInt))) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = 2147483647;
    long l = System.currentTimeMillis();
    View localView;
    aijb localaijb;
    int i;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969475, null);
      localaijb = new aijb();
      localaijb.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131366619));
      localaijb.b = ((ImageView)localView.findViewById(2131366621));
      localaijb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366620));
      localView.setTag(localaijb);
      i = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.a();
      paramView = localView.getLayoutParams();
      if ((paramView != null) && ((paramView instanceof AbsListView.LayoutParams))) {
        break label245;
      }
      paramView = new AbsListView.LayoutParams(i, i);
      label129:
      localView.setLayoutParams((AbsListView.LayoutParams)paramView);
      if (!a(paramInt)) {
        break label260;
      }
      localaijb.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localaijb.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840549);
      localaijb.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      localaijb.b.setVisibility(8);
    }
    label245:
    String str;
    label260:
    do
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "---getView time is " + (System.currentTimeMillis() - l));
      }
      return localView;
      localaijb = (aijb)paramView.getTag();
      localView = paramView;
      break;
      paramView.width = i;
      paramView.height = i;
      break label129;
      str = (String)getItem(paramInt);
    } while (TextUtils.isEmpty(str));
    int j;
    if (i < 0)
    {
      j = 2147483647;
      label288:
      j = Math.min(100, j);
      if (i >= 0) {
        break label469;
      }
      i = k;
      label306:
      i = Math.min(100, i);
      localaijb.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      paramView = new File(str);
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 18) {
        c();
      }
      Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (((paramInt == 0) && (paramViewGroup.getChildCount() == 0)) || (localConstantState == null)) {
        break label472;
      }
      paramView = localConstantState.newDrawable();
    }
    for (;;)
    {
      paramView.setBounds(0, 0, j, i);
      localaijb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      localaijb.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      localaijb.b.setVisibility(0);
      localaijb.b.setTag(Integer.valueOf(paramInt));
      localaijb.b.setOnClickListener(this);
      localaijb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      break;
      j = i;
      break label288;
      label469:
      break label306;
      try
      {
        label472:
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth = j;
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight = i;
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mPlayGifImage = true;
        if (paramView.exists()) {}
        for (paramView = URLDrawable.getDrawable(paramView.toURL(), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);; paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          if (paramView != null) {
            break label543;
          }
          paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          break;
        }
      }
      catch (MalformedURLException paramView)
      {
        for (;;)
        {
          paramView = null;
        }
        label543:
        this.jdField_a_of_type_JavaUtilHashMap.put(str, paramView.getConstantState());
      }
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 2;
    }
    return 1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = (Integer)paramView.getTag();
    Intent localIntent = new Intent("key_photo_delete_action");
    localIntent.putExtra("key_photo_delete_position", paramView.intValue());
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter
 * JD-Core Version:    0.7.0.1
 */