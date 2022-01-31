package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import bbpc;
import bdaq;
import bdfa;
import bdgz;
import bdpb;
import bdpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

public class PublishItemContainer
  extends CustomHorizontalScrollView
  implements View.OnClickListener, bdpc
{
  protected Activity a;
  protected Drawable a;
  protected View a;
  protected LinearLayout a;
  public bbpc a;
  private bdpb jdField_a_of_type_Bdpb;
  protected CharSequence a;
  protected ArrayList<String> a;
  private boolean jdField_a_of_type_Boolean;
  protected LinearLayout b;
  private boolean b;
  private int g = 0;
  private int h = 9;
  
  public PublishItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130847367);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131718695);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    addView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(16);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramAttributeSet);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, (int)bdgz.a(paramContext, 7.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131559777, null);
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    setVisibility(8);
    this.jdField_a_of_type_Bbpc = null;
    this.g = 0;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    c();
  }
  
  protected void a(View paramView)
  {
    Object localObject = paramView.findViewById(2131368123);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131379394);
    localURLImageView.setImageResource(2130848068);
    ((View)localObject).setVisibility(8);
    localURLImageView.setAdjustViewBounds(false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
    localLayoutParams.width = ((int)bdgz.a(getContext(), 50.0F));
    localLayoutParams.height = ((int)bdgz.a(getContext(), 50.0F));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localURLImageView.setOnClickListener(this);
    localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = bdaq.a(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = bdaq.a(getContext(), 2.0F);
    localObject = new LinearLayout.LayoutParams((int)bdgz.a(getContext(), 60.0F), (int)bdgz.a(getContext(), 67.0F));
    ((LinearLayout.LayoutParams)localObject).rightMargin = bdaq.a(getContext(), 2.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = bdaq.a(getContext(), 4.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  protected void a(View paramView, String paramString)
  {
    View localView;
    URLImageView localURLImageView;
    RelativeLayout.LayoutParams localLayoutParams;
    Object localObject2;
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      localView = paramView.findViewById(2131368123);
      localURLImageView = (URLImageView)paramView.findViewById(2131379394);
      localURLImageView.setAdjustViewBounds(false);
      localObject1 = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)bdgz.a(getContext(), 50.0F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)bdgz.a(getContext(), 50.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = bdaq.a(getContext(), 2.0F);
      localLayoutParams.rightMargin = bdaq.a(getContext(), 2.0F);
      localObject2 = new File(paramString);
    }
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
        localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
        if (!((File)localObject2).exists()) {
          break label345;
        }
        localObject2 = URLDrawable.getDrawable(((File)localObject2).toURL(), localURLDrawableOptions);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        label207:
        label345:
        break label207;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      ((Drawable)localObject2).setBounds(0, 0, localLayoutParams.width, localLayoutParams.height);
      localURLImageView.setImageDrawable((Drawable)localObject2);
      localURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      localView.setTag(paramString);
      localView.setOnClickListener(this);
      localURLImageView.setTag(paramString);
      localURLImageView.setOnClickListener(this);
      paramString = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramString.rightMargin = bdaq.a(getContext(), 2.0F);
      paramString.topMargin = bdaq.a(getContext(), 5.0F);
      paramString.width = ((int)bdgz.a(getContext(), 60.0F));
      paramString.height = ((int)bdgz.a(getContext(), 67.0F));
      paramView.setLayoutParams(paramString);
      return;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a(int paramInt, bbpc parambbpc)
  {
    if (this.g == 1) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (parambbpc == null) {}
    for (View localView = null; localView == null; localView = parambbpc.getView(getContext(), this)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    setVisibility(0);
    this.jdField_a_of_type_Bbpc = parambbpc;
    this.g = paramInt;
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (this.g != 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      View localView = LayoutInflater.from(getContext()).inflate(2131559777, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      a(localView, paramString);
      this.g = 1;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == this.h) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      setVisibility(0);
      postDelayed(new PublishItemContainer.1(this), 200L);
      return true;
    }
    return false;
  }
  
  public boolean a(ArrayList<String> paramArrayList)
  {
    if (this.g != 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramArrayList != null)
    {
      Object localObject = new ArrayList(paramArrayList);
      int j;
      int k;
      if ((paramArrayList.size() == this.h) || (paramArrayList.size() == 0))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        k = ((ArrayList)localObject).size();
        if (j <= k) {
          break label161;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(k, j - k);
      }
      for (;;)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i), (String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break;
        label161:
        if (j < k)
        {
          paramArrayList = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
          i = 0;
          while (i < k - j)
          {
            localObject = paramArrayList.inflate(2131559777, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            i += 1;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.g = 1;
        setVisibility(0);
        postDelayed(new PublishItemContainer.2(this), 200L);
      }
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setVisibility(8);
    return false;
  }
  
  public void b()
  {
    if ((this.g != 2) || (!(this.jdField_a_of_type_Bbpc instanceof AudioInfo))) {}
    AudioInfo localAudioInfo;
    do
    {
      return;
      localAudioInfo = (AudioInfo)this.jdField_a_of_type_Bbpc;
      localAudioInfo.mAudioIcon.setImageResource(2130849412);
      localObject = new Intent("key_audio_playing_action");
      ((Intent)localObject).putExtra("audio_local_path", localAudioInfo.path);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
    } while (this.jdField_a_of_type_Bdpb != null);
    this.jdField_a_of_type_Bdpb = new bdpb(localAudioInfo.path, new Handler(), localAudioInfo.getAudioType());
    this.jdField_a_of_type_Bdpb.a(getContext());
    this.jdField_a_of_type_Bdpb.b();
    this.jdField_a_of_type_Bdpb.a(this);
    this.jdField_a_of_type_Bdpb.c();
    this.jdField_b_of_type_Boolean = true;
    Object localObject = (AnimationDrawable)BaseApplicationImpl.getApplication().getResources().getDrawable(2130772171);
    localAudioInfo.mAudioIcon.setImageDrawable((Drawable)localObject);
    ((AnimationDrawable)localObject).start();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (this.jdField_a_of_type_Bdpb != null)
    {
      this.jdField_a_of_type_Bdpb.f();
      this.jdField_a_of_type_Bdpb = null;
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Bbpc instanceof AudioInfo)) {}
    }
    else
    {
      return;
    }
    AudioInfo localAudioInfo = (AudioInfo)this.jdField_a_of_type_Bbpc;
    if ((localAudioInfo.mAudioIcon.getDrawable() instanceof AnimationDrawable)) {
      ((AnimationDrawable)localAudioInfo.mAudioIcon.getDrawable()).stop();
    }
    localAudioInfo.mAudioIcon.setImageResource(2130849412);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      c();
      paramView = new Intent("key_audio_delete_action");
      BaseApplication.getContext().sendBroadcast(paramView);
      this.g = 0;
      this.jdField_a_of_type_Bbpc = null;
      return;
      paramView = (String)paramView.getTag();
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView);
      this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(i);
      paramView = new Intent("key_photo_delete_action");
      paramView.putExtra("key_photo_delete_position", i);
      BaseApplication.getContext().sendBroadcast(paramView);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.g = 0;
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      if (paramView.getTag() != null)
      {
        paramView = (String)paramView.getTag();
        i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView);
        bdfa.a();
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NewPhotoPreviewActivity.class);
        paramView.putExtra("ALBUM_ID", "$RecentAlbumId");
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
        paramView.putExtra("back_btn_text", this.jdField_a_of_type_AndroidAppActivity.getString(2131697688));
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
        paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_a_of_type_JavaUtilArrayList.size());
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
        paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        paramView.putExtra("from_tribe_class_name", this.jdField_a_of_type_AndroidAppActivity.getClass().getSimpleName());
        paramView.putExtra("PhotoConst.IS_OVERLOAD", false);
        paramView.addFlags(603979776);
        getContext().startActivity(paramView);
        bdfa.anim(this.jdField_a_of_type_AndroidAppActivity, false, true);
        return;
      }
      paramView = new Intent("key_photo_add_action");
      BaseApplication.getContext().sendBroadcast(paramView);
      return;
      if (this.jdField_a_of_type_Bdpb != null) {
        break;
      }
      b();
    } while (this.jdField_a_of_type_Boolean);
    paramView = new Intent("key_audio_play_action");
    BaseApplication.getContext().sendBroadcast(paramView);
    this.jdField_a_of_type_Boolean = true;
    return;
    c();
  }
  
  public void setCurType(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setItemEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(paramBoolean);
    if (this.g == 2)
    {
      View localView2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      View localView1 = localView2.findViewById(2131362887);
      localView2 = localView2.findViewById(2131362888);
      if ((localView1 != null) && (localView2 != null))
      {
        localView1.setEnabled(paramBoolean);
        localView2.setEnabled(paramBoolean);
      }
    }
    setEnabled(paramBoolean);
  }
  
  public void setMaxPicNum(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemContainer
 * JD-Core Version:    0.7.0.1
 */