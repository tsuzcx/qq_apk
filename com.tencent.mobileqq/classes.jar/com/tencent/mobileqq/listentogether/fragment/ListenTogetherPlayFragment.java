package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserMiniAIOHelper;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.musicgene.AlbumDecodeHandler;
import com.tencent.mobileqq.musicgene.AlbumDecodeHandler.OnDecodeCompleteCallback;
import com.tencent.mobileqq.musicgene.BitmapOptionUtil;
import com.tencent.mobileqq.musicgene.QQMusicConst;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListenTogetherPlayFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ListenTogetherPlayFragment.4(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FileBrowserMiniAIOHelper jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
  ListenTogetherHandler jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHandler;
  ListenTogetherManager jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
  ListenTogetherObserver jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver = new ListenTogetherPlayFragment.3(this);
  ListenTogetherSession jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession;
  ISong jdField_a_of_type_ComTencentMobileqqListentogetherDataISong;
  LyricViewController jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
  LyricViewDetail jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail;
  AlbumDecodeHandler.OnDecodeCompleteCallback jdField_a_of_type_ComTencentMobileqqMusicgeneAlbumDecodeHandler$OnDecodeCompleteCallback = new ListenTogetherPlayFragment.1(this);
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[5];
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView e;
  ImageView f;
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return "Grp_AIO";
    }
    if (paramInt == 2) {
      return "c2c_AIO";
    }
    return "";
  }
  
  private List<String> a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c();
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("getC2CUins status=%d msg=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString }));
    }
    ArrayList localArrayList = new ArrayList();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return localArrayList;
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
        return localArrayList;
      }
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
      return localArrayList;
    }
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localArrayList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager = ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHandler = ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver);
    int[] arrayOfInt = BitmapOptionUtil.a(-1315339);
    a(arrayOfInt[0], arrayOfInt[1], true);
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a());
    a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHandler.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
    }
    a(a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_a_of_type_JavaLangString);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().b(true);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = getBaseActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!isAdded()) {
        return;
      }
      boolean bool = QLog.isColorLevel();
      int i = 0;
      if (bool) {
        QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetColors [0x%x 0x%x]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      int j = Color.argb(0, Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1));
      localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, j, j, j, j, j, paramInt1 });
      this.e.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt1);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(paramInt1);
        this.e.setImageResource(2130840596);
        this.e.setScaleType(ImageView.ScaleType.CENTER);
      }
      else
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(0);
        this.e.setImageDrawable(null);
      }
      paramInt1 = Color.argb(128, Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setLyricHilightColor(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setLyricColor(paramInt1);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.f.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
      paramInt1 = i;
      if (localObject != null)
      {
        a(((DynamicAvatarView)((AvatarLayout)localObject).findViewById(2131363438)).getBackground(), paramInt2);
        paramInt1 = i;
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
        if (paramInt1 >= localObject.length) {
          break;
        }
        localObject = localObject[paramInt1];
        a(((ImageView)localObject).getBackground(), paramInt2);
        ((ImageView)localObject).setTag(Integer.valueOf(paramInt2));
        paramInt1 += 1;
      }
      localObject = getResources().getDrawable(2130840597);
      ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
      } else {
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      localObject = this.jdField_c_of_type_AndroidWidgetTextView.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(null, "dc00899", a(paramInt), "", paramString2, paramString3, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(Context paramContext, ListenTogetherSession paramListenTogetherSession, ISong paramISong, boolean paramBoolean, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("session", paramListenTogetherSession);
    localIntent.putExtra("song", paramISong);
    localIntent.putExtra("isAdmin", paramBoolean);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivity.class, ListenTogetherPlayFragment.class);
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    } else if ((paramDrawable instanceof GradientDrawable)) {
      ((GradientDrawable)paramDrawable).setColor(paramInt);
    }
    if (paramDrawable != null) {
      paramDrawable.invalidateSelf();
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377700));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377727));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372839));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)paramView.findViewById(2131370519));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371644));
    this.e = ((ImageView)paramView.findViewById(2131371635));
    this.f = ((ImageView)paramView.findViewById(2131371634));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368826);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376828);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378975));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131378969);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370282);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372838));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372831));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372830));
    int i = 0;
    while (i < 5)
    {
      Object localObject = this.jdField_c_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("head");
      localStringBuilder.append(i);
      localObject = (ImageView)((View)localObject).findViewWithTag(localStringBuilder.toString());
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = localObject;
      i += 1;
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365854));
    ((ViewGroup.MarginLayoutParams)this.f.getLayoutParams()).topMargin = AIOUtils.b(31.0F, getResources());
    this.f.setImageResource(2130845527);
    this.f.setBackgroundResource(2130838635);
    a(this.f.getBackground(), 1275068416);
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.2F);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.f.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController = new LyricViewController(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
    if (ScreenUtil.SCREEN_WIDTH > 0) {
      paramView.findViewById(2131371633).getLayoutParams().height = ScreenUtil.SCREEN_WIDTH;
    }
    b();
  }
  
  private void a(ISong paramISong)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramISong.b());
    Object localObject1 = paramISong.d();
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool1 = true;
    if ((!bool2) && (Patterns.WEB_URL.matcher((CharSequence)localObject1).matches()))
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "original";
      localObject2 = URLDrawable.getDrawable(paramISong.d(), (URLDrawable.URLDrawableOptions)localObject2);
      Object localObject3 = AlbumDecodeHandler.a(paramISong.d());
      if (localObject3 != null)
      {
        a(((Integer)((List)localObject3).get(0)).intValue(), ((Integer)((List)localObject3).get(1)).intValue(), false);
        i = 1;
      }
      else
      {
        localObject3 = new AlbumDecodeHandler((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMusicgeneAlbumDecodeHandler$OnDecodeCompleteCallback, null);
        if (((URLDrawable)localObject2).getStatus() == 1)
        {
          Drawable localDrawable = ((URLDrawable)localObject2).getCurrDrawable();
          if ((localDrawable instanceof RegionDrawable)) {
            ThreadManager.postImmediately(new ListenTogetherPlayFragment.2(this, (AlbumDecodeHandler)localObject3, ((RegionDrawable)localDrawable).getBitmap()), null, true);
          }
          i = 2;
        }
        else
        {
          i = 3;
          ((URLDrawable)localObject2).setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
        }
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("updateSongInfo type=%d album=%s", new Object[] { Integer.valueOf(i), localObject1 }));
    }
    localObject1 = MusicInfo.a(paramISong.b());
    int i = MusicInfo.a(paramISong.b());
    if (paramISong.a() > 0L)
    {
      paramISong = MusicInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, paramISong.a());
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      i = 0;
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramISong = (ISong)localObject1;
    }
    localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (((TextView)localObject1).getVisibility() != 0) {
      bool1 = false;
    }
    ((TextView)localObject1).setClickable(bool1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramISong);
    if (i != 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i), null, null, null);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = (String)this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.getTag();
    if (TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
    }
    else
    {
      int i;
      if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().b() != null) && (Utils.a(str, paramString1)))
      {
        i = 0;
      }
      else
      {
        a(paramString2, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setTag(paramString1);
        i = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b();
      int j = (int)l;
      if (paramInt == 1)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
        if (!bool) {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
        }
        paramString1 = new StringBuilder();
        paramString1.append("updateLyricPosition() try to seek! playPosition:");
        paramString1.append(l);
        paramString1.append(" seekPosition:");
        paramString1.append(j);
        paramString1.append(" isPlaying:");
        paramString1.append(bool);
        QLog.i("ListenTogetherPlayFragment", 1, paramString1.toString());
        if ((j >= 0) || (i != 0))
        {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
          if (j >= 0) {
            i = j;
          } else {
            i = 0;
          }
          paramString1.a(i);
        }
      }
      else if (2 == paramInt)
      {
        if (j >= 0) {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(j);
        }
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.c();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
      }
    }
    if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840600);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840601);
    }
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.2F);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    paramInt = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840606);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为随机播放");
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840603);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为顺序播放");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840607);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("切换播放模式 当前为单曲循环");
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Drawable localDrawable = ImageUtil.a(true);
        paramString = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString, 4, localDrawable, localDrawable);
        localDrawable = paramImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != paramString) && ((localDrawable instanceof FaceDrawable))) {
          ((FaceDrawable)localDrawable).cancel();
        }
        paramImageView.setImageDrawable(paramString);
        paramImageView.setVisibility(0);
        if ((paramImageView.getBackground() != null) && ((paramImageView.getBackground() instanceof ShapeDrawable)))
        {
          paramString = paramImageView.getTag();
          if ((paramString instanceof Integer))
          {
            int i = ((Integer)paramString).intValue();
            ((ShapeDrawable)paramImageView.getBackground()).getPaint().setColor(i);
          }
        }
      }
      else
      {
        paramImageView.setImageDrawable(ImageUtil.a(true));
        paramImageView.setVisibility(0);
      }
    }
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Lyric localLyric2 = LyricParseHelper.a(paramString, true);
    Lyric localLyric1 = localLyric2;
    if (localLyric2 == null) {
      localLyric1 = LyricParseHelper.a(paramString, false);
    }
    if (localLyric1 == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(paramLyricViewDetail);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(localLyric1, localLyric1, null);
  }
  
  private void a(List<String> paramList, String paramString)
  {
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int j = 0;
    while (j < 5)
    {
      if (j < i)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(0);
        a((String)paramList.get(j), this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j]);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setImageDrawable(null);
      }
      j += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1)
    {
      this.jdField_c_of_type_AndroidViewView.setClickable(true);
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    else
    {
      this.jdField_c_of_type_AndroidViewView.setClickable(true);
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(null);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private boolean a()
  {
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong = ((ISong)localBundle.getParcelable("song"));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = ((ListenTogetherSession)localBundle.getParcelable("session"));
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("isAdmin");
    return (this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong != null) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null);
  }
  
  private void b()
  {
    int i = ViewUtils.a();
    int j = ViewUtils.b();
    if ((j > 0) && (i > 0))
    {
      i = j - i - ViewUtils.a(312.0F);
      if (i < 0)
      {
        if (i > ViewUtils.a(50.0F) * -1)
        {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = i;
          return;
        }
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = (i + ViewUtils.a(34.0F));
      }
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)paramView.findViewById(2131368033));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    paramView = paramView.findViewById(2131368051);
    paramView.setVisibility(0);
    ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = AIOUtils.b(28.0F, getResources());
    paramView = ImageUtil.a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 2) {
      i = 1;
    } else {
      i = 4;
    }
    Object localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, 4, paramView, paramView);
    paramView = (DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363438);
    paramView.setImageDrawable((Drawable)localObject);
    int i = AIOUtils.b(1.5F, getResources());
    paramView.setPadding(i, i, i, i);
    paramView.setBackgroundResource(2130838635);
    localObject = (ImageView)((View)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getParent()).findViewById(2131368077);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper = new FileBrowserMiniAIOHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper.a((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, paramView, false);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_JavaLangString));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
    paramActivity.overridePendingTransition(2130772011, 2130772004);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()) && (isAdded()))
    {
      boolean bool = NetworkUtil.isNetworkAvailable(getBaseActivity());
      int k = paramView.getId();
      int i = 0;
      int j = 1;
      Object localObject1;
      Object localObject2;
      switch (k)
      {
      default: 
        break;
      case 2131378969: 
        if (!bool)
        {
          QQToast.a(getBaseActivity(), 1, getBaseActivity().getString(2131694647), 0).a();
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {
            ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, "music_tab", "clk_member");
        }
        break;
      case 2131372839: 
        if (!b())
        {
          QQToast.a(getBaseActivity(), HardCodeUtil.a(2131706256), 1).a();
        }
        else if (!bool)
        {
          QQToast.a(getBaseActivity(), 1, getBaseActivity().getString(2131694647), 0).a();
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h == 1)
          {
            ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h = 2;
            i = j;
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h == 2)
          {
            ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h = 1;
            i = j;
          }
          else
          {
            i = 0;
          }
          if (i != 0) {
            a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.h, this.jdField_a_of_type_JavaLangString);
          }
        }
        break;
      case 2131372838: 
        if (b()) {
          if (!bool)
          {
            QQToast.a(getBaseActivity(), 1, getBaseActivity().getString(2131694647), 0).a();
          }
          else
          {
            j = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.c + 1;
            i = j;
            if (j > 3) {
              i = 1;
            }
            ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).f(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, i);
            localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(i);
            ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_mode", 0, 0, "", "", ((StringBuilder)localObject2).toString(), "");
          }
        }
        break;
      case 2131372831: 
        if (b()) {
          if (!bool)
          {
            QQToast.a(getBaseActivity(), 1, getBaseActivity().getString(2131694647), 0).a();
          }
          else
          {
            ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, 2);
            ReportController.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          }
        }
        break;
      case 2131372830: 
        if (b()) {
          if (!bool)
          {
            QQToast.a(getBaseActivity(), 1, getBaseActivity().getString(2131694647), 0).a();
          }
          else
          {
            ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, 1);
            ReportController.b(null, "dc00899", a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          }
        }
        break;
      case 2131371634: 
        getBaseActivity().finish();
        break;
      case 2131368033: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e;
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int == 1) {
          i = 1;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
        if (localObject2 != null) {
          ((FileBrowserMiniAIOHelper)localObject2).a();
        }
        localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i);
        MiniChatActivity.a(getBaseActivity(), i, (String)localObject1, (String)localObject2);
        break;
      case 2131365854: 
        if (QQMusicConst.a(getBaseActivity(), "com.tencent.qqmusic"))
        {
          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("qqmusic://qq.com/ui/myTab?p=%7B%22tab%22%3A%22home%22%7D&source=https%3A%2F%2Fy.qq.com%2Fm%2Findex.html%3FADTAG%3DYIQITING"));
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_qqmusic");
          getBaseActivity().startActivity((Intent)localObject1);
          a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, "music_tab", "clk_openmusic");
        }
        else if (!bool)
        {
          QQToast.a(getBaseActivity(), 1, getBaseActivity().getString(2131694647), 0).a();
        }
        else
        {
          startActivity(new Intent(getActivity(), QQBrowserActivity.class).putExtra("url", "https://y.qq.com/m/download/index.html"));
          a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.e, "music_tab", "clk_downloadmusic");
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    View localView = paramLayoutInflater.inflate(2131561173, paramViewGroup, false);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!a())
    {
      getBaseActivity().finish();
    }
    else
    {
      localView.setClickable(true);
      a(localView);
      a();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
    if (localObject != null) {
      ((LyricViewController)localObject).b();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        ListenTogetherManager.a((QQAppInterface)localObject).a().c(false);
        this.jdField_b_of_type_Boolean = false;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).d();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getBaseActivity().overridePendingTransition(2130772004, 2130772015);
    if (this.jdField_b_of_type_Boolean)
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().c(false);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    FileBrowserMiniAIOHelper localFileBrowserMiniAIOHelper = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
    if (localFileBrowserMiniAIOHelper != null) {
      localFileBrowserMiniAIOHelper.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool2 = QQMusicConst.a(getBaseActivity());
    boolean bool1 = bool2 ^ true;
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView.getTag();
    if ((localObject instanceof Boolean)) {
      bool1 = ((Boolean)localObject).booleanValue();
    }
    if (bool1 != bool2)
    {
      int i;
      if (bool2) {
        i = 2131706254;
      } else {
        i = 2131706257;
      }
      localObject = HardCodeUtil.a(i);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(Boolean.valueOf(bool2));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment
 * JD-Core Version:    0.7.0.1
 */