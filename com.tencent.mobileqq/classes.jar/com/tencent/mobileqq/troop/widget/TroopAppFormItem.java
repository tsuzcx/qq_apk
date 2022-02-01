package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.TabInfo;

public class TroopAppFormItem
  extends RelativeLayout
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  String jdField_a_of_type_JavaLangString = "";
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  String c;
  
  public TroopAppFormItem(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return FormSimpleItem.a(paramResources, paramInt, false);
  }
  
  void a()
  {
    float f2 = 0.0F;
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    float f1;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      f1 = 0.0F;
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label174;
      }
      label33:
      float f3 = i - DisplayUtil.dip2px(getContext(), 12.0F) - DisplayUtil.dip2px(getContext(), 12.0F) - DisplayUtil.dip2px(getContext(), 15.0F);
      if ((this.jdField_a_of_type_Int != -1) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        break label241;
      }
      if (TextUtils.isEmpty(this.c)) {
        break label192;
      }
      f1 = i - DisplayUtil.dip2px(getContext(), 30.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - f1;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(f1 + 1.0F));
      return;
      f1 = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangString) + 150.0F;
      break;
      label174:
      this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangString);
      break label33;
      label192:
      f1 = i - DisplayUtil.dip2px(getContext(), 10.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - f1;
      continue;
      label241:
      if (!TextUtils.isEmpty(this.c))
      {
        f1 = i - DisplayUtil.dip2px(getContext(), 30.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - DisplayUtil.dip2px(getContext(), 5.0F) - f1;
      }
      else
      {
        f1 = DisplayUtil.dip2px(getContext(), 5.0F);
        f1 = f2;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
    a();
    if (!TextUtils.isEmpty(this.c))
    {
      if (Friends.isValidUin(this.c))
      {
        paramString1 = FaceDrawable.getFaceDrawable((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1, this.c);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramString1);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int <= 0)) {
        break label254;
      }
      if (!TextUtils.isEmpty(this.c)) {
        break label226;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      setBgType(paramInt2);
      return;
      if (this.c.startsWith("http"))
      {
        paramString1 = getResources().getDrawable(2130840312);
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        paramString2.mLoadingDrawable = paramString1;
        paramString2.mFailedDrawable = paramString1;
        paramString2.mRequestWidth = DisplayUtil.dip2px(getContext(), 30.0F);
        paramString2.mRequestHeight = DisplayUtil.dip2px(getContext(), 30.0F);
        paramString1 = URLDrawable.getDrawable(this.c, paramString2);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramString1);
        break;
      }
      this.c = null;
      break;
      label226:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      label254:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (TextUtils.isEmpty(this.c))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a(oidb_0xe83.TabInfo paramTabInfo, int paramInt)
  {
    if (paramTabInfo.appid.get() == 1106912788L) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(DisplayUtil.dip2px(getContext(), 30.0F));
    }
    a(paramTabInfo.name.get(), paramTabInfo.desc.get(), paramTabInfo.pic.get(), paramTabInfo.red_point.get(), paramInt);
  }
  
  public void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560589, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371615));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377932));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369865));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131376463);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131368344));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(DisplayUtil.dip2px(getContext(), 4.0F));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368445));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    setBackgroundDrawable(a(getResources(), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAppFormItem
 * JD-Core Version:    0.7.0.1
 */