package com.tencent.mobileqq.emoticonview;

import abyz;
import abza;
import abzb;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FavoriteEmotionAdapter
  extends BaseEmotionAdapter
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130837583);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public EmoticonPanelLinearLayout.OnClickListener a;
  
  public FavoriteEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$OnClickListener = new abyz(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private void a(URLImageView paramURLImageView1, URLImageView paramURLImageView2)
  {
    URLDrawable localURLDrawable = (URLDrawable)paramURLImageView1.getDrawable();
    if (localURLDrawable.getStatus() == 0)
    {
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if (!localURLDrawable.isDownloadStarted()) {
        localURLDrawable.startDownload();
      }
      if (!(paramURLImageView2.getDrawable() instanceof Animatable)) {
        paramURLImageView2.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130838592));
      }
      paramURLImageView1 = (Animatable)paramURLImageView2.getDrawable();
      if (!paramURLImageView1.isRunning()) {
        paramURLImageView1.start();
      }
      return;
    }
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if ((paramURLImageView2.getDrawable() instanceof Animatable)) {
        ((Animatable)paramURLImageView2.getDrawable()).stop();
      }
      paramURLImageView2.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramURLImageView1.setVisibility(0);
    paramURLImageView2.setVisibility(8);
  }
  
  private RelativeLayout b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "getFavrotiview");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.d / this.jdField_a_of_type_Int, (int)(61.0F * this.jdField_a_of_type_Float)));
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131361968);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131361969);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject).setId(2131362075);
    ((RelativeLayout)localObject).setVisibility(8);
    ((RelativeLayout)localObject).setBackgroundResource(2130845927);
    localLayoutParams = new RelativeLayout.LayoutParams(ScreenUtil.a(10.0F), ScreenUtil.a(10.0F));
    localLayoutParams.addRule(3, 2131361968);
    localLayoutParams.addRule(7, 2131361968);
    localLayoutParams.addRule(6, 2131361968);
    localLayoutParams.topMargin = (-(int)(this.jdField_a_of_type_Float * 4.0F));
    localLayoutParams.rightMargin = (-(int)(this.jdField_a_of_type_Float * 4.0F));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131361970);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131361968);
    localLayoutParams.addRule(8, 2131361968);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.b) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView == null) || (!(paramEmotionPanelData instanceof EmoticonInfo)))
    {
      QLog.e("FavoriteEmotionAdapter", 1, "emotionInfo or contentView = null");
      return;
    }
    paramEmotionPanelData = (EmoticonInfo)paramEmotionPanelData;
    paramView.setTag(paramEmotionPanelData);
    paramView.setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131362075);
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131361968);
    Object localObject2 = (URLImageView)paramView.findViewById(2131361969);
    localURLImageView.setVisibility(0);
    ((URLImageView)localObject2).setVisibility(8);
    localURLImageView.setURLDrawableDownListener(null);
    Object localObject1 = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
    String str = paramEmotionPanelData.a;
    int i;
    if ("favEdit".equals(str))
    {
      localURLImageView.setImageResource(2130843839);
      localURLImageView.setBackgroundDrawable(null);
      if (AppSetting.b) {
        localURLImageView.setContentDescription("收藏表情管理页面入口");
      }
      paramView = (ImageView)paramView.findViewById(2131361970);
      if (!(paramEmotionPanelData instanceof PicEmoticonInfo)) {
        break label610;
      }
      if (((PicEmoticonInfo)paramEmotionPanelData).a())
      {
        paramView.setVisibility(0);
        paramView.setImageResource(2130845940);
      }
    }
    else if ("funny_pic".equals(str))
    {
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("funny_pic_info", 0);
      i = ((SharedPreferences)localObject2).getInt("funnypic_type_sp_key", 1);
      if (!"7.6.0".equals("7.3.5")) {
        break label617;
      }
    }
    label610:
    label617:
    for (boolean bool = ((SharedPreferences)localObject2).getBoolean("group_emo_red_show_sp_key_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);; bool = false)
    {
      float f = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = (f * 10.0F);
      int j = (int)(this.jdField_a_of_type_Float * 57.0F);
      ((RelativeLayout.LayoutParams)localObject1).height = j;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = j;
      j = (int)(this.jdField_a_of_type_Float * 57.0F);
      ((RelativeLayout.LayoutParams)localObject1).width = j;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843838);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      localObject1 = FunnyPicHelper.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
      try
      {
        localObject2 = URLDrawable.getDrawable(new URL("funny_pic", null, (String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setTag(localObject1);
        ((URLDrawable)localObject2).addHeader("funnypic_type", String.valueOf(i));
        if ((((URLDrawable)localObject2).getCurrDrawable() instanceof GifDrawable)) {
          ((GifDrawable)((URLDrawable)localObject2).getCurrDrawable()).getImage().reset();
        }
        localURLImageView.setImageDrawable((Drawable)localObject2);
        if ((bool) && (localRelativeLayout != null)) {
          localRelativeLayout.setVisibility(0);
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
        }
      }
      if (!AppSetting.b) {
        break;
      }
      localURLImageView.setContentDescription("群聊表情入口");
      break;
      Drawable localDrawable = paramEmotionPanelData.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
      localURLImageView.setImageDrawable(localDrawable);
      localURLImageView.setBackgroundDrawable(null);
      ((URLImageView)localObject2).setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130838592));
      if (!(localDrawable instanceof URLDrawable)) {
        break;
      }
      localURLImageView.setURLDrawableDownListener(new abza(this, paramEmotionPanelData, localURLImageView, (URLImageView)localObject2));
      a(localURLImageView, (URLImageView)localObject2);
      break;
      paramView.setVisibility(8);
      return;
      paramView.setVisibility(8);
      return;
    }
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    System.currentTimeMillis();
    paramViewGroup = (FavoriteEmotionAdapter.FavoriteEmotionViewHolder)paramViewHolder;
    int i;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.a().a(this.c);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramViewHolder = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, -1);
        paramViewHolder.setPanelType(EmoticonPanelLinearLayout.d);
        paramViewHolder.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramViewHolder.setOrientation(0);
        if (paramInt == 0) {
          paramViewHolder.setPadding(0, (int)(11.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        for (;;)
        {
          i = 0;
          while (i < this.jdField_a_of_type_Int)
          {
            paramView = b();
            paramView.setVisibility(8);
            paramView.setFocusable(true);
            paramView.setFocusableInTouchMode(true);
            paramViewHolder.addView(paramView);
            i += 1;
          }
          paramViewHolder.setPadding(0, (int)(9.0F * this.jdField_a_of_type_Float), 0, 0);
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$OnClickListener = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$OnClickListener;
      }
      for (;;)
      {
        ((EmoticonPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
        a(this.c, paramViewHolder);
        paramView = (ViewGroup)paramViewHolder;
        paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
          i += 1;
        }
        paramViewHolder = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
          paramViewHolder = paramView;
        }
      }
      paramViewHolder.setTag(paramViewGroup);
      i = j;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int)
      {
        j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.a[i].setTag(null);
          paramViewGroup.a[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          b(paramViewGroup.a[i], (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(j));
        }
      }
      if (QLog.isColorLevel()) {}
      return paramViewHolder;
      paramViewHolder = paramView;
      i = j;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new FavoriteEmotionAdapter.FavoriteEmotionViewHolder();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "refreshPanelData");
    }
    EmotionPanelDataBuilder localEmotionPanelDataBuilder = EmotionPanelDataBuilder.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;; i = -1)
    {
      localEmotionPanelDataBuilder.a(localQQAppInterface, j, null, -1, i, false, new abzb(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */