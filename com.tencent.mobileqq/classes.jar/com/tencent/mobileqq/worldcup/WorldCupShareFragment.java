package com.tencent.mobileqq.worldcup;

import akyc;
import akye;
import akyg;
import akyh;
import akyi;
import akyj;
import akyk;
import akyl;
import akyo;
import akyr;
import akyt;
import akyu;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.av.doodle.MathUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupRecordController;
import com.tencent.mobileqq.ar.ARRecord.worldcup.VideoProcessor;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.ar.config.WorldCupMgr.DownloadListener;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo.ClothesText;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo.ColorScheme;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo.MainText;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo.MainTitle;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo.Match;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo.PkTitle;
import com.tencent.mobileqq.ar.config.WorldCupShareInfo.Template;
import com.tencent.mobileqq.arcard.ARCardLoadingProgressView;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.mobileqq.confess.ConfessShareHelper;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorldCupShareFragment
  extends PublicBaseFragment
  implements Handler.Callback, TextWatcher, View.OnClickListener, AdapterView.OnItemClickListener, TextView.OnEditorActionListener, ITransactionCallback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener, IVideoViewBase.IVideoViewCallBack
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new akyu(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private WorldCupMgr.DownloadListener jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr$DownloadListener = new akyg(this);
  private ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new akyc(this);
  private NonMainAppHeadLoader.FaceObserver jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver = new akyi(this);
  private NonMainAppHeadLoader jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  public Runnable a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private StateListDrawable jdField_b_of_type_AndroidGraphicsDrawableStateListDrawable;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long = -1L;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  
  public WorldCupShareFragment()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new akyh(this);
  }
  
  private int a(int paramInt)
  {
    return 2130971729;
  }
  
  private int a(String paramString)
  {
    try
    {
      int m = paramString.getBytes("gbk").length;
      return m;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private Bitmap a(View paramView)
  {
    Object localObject = (RelativeLayout)paramView.findViewById(2131375471);
    int m = ((RelativeLayout)localObject).getWidth();
    int n = ((RelativeLayout)localObject).getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(750, 1387, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    WorldCupShareInfo localWorldCupShareInfo = WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
    localCanvas.drawColor(Color.parseColor(((WorldCupShareInfo.ColorScheme)((WorldCupShareInfo.Template)localWorldCupShareInfo.share.get(this.jdField_a_of_type_Int)).color_scheme.get(this.jdField_d_of_type_Int)).news_paper_background_color));
    String str = b();
    localCanvas.drawBitmap(WorldCupShareInfo.getResBitmap(str + localWorldCupShareInfo.share_br_icon), 340.0F, 1093.0F, null);
    ((RelativeLayout)localObject).layout(0, 0, m, n);
    localCanvas.save();
    float f1 = 750.0F / m;
    localCanvas.scale(f1, f1, 0.0F, 0.0F);
    c(paramView, true);
    ((RelativeLayout)localObject).draw(localCanvas);
    c(paramView, false);
    localCanvas.restore();
    localCanvas.save();
    localCanvas.clipRect(21, 1226, 129, 1334);
    localCanvas.drawColor(-1);
    localCanvas.restore();
    ConfessShareHelper.a(this.jdField_e_of_type_JavaLangString, localCanvas, new Rect(25, 1230, 125, 1330));
    localObject = new Paint();
    ((Paint)localObject).setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    ((Paint)localObject).setColor(-1);
    ((Paint)localObject).setTextSize(13.0F);
    ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
    localCanvas.drawText(getString(2131439381), 75.0F, 1350.0F, (Paint)localObject);
    ((Paint)localObject).setTextSize(28.0F);
    ((Paint)localObject).setTextAlign(Paint.Align.LEFT);
    paramView = localWorldCupShareInfo.AIOQRCodeMainTitle;
    if (paramView != null) {
      localCanvas.drawText(paramView, 141.0F, 1273.0F, (Paint)localObject);
    }
    if (localWorldCupShareInfo.AIOQRCodeDetailTitle != null)
    {
      paramView = localWorldCupShareInfo.AIOQRCodeDetailTitle.replace("self", this.jdField_c_of_type_JavaLangString);
      m = this.jdField_c_of_type_JavaLangString.length();
      while (((Paint)localObject).measureText(paramView) > 596.0F)
      {
        m -= 1;
        paramView = localWorldCupShareInfo.AIOQRCodeDetailTitle.replace("self", this.jdField_c_of_type_JavaLangString.substring(0, m) + "…");
      }
      localCanvas.drawText(paramView, 141.0F, 1309.0F, (Paint)localObject);
    }
    return localBitmap;
  }
  
  private Animation a()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new akyt(this));
    return localAnimationSet;
  }
  
  private IVideoViewBase a(View paramView, int paramInt1, int paramInt2)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG initVideoView");
    FragmentActivity localFragmentActivity = getActivity();
    if (!TVK_SDKMgr.isInstalled(BaseApplication.getContext())) {
      TVK_SDKMgr.initSdk(BaseApplication.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    }
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    IVideoViewBase localIVideoViewBase = localTVK_IProxyFactory.createVideoView_Scroll(localFragmentActivity);
    ((View)localIVideoViewBase).setId(2131362669);
    localIVideoViewBase.setXYaxis(2);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1 * 496 / paramInt2, paramInt1 * 780 / paramInt2);
    localLayoutParams.leftMargin = (paramInt1 * 40 / paramInt2);
    localLayoutParams.topMargin = (paramInt1 * 168 / paramInt2);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375471);
    paramView = (ImageView)paramView.findViewById(2131375472);
    paramInt1 = -1;
    if (paramView != null) {
      paramInt1 = localRelativeLayout.indexOfChild(paramView);
    }
    localRelativeLayout.addView((View)localIVideoViewBase, paramInt1, localLayoutParams);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(localFragmentActivity, localIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    ((View)localIVideoViewBase).setOnClickListener(this);
    localIVideoViewBase.addViewCallBack(this);
    return localIVideoViewBase;
  }
  
  private String a()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      localObject2 = localObject1;
    }
    for (;;)
    {
      return localObject2;
      try
      {
        localObject1 = "temp_world_cup_share_" + System.currentTimeMillis() + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + ".png";
        localObject1 = QRUtils.a(getActivity(), (String)localObject1, this.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WorldCupShareFragment", 2, "WL_DEBUG saveBitmaptoTempFile path = " + (String)localObject1);
        return localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("WorldCupShareFragment", 2, localOutOfMemoryError.getMessage());
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("moduleId", "module_olympic");
    localIntent.putExtra("coverPath", paramString1);
    localIntent.putExtra("videoPath", paramString2);
    localIntent.addFlags(603979776);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivityForTool.class, WorldCupShareFragment.class);
  }
  
  private void a(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131375488);
    TextView localTextView2 = (TextView)paramView.findViewById(2131375494);
    TextView localTextView3 = (TextView)paramView.findViewById(2131375498);
    TextView localTextView4 = (TextView)paramView.findViewById(2131375500);
    paramView = (TextView)paramView.findViewById(2131375490);
    localTextView1.setText(this.jdField_c_of_type_JavaLangString);
    localTextView2.setText(this.jdField_c_of_type_JavaLangString);
    localTextView3.setText(this.jdField_c_of_type_JavaLangString);
    localTextView4.setText(this.jdField_c_of_type_JavaLangString);
    paramView.setText(this.jdField_d_of_type_JavaLangString);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.width = (localLayoutParams.width * paramInt1 / paramInt2);
    if (localLayoutParams.height != -2) {
      localLayoutParams.height = (localLayoutParams.height * paramInt1 / paramInt2);
    }
    localLayoutParams.leftMargin = (localLayoutParams.leftMargin * paramInt1 / paramInt2);
    localLayoutParams.topMargin = (localLayoutParams.topMargin * paramInt1 / paramInt2);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(View paramView, WorldCupShareInfo paramWorldCupShareInfo)
  {
    if (paramWorldCupShareInfo.share.size() > 0)
    {
      this.jdField_a_of_type_Int = MathUtils.a(paramWorldCupShareInfo.share.size() - 1);
      WorldCupShareInfo.Template localTemplate = (WorldCupShareInfo.Template)paramWorldCupShareInfo.share.get(this.jdField_a_of_type_Int);
      String str = b();
      Object localObject2 = (TextView)paramView.findViewById(2131375477);
      Object localObject1 = (TextView)paramView.findViewById(2131375478);
      TextView localTextView4 = (TextView)paramView.findViewById(2131375479);
      TextView localTextView1 = (TextView)paramView.findViewById(2131375484);
      TextView localTextView2 = (TextView)paramView.findViewById(2131375485);
      TextView localTextView3 = (TextView)paramView.findViewById(2131375487);
      int m;
      if (localTemplate.matches.size() > 0)
      {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        this.jdField_b_of_type_Int = 0;
        Object localObject3;
        if (this.jdField_b_of_type_Int < localTemplate.matches.size())
        {
          localObject3 = paramWorldCupShareInfo.getDate(((WorldCupShareInfo.Match)localTemplate.matches.get(this.jdField_b_of_type_Int)).begin_time);
          if ((localObject3 == null) || (this.jdField_c_of_type_Long - ((Date)localObject3).getTime() <= 0L)) {}
        }
        else
        {
          if (this.jdField_b_of_type_Int >= localTemplate.matches.size()) {
            this.jdField_b_of_type_Int = (localTemplate.matches.size() - 1);
          }
          paramWorldCupShareInfo = (WorldCupShareInfo.Match)localTemplate.matches.get(this.jdField_b_of_type_Int);
          localObject3 = WorldCupShareInfo.getResBitmap(str + localTemplate.template_id + File.separator + paramWorldCupShareInfo.title);
          paramView.findViewById(2131375475).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject3));
          localObject3 = new Date(this.jdField_c_of_type_Long);
          if (localObject3 != null) {}
          switch (((Date)localObject3).getMonth())
          {
          default: 
            m = 2131439366;
            label396:
            ((TextView)localObject2).setText(m);
            ((TextView)localObject1).setText(String.valueOf(((Date)localObject3).getDate()));
            m = 2131434643;
            switch (((Date)localObject3).getDay())
            {
            default: 
              label468:
              localTextView4.setText(m);
              if (paramWorldCupShareInfo.main_title.size() > 0)
              {
                this.jdField_f_of_type_Int = MathUtils.a(paramWorldCupShareInfo.main_title.size() - 1);
                localObject2 = (WorldCupShareInfo.MainTitle)paramWorldCupShareInfo.main_title.get(this.jdField_f_of_type_Int);
                localObject3 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
                ((LinearLayout.LayoutParams)localObject3).height = (this.jdField_j_of_type_Int * 520 / (((WorldCupShareInfo.MainTitle)localObject2).item1.length() * this.jdField_k_of_type_Int));
                ((LinearLayout.LayoutParams)localObject3).topMargin = (this.jdField_j_of_type_Int * 5 / this.jdField_k_of_type_Int);
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = (this.jdField_j_of_type_Int * -5 / this.jdField_k_of_type_Int);
                localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject3 = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
                ((LinearLayout.LayoutParams)localObject3).height = (this.jdField_j_of_type_Int * 520 / (((WorldCupShareInfo.MainTitle)localObject2).item2.length() * this.jdField_k_of_type_Int));
                localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localTextView1.setText(((WorldCupShareInfo.MainTitle)localObject2).item1);
                localTextView2.setText(((WorldCupShareInfo.MainTitle)localObject2).item2);
                label657:
                this.jdField_g_of_type_Int = MathUtils.a(paramWorldCupShareInfo.social_title.size() - 1);
                localTextView3.setText((String)paramWorldCupShareInfo.social_title.get(this.jdField_g_of_type_Int));
                if (paramWorldCupShareInfo.pk_title.size() <= 0) {
                  break label1357;
                }
                this.jdField_c_of_type_Int = MathUtils.a(paramWorldCupShareInfo.pk_title.size() - 1);
                localObject2 = (WorldCupShareInfo.PkTitle)paramWorldCupShareInfo.pk_title.get(this.jdField_c_of_type_Int);
                ((TextView)paramView.findViewById(2131375489)).setText(((WorldCupShareInfo.PkTitle)localObject2).main_title.replace("selfnick", "").replace("peernick", ""));
                ((TextView)paramView.findViewById(2131375491)).setText(((WorldCupShareInfo.PkTitle)localObject2).reporter);
                ((TextView)paramView.findViewById(2131375492)).setText(((WorldCupShareInfo.PkTitle)localObject2).sub_title);
                label806:
                if (paramWorldCupShareInfo.clothes_text.size() <= 0) {
                  break label1370;
                }
                this.jdField_i_of_type_Int = MathUtils.a(paramWorldCupShareInfo.clothes_text.size() - 1);
                localObject2 = (WorldCupShareInfo.ClothesText)paramWorldCupShareInfo.clothes_text.get(this.jdField_i_of_type_Int);
                ((TextView)paramView.findViewById(2131375495)).setText(((WorldCupShareInfo.ClothesText)localObject2).title);
                ((TextView)paramView.findViewById(2131375496)).setText(((WorldCupShareInfo.ClothesText)localObject2).reporter);
                label884:
                if (paramWorldCupShareInfo.main_text.size() <= 0) {
                  break label1383;
                }
                this.jdField_h_of_type_Int = MathUtils.a(paramWorldCupShareInfo.main_text.size() - 1);
                paramWorldCupShareInfo = (WorldCupShareInfo.MainText)paramWorldCupShareInfo.main_text.get(this.jdField_h_of_type_Int);
                localObject2 = (TextView)paramView.findViewById(2131375501);
                localObject3 = (TextView)paramView.findViewById(2131375502);
                TextView localTextView5 = (TextView)paramView.findViewById(2131375503);
                TextView localTextView6 = (TextView)paramView.findViewById(2131375504);
                ((TextView)localObject2).setText(paramWorldCupShareInfo.title);
                ((TextView)localObject3).setText(paramWorldCupShareInfo.reporter);
                localTextView5.setText(paramWorldCupShareInfo.firstline);
                localTextView6.setText(paramWorldCupShareInfo.text);
                label1009:
                if (localTemplate.clothes_number.size() <= 0) {
                  break label1409;
                }
                this.jdField_e_of_type_Int = MathUtils.a(localTemplate.clothes_number.size() - 1);
                paramWorldCupShareInfo = WorldCupShareInfo.getResBitmap(str + localTemplate.template_id + File.separator + (String)localTemplate.clothes_number.get(this.jdField_e_of_type_Int));
                paramView.findViewById(2131375497).setBackgroundDrawable(new BitmapDrawable(paramWorldCupShareInfo));
              }
              break;
            }
            break;
          }
        }
      }
      label1357:
      for (;;)
      {
        label1106:
        if (localTemplate.color_scheme.size() > 0)
        {
          this.jdField_d_of_type_Int = MathUtils.a(localTemplate.color_scheme.size() - 1);
          paramWorldCupShareInfo = (WorldCupShareInfo.ColorScheme)localTemplate.color_scheme.get(this.jdField_d_of_type_Int);
          int n = paramWorldCupShareInfo.title_background_color.size();
          localObject2 = new int[n];
          m = 0;
          for (;;)
          {
            if (m < n)
            {
              localObject2[m] = Color.parseColor((String)paramWorldCupShareInfo.title_background_color.get(m));
              m += 1;
              continue;
              this.jdField_b_of_type_Int += 1;
              break;
              m = 2131439360;
              break label396;
              m = 2131439361;
              break label396;
              m = 2131439362;
              break label396;
              m = 2131439363;
              break label396;
              m = 2131439364;
              break label396;
              m = 2131439365;
              break label396;
              m = 2131439366;
              break label396;
              m = 2131439367;
              break label396;
              m = 2131439368;
              break label396;
              m = 2131439369;
              break label396;
              m = 2131439370;
              break label396;
              m = 2131439371;
              break label396;
              m = 2131434649;
              break label468;
              m = 2131434643;
              break label468;
              m = 2131434644;
              break label468;
              m = 2131434645;
              break label468;
              m = 2131434646;
              break label468;
              m = 2131434647;
              break label468;
              m = 2131434648;
              break label468;
              QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper main_title.size() == 0");
              break label657;
              QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper pk_title.size() == 0");
              break label806;
              label1370:
              QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper clothes_text.size() == 0");
              break label884;
              label1383:
              QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper main_text.size() == 0");
              break label1009;
              QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper match.size() == 0");
              break label1009;
              QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper clothes_number.size() == 0");
              break label1106;
            }
          }
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, (int[])localObject2);
          paramView.findViewById(2131375473).setBackground((Drawable)localObject2);
          localObject2 = new BitmapDrawable(WorldCupShareInfo.getResBitmap(str + localTemplate.template_id + File.separator + localTemplate.date));
          m = Color.parseColor(paramWorldCupShareInfo.date_color);
          ((BitmapDrawable)localObject2).setColorFilter(m, PorterDuff.Mode.SRC_ATOP);
          paramView.findViewById(2131375476).setBackgroundDrawable((Drawable)localObject2);
          ((TextView)localObject1).setTextColor(m);
          localTextView4.setTextColor(m);
          localObject1 = (WorldCupShareImageView)paramView.findViewById(2131375482);
          m = Color.parseColor(paramWorldCupShareInfo.matches_title_color);
          ((WorldCupShareImageView)localObject1).setColor(m);
          ((TextView)paramView.findViewById(2131375483)).setTextColor(new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { 0x80FFFFFF & m, m }));
          localTextView1.setTextColor(m);
          localTextView2.setTextColor(m);
          localTextView3.setBackgroundColor(Color.parseColor(paramWorldCupShareInfo.social_title_background_color));
        }
      }
      for (;;)
      {
        label1409:
        paramWorldCupShareInfo = WorldCupShareInfo.getResBitmap(str + localTemplate.template_id + File.separator + localTemplate.news_paper_title_list);
        paramView.findViewById(2131375474).setBackgroundDrawable(new BitmapDrawable(paramWorldCupShareInfo));
        paramWorldCupShareInfo = WorldCupShareInfo.getResBitmap(str + localTemplate.template_id + File.separator + localTemplate.column_image);
        paramView.findViewById(2131375499).setBackgroundDrawable(new BitmapDrawable(paramWorldCupShareInfo));
        return;
        QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper color_scheme.size() == 0");
      }
    }
    QLog.e("WorldCupShareFragment", 1, "WL_DEBUG initNewspaper share.size() == 0");
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      d(paramView);
      f(paramView);
      g(paramView);
    }
  }
  
  private void a(WorldCupShareInfo paramWorldCupShareInfo)
  {
    paramWorldCupShareInfo = getResources();
    Object localObject1 = b();
    Object localObject2 = WorldCupShareInfo.getResBitmap((String)localObject1 + "mute_nor.png");
    Object localObject3 = WorldCupShareInfo.getResBitmap((String)localObject1 + "mute_pressed.png");
    Bitmap localBitmap = WorldCupShareInfo.getResBitmap((String)localObject1 + "sound_nor.png");
    localObject1 = WorldCupShareInfo.getResBitmap((String)localObject1 + "sound_pressed.png");
    this.jdField_b_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    StateListDrawable localStateListDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableStateListDrawable;
    localObject3 = new BitmapDrawable(paramWorldCupShareInfo, (Bitmap)localObject3);
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
    localObject3 = this.jdField_b_of_type_AndroidGraphicsDrawableStateListDrawable;
    localObject2 = new BitmapDrawable(paramWorldCupShareInfo, (Bitmap)localObject2);
    ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject2);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localObject1 = new BitmapDrawable(paramWorldCupShareInfo, (Bitmap)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    paramWorldCupShareInfo = new BitmapDrawable(paramWorldCupShareInfo, localBitmap);
    ((StateListDrawable)localObject1).addState(new int[0], paramWorldCupShareInfo);
  }
  
  public static void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public static void a(String paramString, int paramInt)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG reportClickEvent actionName = " + paramString + ", fromType = " + paramInt);
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private void a(String paramString, View paramView)
  {
    String str = paramString + "loading" + File.separator + "loading.json";
    if (!new File(str).exists())
    {
      QLog.i("WorldCupShareFragment", 1, "initLoadingAnimation failed. jsonFile not exist.");
      return;
    }
    paramString = paramString + "loading" + File.separator + "images" + File.separator;
    if (!new File(paramString).exists())
    {
      QLog.i("WorldCupShareFragment", 1, "initLoadingAnimation failed. imgPath not exist.");
      return;
    }
    if (!new File(paramString + "img_0.png").exists())
    {
      QLog.i("WorldCupShareFragment", 1, "initLoadingAnimation failed. aniImg0 not exist.");
      return;
    }
    if (!new File(paramString + "img_1.png").exists())
    {
      QLog.i("WorldCupShareFragment", 1, "initLoadingAnimation failed. aniImg1 not exist.");
      return;
    }
    if (!new File(paramString + "img_2.png").exists())
    {
      QLog.i("WorldCupShareFragment", 1, "initLoadingAnimation failed. aniImg2 not exist.");
      return;
    }
    try
    {
      LottieComposition.Factory.fromInputStream(getActivity(), new FileInputStream(str), new akye(this, paramString, paramView));
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("WorldCupShareFragment", 2, "loadWorldCupGuideAnimation failed. err = " + paramString.getMessage());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    FragmentActivity localFragmentActivity = getActivity();
    FrameLayout localFrameLayout = (FrameLayout)localFragmentActivity.findViewById(2131375512);
    EditText localEditText = (EditText)localFragmentActivity.findViewById(2131375513);
    localFrameLayout.setVisibility(0);
    if (this.jdField_b_of_type_Boolean)
    {
      m = 2131439372;
      localEditText.setHint(m);
      ((InputMethodManager)localFragmentActivity.getSystemService("input_method")).toggleSoftInput(2, 0);
      localEditText.requestFocus();
      if (!paramBoolean) {
        break label99;
      }
    }
    label99:
    for (int m = 1;; m = 2)
    {
      a("0X8009318", m);
      return;
      m = 2131439373;
      break;
    }
  }
  
  private void a(boolean paramBoolean, View paramView)
  {
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      if (this.jdField_i_of_type_Boolean)
      {
        h(paramView);
        i(paramView);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    label166:
    do
    {
      return false;
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        this.jdField_d_of_type_Long = ((File)localObject).length();
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0)) {}
      }
      try
      {
        if (SessionInfo.getInstance((String)localObject).getHttpconn_sig_session() != null)
        {
          int m = SessionInfo.getInstance((String)localObject).getHttpconn_sig_session().length;
          this.jdField_a_of_type_ArrayOfByte = new byte[m];
          System.arraycopy(SessionInfo.getInstance((String)localObject).getHttpconn_sig_session(), 0, this.jdField_a_of_type_ArrayOfByte, 0, m);
        }
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0)) {
          break label166;
        }
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject);
        QLog.i("WorldCupShareFragment", 1, "WL_DEBUG sendFile failed. mSigSession == null || mSigSession.length == 0.");
        return false;
      }
      finally {}
      QQToast.a(BaseApplication.getContext(), 1, 2131435624, 0).a();
      return false;
      byte[] arrayOfByte1 = a(paramString);
      if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0))
      {
        QLog.i("WorldCupShareFragment", 1, "WL_DEBUG sendFile failed. fileMd5 == null || fileMd5.length == 0.");
        return false;
      }
      byte[] arrayOfByte2 = b(paramString);
      paramString = new Transaction((String)localObject, 60, paramString, 0, this.jdField_a_of_type_ArrayOfByte, arrayOfByte1, this, arrayOfByte2);
    } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(paramString) != 0);
    return true;
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: new 943	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 944	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: new 1070	java/io/FileOutputStream
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 1071	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   26: astore_2
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore 6
    //   34: aload_1
    //   35: aload 6
    //   37: invokevirtual 1077	java/io/InputStream:read	([B)I
    //   40: istore_3
    //   41: iload_3
    //   42: ifle +68 -> 110
    //   45: aload_2
    //   46: aload 6
    //   48: iconst_0
    //   49: iload_3
    //   50: invokevirtual 1083	java/io/OutputStream:write	([BII)V
    //   53: goto -19 -> 34
    //   56: astore 7
    //   58: aload_1
    //   59: astore 6
    //   61: aload 7
    //   63: astore_1
    //   64: invokestatic 514	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +14 -> 81
    //   70: ldc_w 385
    //   73: iconst_2
    //   74: aload_1
    //   75: invokevirtual 958	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   78: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 6
    //   83: ifnull +8 -> 91
    //   86: aload 6
    //   88: invokevirtual 1086	java/io/InputStream:close	()V
    //   91: iload 5
    //   93: istore 4
    //   95: aload_2
    //   96: ifnull +11 -> 107
    //   99: aload_2
    //   100: invokevirtual 1087	java/io/OutputStream:close	()V
    //   103: iload 5
    //   105: istore 4
    //   107: iload 4
    //   109: ireturn
    //   110: iconst_1
    //   111: istore 5
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 1086	java/io/InputStream:close	()V
    //   121: iload 5
    //   123: istore 4
    //   125: aload_2
    //   126: ifnull -19 -> 107
    //   129: aload_2
    //   130: invokevirtual 1087	java/io/OutputStream:close	()V
    //   133: iconst_1
    //   134: ireturn
    //   135: astore_1
    //   136: iload 5
    //   138: istore 4
    //   140: invokestatic 514	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq -36 -> 107
    //   146: ldc_w 385
    //   149: iconst_2
    //   150: aload_1
    //   151: invokevirtual 1088	java/io/IOException:getMessage	()Ljava/lang/String;
    //   154: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore_1
    //   160: invokestatic 514	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq -42 -> 121
    //   166: ldc_w 385
    //   169: iconst_2
    //   170: aload_1
    //   171: invokevirtual 1088	java/io/IOException:getMessage	()Ljava/lang/String;
    //   174: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: goto -56 -> 121
    //   180: astore_1
    //   181: invokestatic 514	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -93 -> 91
    //   187: ldc_w 385
    //   190: iconst_2
    //   191: aload_1
    //   192: invokevirtual 1088	java/io/IOException:getMessage	()Ljava/lang/String;
    //   195: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: goto -107 -> 91
    //   201: astore_1
    //   202: iload 5
    //   204: istore 4
    //   206: invokestatic 514	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq -102 -> 107
    //   212: ldc_w 385
    //   215: iconst_2
    //   216: aload_1
    //   217: invokevirtual 1088	java/io/IOException:getMessage	()Ljava/lang/String;
    //   220: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_2
    //   228: aload 7
    //   230: astore 6
    //   232: aload 6
    //   234: ifnull +8 -> 242
    //   237: aload 6
    //   239: invokevirtual 1086	java/io/InputStream:close	()V
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 1087	java/io/OutputStream:close	()V
    //   250: aload_1
    //   251: athrow
    //   252: astore 6
    //   254: invokestatic 514	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -15 -> 242
    //   260: ldc_w 385
    //   263: iconst_2
    //   264: aload 6
    //   266: invokevirtual 1088	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: goto -30 -> 242
    //   275: astore_2
    //   276: invokestatic 514	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq -29 -> 250
    //   282: ldc_w 385
    //   285: iconst_2
    //   286: aload_2
    //   287: invokevirtual 1088	java/io/IOException:getMessage	()Ljava/lang/String;
    //   290: invokestatic 392	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto -43 -> 250
    //   296: astore 7
    //   298: aconst_null
    //   299: astore_2
    //   300: aload_1
    //   301: astore 6
    //   303: aload 7
    //   305: astore_1
    //   306: goto -74 -> 232
    //   309: astore 7
    //   311: aload_1
    //   312: astore 6
    //   314: aload 7
    //   316: astore_1
    //   317: goto -85 -> 232
    //   320: astore_1
    //   321: goto -89 -> 232
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: goto -263 -> 64
    //   330: astore 7
    //   332: aconst_null
    //   333: astore_2
    //   334: aload_1
    //   335: astore 6
    //   337: aload 7
    //   339: astore_1
    //   340: goto -276 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	WorldCupShareFragment
    //   0	343	1	paramString1	String
    //   0	343	2	paramString2	String
    //   40	10	3	m	int
    //   93	112	4	bool1	boolean
    //   7	196	5	bool2	boolean
    //   4	234	6	localObject1	Object
    //   252	13	6	localIOException	java.io.IOException
    //   301	35	6	str	String
    //   1	1	7	localObject2	Object
    //   56	173	7	localException1	Exception
    //   296	8	7	localObject3	Object
    //   309	6	7	localObject4	Object
    //   330	8	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   27	34	56	java/lang/Exception
    //   34	41	56	java/lang/Exception
    //   45	53	56	java/lang/Exception
    //   129	133	135	java/io/IOException
    //   117	121	159	java/io/IOException
    //   86	91	180	java/io/IOException
    //   99	103	201	java/io/IOException
    //   9	18	225	finally
    //   237	242	252	java/io/IOException
    //   246	250	275	java/io/IOException
    //   18	27	296	finally
    //   27	34	309	finally
    //   34	41	309	finally
    //   45	53	309	finally
    //   64	81	320	finally
    //   9	18	324	java/lang/Exception
    //   18	27	330	java/lang/Exception
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 624	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 920	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 7
    //   16: new 943	java/io/FileInputStream
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 1093	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload 7
    //   34: invokevirtual 1010	java/io/File:length	()J
    //   37: invokestatic 1099	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   40: astore 7
    //   42: aload 7
    //   44: astore_1
    //   45: aload_1
    //   46: astore_3
    //   47: aload 4
    //   49: ifnull +10 -> 59
    //   52: aload 4
    //   54: invokevirtual 1100	java/io/FileInputStream:close	()V
    //   57: aload_1
    //   58: astore_3
    //   59: aload_3
    //   60: areturn
    //   61: astore_3
    //   62: aload 4
    //   64: astore_3
    //   65: new 624	java/io/File
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 920	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 4
    //   77: astore_3
    //   78: aload 7
    //   80: invokevirtual 923	java/io/File:exists	()Z
    //   83: istore_2
    //   84: aload 5
    //   86: astore_1
    //   87: iload_2
    //   88: ifeq -43 -> 45
    //   91: aload 4
    //   93: astore_3
    //   94: aload 7
    //   96: invokestatic 1105	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +14 -> 115
    //   104: aload 4
    //   106: astore_3
    //   107: aload_1
    //   108: invokestatic 1108	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   111: astore_1
    //   112: goto -67 -> 45
    //   115: ldc_w 412
    //   118: astore_1
    //   119: goto -15 -> 104
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 1109	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: areturn
    //   129: astore 5
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: astore_3
    //   135: aload 5
    //   137: invokevirtual 1110	java/lang/Exception:printStackTrace	()V
    //   140: aload 6
    //   142: astore_3
    //   143: aload_1
    //   144: ifnull -85 -> 59
    //   147: aload_1
    //   148: invokevirtual 1100	java/io/FileInputStream:close	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 1109	java/io/IOException:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 1100	java/io/FileInputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_3
    //   174: aload_3
    //   175: invokevirtual 1109	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_1
    //   182: goto -19 -> 163
    //   185: astore 5
    //   187: aload 4
    //   189: astore_1
    //   190: goto -57 -> 133
    //   193: astore_1
    //   194: aload 5
    //   196: astore_1
    //   197: goto -152 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	WorldCupShareFragment
    //   0	200	1	paramString	String
    //   83	5	2	bool	boolean
    //   29	31	3	localObject1	Object
    //   61	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   64	43	3	localFileInputStream1	FileInputStream
    //   122	2	3	localIOException1	java.io.IOException
    //   134	34	3	localObject2	Object
    //   173	2	3	localIOException2	java.io.IOException
    //   25	163	4	localFileInputStream2	FileInputStream
    //   4	81	5	localObject3	Object
    //   129	7	5	localException1	Exception
    //   185	10	5	localException2	Exception
    //   1	140	6	localObject4	Object
    //   14	81	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   30	42	61	java/lang/UnsatisfiedLinkError
    //   52	57	122	java/io/IOException
    //   6	27	129	java/lang/Exception
    //   147	151	153	java/io/IOException
    //   6	27	160	finally
    //   167	171	173	java/io/IOException
    //   30	42	181	finally
    //   65	75	181	finally
    //   78	84	181	finally
    //   94	100	181	finally
    //   107	112	181	finally
    //   135	140	181	finally
    //   30	42	185	java/lang/Exception
    //   65	75	185	java/lang/Exception
    //   78	84	185	java/lang/Exception
    //   94	100	185	java/lang/Exception
    //   107	112	185	java/lang/Exception
    //   94	100	193	java/io/IOException
    //   107	112	193	java/io/IOException
  }
  
  private Animation b()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(500);
    ((AlphaAnimation)localObject).setStartOffset(1000L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(500);
    ((ScaleAnimation)localObject).setStartOffset(1500L);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  private String b()
  {
    return WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(2);
  }
  
  private void b(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375471);
    Object localObject = paramView.findViewById(2131375470);
    paramView = (LinearLayout)paramView.findViewById(2131375508);
    localRelativeLayout.setVisibility(0);
    paramView.setVisibility(0);
    ((View)localObject).startAnimation(a());
    localObject = b();
    localRelativeLayout.startAnimation((Animation)localObject);
    paramView.startAnimation((Animation)localObject);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.width = (localLayoutParams.width * paramInt1 / paramInt2 + 22);
    if (localLayoutParams.height != -2) {
      localLayoutParams.height = (localLayoutParams.height * paramInt1 / paramInt2 + 22);
    }
    localLayoutParams.leftMargin = (localLayoutParams.leftMargin * paramInt1 / paramInt2 - 11);
    localLayoutParams.topMargin = (localLayoutParams.topMargin * paramInt1 / paramInt2 - 11);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean != paramBoolean)
    {
      this.jdField_e_of_type_Boolean = paramBoolean;
      e(paramView);
    }
  }
  
  private void b(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0)
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          paramString.delete();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(boolean paramBoolean, View paramView)
  {
    if (this.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        i(paramView);
      }
    }
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 0) {
        bool1 = new File(paramString).exists();
      }
    }
    return bool1;
  }
  
  private byte[] b(String paramString)
  {
    try
    {
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        paramString = MD5FileUtil.a((File)localObject);
        if (paramString != null) {}
        for (;;)
        {
          String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
          long l = ((File)localObject).length();
          paramString = paramString + str + l;
          localObject = new Bdh_extinfo.CommFileExtReq();
          ((Bdh_extinfo.CommFileExtReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramString));
          ((Bdh_extinfo.CommFileExtReq)localObject).uint32_action_type.set(0);
          return ((Bdh_extinfo.CommFileExtReq)localObject).toByteArray();
          paramString = "";
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private String c()
  {
    WorldCupConfigInfo localWorldCupConfigInfo = WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    return localWorldCupConfigInfo.a(0) + "share" + File.separator;
  }
  
  private void c(View paramView)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG playVideo");
    paramView = getActivity();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setPlayType(4);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramView, this.jdField_b_of_type_JavaLangString, 0L, 0L, localTVK_PlayerVideoInfo);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(true);
  }
  
  private void c(View paramView, boolean paramBoolean)
  {
    if (this.jdField_f_of_type_Boolean != paramBoolean)
    {
      this.jdField_f_of_type_Boolean = paramBoolean;
      d(paramView);
      e(paramView);
      f(paramView);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    b(paramBoolean, null);
  }
  
  private void d()
  {
    View localView = getView();
    String str = ((EditText)localView.findViewById(2131375513)).getText().toString();
    if (a(str) > 10)
    {
      QQToast.a(getActivity(), 2131439359, 1).a();
      a("0X8009319", 1);
      return;
    }
    if (str.length() <= 0)
    {
      QQToast.a(getActivity(), 2131439377, 1).a();
      a("0X8009319", 4);
      return;
    }
    if ((str != null) && (str.length() > 0))
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label169;
      }
      this.jdField_c_of_type_JavaLangString = str;
      ((TextView)localView.findViewById(2131375483)).setText(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      a(localView);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_e_of_type_JavaLangString = null;
      f();
      return;
      label169:
      this.jdField_d_of_type_JavaLangString = str;
    }
  }
  
  private void d(View paramView)
  {
    if (paramView != null)
    {
      paramView = (ImageView)paramView.findViewById(2131375472);
      if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)) {
        break label37;
      }
    }
    label37:
    for (int m = 0;; m = 8)
    {
      paramView.setVisibility(m);
      return;
    }
  }
  
  private void d(View paramView, boolean paramBoolean)
  {
    View localView = paramView.findViewById(2131375480);
    if (paramBoolean) {}
    for (paramView = this.jdField_b_of_type_AndroidGraphicsDrawableStateListDrawable;; paramView = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable)
    {
      localView.setBackgroundDrawable(paramView);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
  }
  
  private void e(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131375482);
    TextView localTextView1 = (TextView)paramView.findViewById(2131375483);
    TextView localTextView2 = (TextView)paramView.findViewById(2131375484);
    paramView = (TextView)paramView.findViewById(2131375485);
    if ((this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {}
    for (int m = 0;; m = 8)
    {
      localImageView.setVisibility(m);
      localTextView1.setVisibility(m);
      localTextView2.setVisibility(m);
      paramView.setVisibility(m);
      return;
    }
  }
  
  private void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    FrameLayout localFrameLayout = (FrameLayout)localFragmentActivity.findViewById(2131375512);
    EditText localEditText = (EditText)localFragmentActivity.findViewById(2131375513);
    localEditText.setText(null);
    localFrameLayout.setVisibility(8);
    ((InputMethodManager)localFragmentActivity.getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
  }
  
  private void f(View paramView)
  {
    paramView = paramView.findViewById(2131375480);
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {}
    for (int m = 8;; m = 0)
    {
      paramView.setVisibility(m);
      return;
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WorldCupShareFragment", 2, "showWaitingDialog");
    }
    ARCardLoadingProgressView localARCardLoadingProgressView = (ARCardLoadingProgressView)getView().findViewById(2131375511);
    if ((getActivity() == null) || (getActivity().isFinishing()) || (localARCardLoadingProgressView.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WorldCupShareFragment", 2, "showWaitingDialog, activity is finishing or dlg showing");
      }
      return;
    }
    localARCardLoadingProgressView.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 60000L);
  }
  
  private void g(View paramView)
  {
    paramView = paramView.findViewById(2131375509);
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      return;
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WorldCupShareFragment", 2, "dismissWaittingDialog");
    }
    ARCardLoadingProgressView localARCardLoadingProgressView = (ARCardLoadingProgressView)getView().findViewById(2131375511);
    if ((getActivity() != null) && (localARCardLoadingProgressView.getVisibility() == 0) && (!getActivity().isFinishing())) {
      localARCardLoadingProgressView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  private void h(View paramView)
  {
    Resources localResources = getResources();
    WorldCupShareInfo localWorldCupShareInfo = WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
    String str = b();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375471);
    ImageView localImageView = (ImageView)paramView.findViewById(2131375472);
    TextView localTextView1 = (TextView)paramView.findViewById(2131375477);
    TextView localTextView2 = (TextView)paramView.findViewById(2131375478);
    TextView localTextView3 = (TextView)paramView.findViewById(2131375479);
    TextView localTextView4 = (TextView)paramView.findViewById(2131375483);
    TextView localTextView5 = (TextView)paramView.findViewById(2131375484);
    TextView localTextView6 = (TextView)paramView.findViewById(2131375485);
    TextView localTextView7 = (TextView)paramView.findViewById(2131375487);
    TextView localTextView8 = (TextView)paramView.findViewById(2131375488);
    TextView localTextView9 = (TextView)paramView.findViewById(2131375489);
    TextView localTextView10 = (TextView)paramView.findViewById(2131375490);
    TextView localTextView11 = (TextView)paramView.findViewById(2131375491);
    TextView localTextView12 = (TextView)paramView.findViewById(2131375492);
    TextView localTextView13 = (TextView)paramView.findViewById(2131375494);
    TextView localTextView14 = (TextView)paramView.findViewById(2131375495);
    TextView localTextView15 = (TextView)paramView.findViewById(2131375496);
    TextView localTextView16 = (TextView)paramView.findViewById(2131375498);
    TextView localTextView17 = (TextView)paramView.findViewById(2131375500);
    TextView localTextView18 = (TextView)paramView.findViewById(2131375501);
    TextView localTextView19 = (TextView)paramView.findViewById(2131375502);
    TextView localTextView20 = (TextView)paramView.findViewById(2131375503);
    TextView localTextView21 = (TextView)paramView.findViewById(2131375504);
    View localView1 = paramView.findViewById(2131375505);
    View localView2 = paramView.findViewById(2131375506);
    View localView3 = paramView.findViewById(2131375507);
    this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(str + localWorldCupShareInfo.font_name);
    localTextView1.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView2.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView3.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView4.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView5.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView6.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView7.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView8.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView9.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView10.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView11.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView12.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView13.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView14.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView15.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView16.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView18.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView19.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView20.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView21.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localTextView17.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    localRelativeLayout.setBackgroundDrawable(new BitmapDrawable(localResources, WorldCupShareInfo.getResBitmap(str + localWorldCupShareInfo.background)));
    localImageView.setImageDrawable(new BitmapDrawable(localResources, WorldCupShareInfo.getResBitmap(this.jdField_a_of_type_JavaLangString)));
    localView1.setBackgroundDrawable(new BitmapDrawable(localResources, WorldCupShareInfo.getResBitmap(str + localWorldCupShareInfo.banner1)));
    localView2.setBackgroundDrawable(new BitmapDrawable(localResources, WorldCupShareInfo.getResBitmap(str + localWorldCupShareInfo.banner2)));
    localView3.setBackgroundDrawable(new BitmapDrawable(localResources, WorldCupShareInfo.getResBitmap(str + localWorldCupShareInfo.banner3)));
    a(paramView, localWorldCupShareInfo);
    a(localWorldCupShareInfo);
    d(paramView, false);
  }
  
  private void i()
  {
    ArMapHandler localArMapHandler = (ArMapHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2);
    Object localObject1 = new JSONObject();
    JSONObject localJSONObject1;
    Object localObject2;
    JSONObject localJSONObject2;
    Object localObject3;
    try
    {
      WorldCupShareInfo localWorldCupShareInfo = WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
      ((JSONObject)localObject1).put("share_br_icon", localWorldCupShareInfo.share_br_icon);
      ((JSONObject)localObject1).put("font_name", localWorldCupShareInfo.font_name);
      if (localWorldCupShareInfo.share.size() > 0)
      {
        localJSONObject1 = new JSONObject();
        localObject2 = (WorldCupShareInfo.Template)localWorldCupShareInfo.share.get(this.jdField_a_of_type_Int);
        localJSONObject1.put("column_image", ((WorldCupShareInfo.Template)localObject2).column_image);
        if (((WorldCupShareInfo.Template)localObject2).clothes_number.size() > 0) {
          localJSONObject1.put("clothes_number", ((WorldCupShareInfo.Template)localObject2).clothes_number.get(this.jdField_e_of_type_Int));
        }
        localJSONObject1.put("template_id", ((WorldCupShareInfo.Template)localObject2).template_id);
        Object localObject4;
        if (((WorldCupShareInfo.Template)localObject2).matches.size() > 0)
        {
          localJSONObject2 = new JSONObject();
          localObject3 = (WorldCupShareInfo.Match)((WorldCupShareInfo.Template)localObject2).matches.get(this.jdField_b_of_type_Int);
          if (((WorldCupShareInfo.Match)localObject3).social_title.size() > 0) {
            localJSONObject2.put("social_title", ((WorldCupShareInfo.Match)localObject3).social_title.get(this.jdField_g_of_type_Int));
          }
          Object localObject5;
          if (((WorldCupShareInfo.Match)localObject3).main_title.size() > 0)
          {
            localObject4 = new JSONObject();
            localObject5 = (WorldCupShareInfo.MainTitle)((WorldCupShareInfo.Match)localObject3).main_title.get(this.jdField_f_of_type_Int);
            ((JSONObject)localObject4).put("item1", ((WorldCupShareInfo.MainTitle)localObject5).item1);
            ((JSONObject)localObject4).put("item2", ((WorldCupShareInfo.MainTitle)localObject5).item2);
            localJSONObject2.put("main_title", localObject4);
          }
          localJSONObject2.put("id", ((WorldCupShareInfo.Match)localObject3).id);
          if (((WorldCupShareInfo.Match)localObject3).main_text.size() > 0)
          {
            localObject4 = new JSONObject();
            localObject5 = (WorldCupShareInfo.MainText)((WorldCupShareInfo.Match)localObject3).main_text.get(this.jdField_h_of_type_Int);
            ((JSONObject)localObject4).put("firstline", ((WorldCupShareInfo.MainText)localObject5).firstline);
            ((JSONObject)localObject4).put("title", ((WorldCupShareInfo.MainText)localObject5).title);
            ((JSONObject)localObject4).put("reporter", ((WorldCupShareInfo.MainText)localObject5).reporter);
            ((JSONObject)localObject4).put("text", ((WorldCupShareInfo.MainText)localObject5).text);
            localJSONObject2.put("main_text", localObject4);
          }
          localJSONObject2.put("title", ((WorldCupShareInfo.Match)localObject3).title);
          if (((WorldCupShareInfo.Match)localObject3).pk_title.size() > 0)
          {
            localObject4 = new JSONObject();
            localObject5 = (WorldCupShareInfo.PkTitle)((WorldCupShareInfo.Match)localObject3).pk_title.get(this.jdField_c_of_type_Int);
            ((JSONObject)localObject4).put("reporter", ((WorldCupShareInfo.PkTitle)localObject5).reporter);
            ((JSONObject)localObject4).put("main_title", ((WorldCupShareInfo.PkTitle)localObject5).main_title);
            ((JSONObject)localObject4).put("sub_title", ((WorldCupShareInfo.PkTitle)localObject5).sub_title);
            localJSONObject2.put("pk_title", localObject4);
          }
          if (((WorldCupShareInfo.Match)localObject3).clothes_text.size() > 0)
          {
            localObject4 = new JSONObject();
            localObject5 = (WorldCupShareInfo.ClothesText)((WorldCupShareInfo.Match)localObject3).clothes_text.get(this.jdField_i_of_type_Int);
            ((JSONObject)localObject4).put("title", ((WorldCupShareInfo.ClothesText)localObject5).title);
            ((JSONObject)localObject4).put("reporter", ((WorldCupShareInfo.ClothesText)localObject5).reporter);
            localJSONObject2.put("clothes_text", localObject4);
          }
          localJSONObject2.put("begin_time", ((WorldCupShareInfo.Match)localObject3).begin_time);
          localJSONObject1.put("matches", localJSONObject2);
        }
        localJSONObject1.put("banner2", localWorldCupShareInfo.banner2);
        localJSONObject1.put("nick", this.jdField_c_of_type_JavaLangString);
        localJSONObject1.put("news_paper_title_list", ((WorldCupShareInfo.Template)localObject2).news_paper_title_list);
        localJSONObject1.put("peernick", this.jdField_d_of_type_JavaLangString);
        localJSONObject1.put("date", ((WorldCupShareInfo.Template)localObject2).date);
        localJSONObject1.put("banner1", localWorldCupShareInfo.banner1);
        if (((WorldCupShareInfo.Template)localObject2).color_scheme.size() > 0)
        {
          localJSONObject2 = new JSONObject();
          localObject2 = (WorldCupShareInfo.ColorScheme)((WorldCupShareInfo.Template)localObject2).color_scheme.get(this.jdField_d_of_type_Int);
          localJSONObject2.put("social_title_background_color", ((WorldCupShareInfo.ColorScheme)localObject2).news_paper_background_color);
          localJSONObject2.put("date_color", ((WorldCupShareInfo.ColorScheme)localObject2).date_color);
          localObject3 = new JSONArray();
          localObject4 = ((WorldCupShareInfo.ColorScheme)localObject2).title_background_color.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ((JSONArray)localObject3).put((String)((Iterator)localObject4).next());
            continue;
            localObject1 = ((JSONObject)localObject1).toString();
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("WorldCupShareFragment", 1, "WL_DEBUG SetWorldCupInfo e = " + localJSONException);
    }
    for (;;)
    {
      QLog.d("WorldCupShareFragment", 1, "WL_DEBUG SetWorldCupInfo config = " + (String)localObject1);
      localArMapHandler.a(this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, (String)localObject1);
      return;
      localJSONObject2.put("title_background_color", localObject3);
      localJSONObject2.put("news_paper_background_color", ((WorldCupShareInfo.ColorScheme)localObject2).social_title_background_color);
      localJSONObject2.put("matches_title_color", ((WorldCupShareInfo.ColorScheme)localObject2).matches_title_color);
      localJSONObject1.put("color_scheme", localJSONObject2);
      localJSONObject1.put("banner3", localJSONException.banner3);
      localJSONObject1.put("create_time", String.valueOf(this.jdField_c_of_type_Long));
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString.split("/");
        if ((localObject2 != null) && (localObject2.length > 0)) {
          localJSONObject1.put("video_cover", localObject2[(localObject2.length - 1)]);
        }
      }
      ((JSONObject)localObject1).put("share", localJSONObject1);
      ((JSONObject)localObject1).put("background", localJSONException.background);
    }
  }
  
  private void i(View paramView)
  {
    if ((this.jdField_i_of_type_Boolean) && (this.jdField_g_of_type_Boolean) && (paramView != null)) {
      b(paramView);
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.ar.worldcup.finishScanTorch");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  protected void a(long paramLong)
  {
    ((ARCardLoadingProgressView)getView().findViewById(2131375511)).setTotalProgress((int)(100L * paramLong / this.jdField_d_of_type_Long));
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    paramActivity.getWindow().setSoftInputMode(18);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    FragmentActivity localFragmentActivity = getActivity();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = localFragmentActivity.getString(2131430108);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = localFragmentActivity.getString(2131430114);
    localActionSheetItem.jdField_b_of_type_Int = 2130838337;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = localFragmentActivity.getString(2131430126);
    localActionSheetItem.jdField_b_of_type_Int = 2130838340;
    localActionSheetItem.jdField_c_of_type_Int = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = localFragmentActivity.getString(2131430127);
    localActionSheetItem.jdField_b_of_type_Int = 2130838334;
    localActionSheetItem.jdField_c_of_type_Int = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  void b()
  {
    if (!new File(this.jdField_b_of_type_JavaLangString).exists())
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131435624, 0).a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.postImmediately(new akyr(this), null, true);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    QLog.i("WorldCupShareFragment", 2, "WL_DEBUG downloadRes begin");
    WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 2);
    WorldCupMgr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr$DownloadListener);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  public boolean d()
  {
    if (((FrameLayout)getActivity().findViewById(2131375512)).getVisibility() == 0) {
      f();
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        BaseApplication localBaseApplication = BaseApplication.getContext();
        Intent localIntent = new Intent(localBaseApplication, SplashActivity.class);
        localIntent.setFlags(268468224);
        localBaseApplication.startActivity(localIntent);
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public boolean e()
  {
    boolean bool = WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(2);
    QLog.i("WorldCupShareFragment", 2, "WL_DEBUG isResReady = " + bool);
    return bool;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    View localView = getView();
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return false;
          QLog.d("WorldCupShareFragment", 1, "WL_DEBUG handleMessage MSG_PLAY_VIDEO");
          if (getActivity().isResume()) {
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
          }
        } while (localView == null);
        if (!this.jdField_c_of_type_Boolean) {}
        for (boolean bool = true;; bool = false)
        {
          a(localView, bool);
          return false;
        }
      } while ((localView == null) || (((ARCardLoadingProgressView)localView.findViewById(2131375511)).getVisibility() != 0));
      h();
      QQToast.a(BaseApplication.getContext(), 1, 2131439375, 0).a();
      return false;
    }
    this.jdField_b_of_type_JavaLangString = VideoProcessor.a(0);
    if (FileUtil.a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_c_of_type_Boolean = true;
    }
    j();
    b(true, localView);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 21: 
      QRUtils.a(2, 2131435089);
      a("0X800931F", 1);
      return;
    }
    QRUtils.a(2, 2131435089);
    a("0X800931F", 2);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (getActivity() != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().getAppInterface();
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    FragmentActivity localFragmentActivity = getActivity();
    View localView = getView();
    switch (paramView.getId())
    {
    case 2131375512: 
    case 2131375513: 
    default: 
    case 2131363245: 
    case 2131375480: 
    case 2131375483: 
    case 2131375488: 
    case 2131375494: 
    case 2131375498: 
    case 2131375500: 
    case 2131375509: 
      do
      {
        return;
        localFragmentActivity.onBackPressed();
        return;
        QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onClick world_cup_share_mute");
        if (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute()) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(bool1);
          d(localView, bool1);
          return;
          bool1 = false;
        }
        a(true);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      if (!b(this.jdField_g_of_type_JavaLangString)) {
        b();
      }
      for (;;)
      {
        a("0X800931B");
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 2, getString(2131439376), 1).b(getActivity().getTitleBarHeight());
      }
    case 2131375510: 
      if (NetworkUtil.e(localFragmentActivity)) {
        if ((this.jdField_f_of_type_JavaLangString == null) && (this.jdField_c_of_type_Boolean))
        {
          g();
          if (!a(this.jdField_b_of_type_JavaLangString)) {
            h();
          }
        }
      }
      for (;;)
      {
        a("0X800931D");
        return;
        if (this.jdField_e_of_type_JavaLangString == null)
        {
          g();
          i();
        }
        else
        {
          e();
          continue;
          QQToast.a(BaseApplication.getContext(), 1, 2131439375, 0).a();
        }
      }
    case 2131362669: 
      if (!this.jdField_e_of_type_Boolean) {}
      for (bool1 = bool2;; bool1 = false)
      {
        b(localView, bool1);
        return;
      }
    case 2131371712: 
      f();
      return;
    case 2131371713: 
      d();
      return;
    }
    a(false);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onCompletion");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader = new NonMainAppHeadLoader(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), 1);
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
      paramBundle = (ArMapHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2);
      paramBundle.b();
      this.jdField_c_of_type_JavaLangString = ConfessShareHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_d_of_type_JavaLangString = paramBundle.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_JavaLangString = ARWorldCupRecordController.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = ARWorldCupRecordController.jdField_b_of_type_JavaLangString;
    c(ARWorldCupRecordController.jdField_a_of_type_Boolean);
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG mCoverPath = " + this.jdField_a_of_type_JavaLangString + ", mVideoPath = " + this.jdField_b_of_type_JavaLangString + ", mIsMergeFinish = " + this.jdField_g_of_type_Boolean);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.ar.worldcup.record");
    try
    {
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject1 = null;
    int m;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if (paramBundle != null)
      {
        if (this.jdField_b_of_type_JavaLangString == null) {
          this.jdField_b_of_type_JavaLangString = paramBundle.getString("videoPath");
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          this.jdField_a_of_type_JavaLangString = paramBundle.getString("coverPath");
        }
        if (!this.jdField_g_of_type_Boolean) {
          c(paramBundle.getBoolean("isMergeFinish"));
        }
      }
      localObject1 = getActivity();
      paramBundle = getResources();
      localObject1 = (WindowManager)((Activity)localObject1).getSystemService("window");
      Object localObject2 = c();
      int n = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
      m = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.a((String)localObject1, true);
      localObject1 = paramLayoutInflater.inflate(a(0), paramViewGroup, false);
      a((String)localObject2, (View)localObject1);
      RelativeLayout localRelativeLayout = (RelativeLayout)((View)localObject1).findViewById(2131375471);
      ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131375472);
      View localView1 = ((View)localObject1).findViewById(2131375473);
      View localView2 = ((View)localObject1).findViewById(2131375474);
      View localView3 = ((View)localObject1).findViewById(2131375475);
      View localView4 = ((View)localObject1).findViewById(2131375476);
      TextView localTextView18 = (TextView)((View)localObject1).findViewById(2131375477);
      TextView localTextView19 = (TextView)((View)localObject1).findViewById(2131375478);
      TextView localTextView20 = (TextView)((View)localObject1).findViewById(2131375479);
      paramLayoutInflater = ((View)localObject1).findViewById(2131375480);
      LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject1).findViewById(2131375481);
      ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131375482);
      TextView localTextView21 = (TextView)((View)localObject1).findViewById(2131375483);
      LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject1).findViewById(2131375486);
      Object localObject5 = (TextView)((View)localObject1).findViewById(2131375487);
      Object localObject3 = (TextView)((View)localObject1).findViewById(2131375488);
      TextView localTextView11 = (TextView)((View)localObject1).findViewById(2131375489);
      TextView localTextView12 = (TextView)((View)localObject1).findViewById(2131375490);
      TextView localTextView13 = (TextView)((View)localObject1).findViewById(2131375491);
      TextView localTextView14 = (TextView)((View)localObject1).findViewById(2131375492);
      LinearLayout localLinearLayout3 = (LinearLayout)((View)localObject1).findViewById(2131375493);
      TextView localTextView15 = (TextView)((View)localObject1).findViewById(2131375494);
      TextView localTextView16 = (TextView)((View)localObject1).findViewById(2131375495);
      TextView localTextView17 = (TextView)((View)localObject1).findViewById(2131375496);
      View localView5 = ((View)localObject1).findViewById(2131375497);
      TextView localTextView5 = (TextView)((View)localObject1).findViewById(2131375498);
      View localView6 = ((View)localObject1).findViewById(2131375499);
      TextView localTextView6 = (TextView)((View)localObject1).findViewById(2131375500);
      TextView localTextView7 = (TextView)((View)localObject1).findViewById(2131375501);
      TextView localTextView8 = (TextView)((View)localObject1).findViewById(2131375502);
      TextView localTextView9 = (TextView)((View)localObject1).findViewById(2131375503);
      TextView localTextView10 = (TextView)((View)localObject1).findViewById(2131375504);
      View localView7 = ((View)localObject1).findViewById(2131375505);
      View localView8 = ((View)localObject1).findViewById(2131375506);
      View localView9 = ((View)localObject1).findViewById(2131375507);
      ImageView localImageView3 = (ImageView)((View)localObject1).findViewById(2131375470);
      paramViewGroup = (TextView)((View)localObject1).findViewById(2131363245);
      TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131375509);
      TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131375510);
      ARCardLoadingProgressView localARCardLoadingProgressView = (ARCardLoadingProgressView)((View)localObject1).findViewById(2131375511);
      FrameLayout localFrameLayout = (FrameLayout)((View)localObject1).findViewById(2131375512);
      EditText localEditText = (EditText)((View)localObject1).findViewById(2131375513);
      TextView localTextView3 = (TextView)((View)localObject1).findViewById(2131371712);
      TextView localTextView4 = (TextView)((View)localObject1).findViewById(2131371713);
      localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      m -= AIOUtils.a(128.0F, paramBundle);
      if (localLayoutParams.height * n <= localLayoutParams.width * m) {
        break label1957;
      }
      int i1 = localLayoutParams.height;
      n = m;
      m = i1;
      this.jdField_j_of_type_Int = n;
      this.jdField_k_of_type_Int = m;
      a(localRelativeLayout, n, m);
      a(localImageView1, n, m);
      a(localView1, n, m);
      a(localView2, n, m);
      a(localView3, n, m);
      a(localView4, n, m);
      a(localTextView18, n, m);
      a(localTextView19, n, m);
      a(localTextView20, n, m);
      a(paramLayoutInflater, n, m);
      b(localLinearLayout1, n, m);
      b(localImageView2, n, m);
      a(localTextView21, n, m);
      a(localLinearLayout2, n, m);
      a(localTextView13, n, m);
      a(localTextView14, n, m);
      a(localLinearLayout3, n, m);
      a(localTextView5, n, m);
      a(localTextView7, n, m);
      a(localTextView8, n, m);
      a(localTextView9, n, m);
      a(localTextView10, n, m);
      a(localView5, n, m);
      a(localView6, n, m);
      a(localTextView6, n, m);
      a(localView7, n, m);
      a(localView8, n, m);
      a(localImageView3, n, m);
      a(localView9, n, m);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_JavaLangString.length() > 0) {
          bool1 = new File(this.jdField_b_of_type_JavaLangString).exists();
        }
      }
      if (bool1)
      {
        this.jdField_c_of_type_Boolean = true;
        j();
      }
      QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onCreateView mIsRecordSuccess = " + this.jdField_c_of_type_Boolean);
      a((View)localObject1, n, m);
      localTextView18.setTextSize(0, n * 12 / m);
      localTextView19.setTextSize(0, n * 34 / m);
      localTextView20.setTextSize(0, n * 12 / m);
      localImageView2.setImageDrawable(new BitmapDrawable(paramBundle, (Bitmap)localObject4));
      i1 = n * 4 / m + 11;
      localImageView2.setPadding(i1, i1, i1, i1);
      localTextView21.setOnClickListener(this);
      localTextView21.setTextSize(0, n * 74 / m);
      localTextView21.setSpannableFactory(QQText.a);
      localTextView21.setText(this.jdField_c_of_type_JavaLangString);
      ((TextView)localObject5).setTextSize(0, n * 34 / m);
      localObject4 = (LinearLayout.LayoutParams)((TextView)localObject5).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).height = (((LinearLayout.LayoutParams)localObject4).height * n / m);
      ((LinearLayout.LayoutParams)localObject4).bottomMargin = (((LinearLayout.LayoutParams)localObject4).bottomMargin * n / m);
      ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((TextView)localObject5).setPadding(0, n * 2 / m, 0, 0);
      localObject5 = new int[2][];
      localObject5[0] = { 16842919 };
      localObject5[1] = new int[0];
      localObject4 = new ColorStateList((int[][])localObject5, new int[] { -2147483648, -16777216 });
      ((TextView)localObject3).setSpannableFactory(QQText.a);
      ((TextView)localObject3).setTextSize(0, n * 30 / m);
      ((TextView)localObject3).setOnClickListener(this);
      ((TextView)localObject3).setTextColor((ColorStateList)localObject4);
      localTextView11.setSpannableFactory(QQText.a);
      localTextView11.setTextSize(0, n * 30 / m);
      localTextView12.setSpannableFactory(QQText.a);
      localTextView12.setTextSize(0, n * 30 / m);
      localTextView12.setOnClickListener(this);
      localTextView12.setTextColor((ColorStateList)localObject4);
      a((View)localObject1);
      localTextView13.setTextSize(0, n * 13 / m);
      localTextView14.setTextSize(0, n * 13 / m);
      localTextView15.setSpannableFactory(QQText.a);
      localTextView15.setTextSize(0, n * 30 / m);
      localTextView15.setOnClickListener(this);
      localTextView15.setTextColor((ColorStateList)localObject4);
      localTextView16.setTextSize(0, n * 30 / m);
      localTextView17.setTextSize(0, n * 13 / m);
      localObject3 = new ColorStateList((int[][])localObject5, new int[] { -2130706433, -1 });
      localTextView5.setSpannableFactory(QQText.a);
      localTextView5.setTextSize(0, n * 16 / m);
      localTextView5.setOnClickListener(this);
      localTextView5.setTextColor((ColorStateList)localObject3);
      localTextView7.setTextSize(0, n * 30 / m);
      localTextView8.setTextSize(0, n * 13 / m);
      localTextView9.setTextSize(0, n * 13 / m);
      localTextView10.setTextSize(0, n * 13 / m);
      localTextView6.setSpannableFactory(QQText.a);
      localTextView6.setTextSize(0, n * 30 / m);
      localTextView6.setOnClickListener(this);
      localTextView6.setTextColor((ColorStateList)localObject4);
      localObject2 = WorldCupShareInfo.getResBitmap((String)localObject2 + "default_background.png");
      if (localObject2 == null) {
        break label1967;
      }
      ((View)localObject1).setBackgroundDrawable(new BitmapDrawable(paramBundle, (Bitmap)localObject2));
      label1812:
      paramViewGroup.setOnClickListener(this);
      paramLayoutInflater.setOnClickListener(this);
      d((View)localObject1, false);
      localTextView1.setOnClickListener(this);
      localTextView2.setOnClickListener(this);
      localARCardLoadingProgressView.setScale(ScreenUtil.jdField_a_of_type_Int);
      localARCardLoadingProgressView.setOnClickListener(this);
      localEditText.setOnClickListener(this);
      localFrameLayout.setOnClickListener(this);
      localEditText.setFilters(new InputFilter[] { new WorldCupShareFragment.LengthFilter(this, 10) });
      localEditText.setOnEditorActionListener(this);
      localEditText.setSpannableFactory(QQText.a);
      localEditText.addTextChangedListener(this);
      localTextView3.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      if (!e()) {
        break label1978;
      }
      a(true, (View)localObject1);
    }
    for (;;)
    {
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 40000L);
      }
      return localObject1;
      label1957:
      m = localLayoutParams.width;
      break;
      label1967:
      ((View)localObject1).setBackgroundColor(-16777216);
      break label1812;
      label1978:
      c();
    }
  }
  
  public void onDestroy()
  {
    int m = 0;
    super.onDestroy();
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onDestroy");
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.b(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader.b();
    }
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
    long l;
    label212:
    HashMap localHashMap;
    if ((FileUtil.a(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaLangString.contains("game")))
    {
      ThreadManager.postImmediately(new akyj(this), null, false);
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      }
      WorldCupMgr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr$DownloadListener);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_b_of_type_AndroidGraphicsDrawableStateListDrawable = null;
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = null;
      if (this.jdField_b_of_type_Long != 0L) {
        break label311;
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      localHashMap = new HashMap();
      if (m == 0) {
        break label326;
      }
    }
    label311:
    label326:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isShowPaper", str);
      localHashMap.put("loadingCost", String.valueOf(l));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "worldcup_paper", true, 0L, 1L, localHashMap, "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WorldCupShareFragment", 2, String.format("not need to delete, %s", new Object[] { this.jdField_b_of_type_JavaLangString }));
      break;
      l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      m = 1;
      break label212;
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramTextView.getId() == 2131375513) && (paramInt == 6)) {
      d();
    }
    return true;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onError errorType = " + paramInt1 + ", errorCode = " + paramInt2 + ", extra = " + paramInt3 + ", detailInfo = " + paramString);
    return false;
  }
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    QLog.i("WorldCupShareFragment", 1, "WL_DEBUG onFailed arg0 = " + paramInt);
    if (getActivity() != null) {
      getActivity().runOnUiThread(new akyk(this));
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
    }
    paramView = getActivity();
    Object localObject;
    switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.jdField_c_of_type_Int)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
      paramView = WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
      paramAdapterView = new Bundle();
      paramAdapterView.putBoolean("key_flag_from_plugin", true);
      paramAdapterView.putString("pluginName", "web_share");
      paramAdapterView.putString("struct_share_key_source_icon", paramView.AIOMsgSrcIconUrl);
      paramAdapterView.putString("app_name", paramView.AIOMsgSrcName);
      paramAdapterView.putString("struct_share_key_source_action", "web");
      paramAdapterView.putString("struct_share_key_source_url", paramView.AIOMsgSrcJumpUrl);
      paramAdapterView.putString("detail_url", this.jdField_e_of_type_JavaLangString);
      localObject = this.jdField_c_of_type_JavaLangString + paramView.AIOMsgTitle;
      paramAdapterView.putString("title", (String)localObject);
      paramAdapterView.putString("desc", paramView.AIOMsgSummary);
      paramAdapterView.putString("struct_share_key_content_action", "web");
      paramAdapterView.putInt("forward_type", 1001);
      paramAdapterView.putString("image_url_remote", paramView.AIOMsgImageUrl);
      paramAdapterView.putString("new_share_service_id", "83");
      paramAdapterView.putString("openerProc", MobileQQ.getMobileQQ().getProcessName());
      paramAdapterView.putBoolean("k_back", true);
      paramAdapterView.putString("brief_key", getString(2131430117, new Object[] { localObject }));
      paramView = StructMsgFactory.a(paramAdapterView);
      paramView.mMsgServiceID = 83;
      paramAdapterView.putByteArray("stuctmsg_bytes", paramView.getBytes());
      paramView = new Intent();
      paramView.putExtras(paramAdapterView);
      paramView.putExtra("is_need_show_toast", false);
      ForwardBaseOption.a(getActivity(), paramView, 21);
      a("0X800931E", 1);
      return;
    case 3: 
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(getView());
      }
      if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_h_of_type_Boolean = true;
        paramAdapterView = a();
        paramView = paramView.getString(2131439358);
        localObject = QZoneHelper.UserInfo.a();
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
        {
          ((QZoneHelper.UserInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
          ((QZoneHelper.UserInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getDisplayName(0, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
        }
        QZoneHelper.a(getActivity(), (QZoneHelper.UserInfo)localObject, paramAdapterView, BaseApplication.getContext().getString(2131429969), paramView, 1);
      }
      a("0X800931E", 2);
      return;
    case 9: 
      if (!WXShareHelper.a().a()) {
        QQToast.a(paramView, 2131435319, 1).a();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
          this.jdField_a_of_type_AndroidGraphicsBitmap = a(getView());
        }
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
          ThreadManager.postImmediately(new akyl(this), null, true);
        }
        a("0X800931E", 3);
        return;
        if (!WXShareHelper.a().b()) {
          QQToast.a(paramView, 2131435320, 1).a();
        }
      }
    }
    if (!WXShareHelper.a().a()) {
      QQToast.a(paramView, 2131435319, 1).a();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(getView());
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        ThreadManager.postImmediately(new akyo(this), null, true);
      }
      a("0X800931E", 4);
      return;
      if (!WXShareHelper.a().b()) {
        QQToast.a(paramView, 2131435320, 1).a();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onPause");
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onResume");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      if (this.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)this.jdField_e_of_type_Long);
      }
    }
    this.jdField_h_of_type_Boolean = false;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null)
    {
      paramBundle.putString("videoPath", this.jdField_b_of_type_JavaLangString);
      paramBundle.putString("coverPath", this.jdField_a_of_type_JavaLangString);
      paramBundle.putBoolean("isMergeFinish", this.jdField_g_of_type_Boolean);
    }
    StringBuilder localStringBuilder = new StringBuilder().append("WL_DEBUG onSaveInstanceState outState != null = ");
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("WorldCupShareFragment", 1, bool + ", mVideoPath = " + this.jdField_b_of_type_JavaLangString + ", mCoverPath = " + this.jdField_a_of_type_JavaLangString + ", mIsMergeFinish = " + this.jdField_g_of_type_Boolean);
      return;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    QLog.i("WorldCupShareFragment", 1, "WL_DEBUG onSuccess");
    paramHashMap = new Bdh_extinfo.CommFileExtRsp();
    try
    {
      paramArrayOfByte = (Bdh_extinfo.CommFileExtRsp)paramHashMap.mergeFrom(paramArrayOfByte);
      this.jdField_f_of_type_JavaLangString = paramArrayOfByte.bytes_download_url.get().toStringUtf8();
      QLog.i("WorldCupShareFragment", 1, "WL_DEBUG onSuccess url = " + this.jdField_f_of_type_JavaLangString);
      i();
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onSurfaceChanged");
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onSurfaceCreated");
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onSurfaceDestory");
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void onSwitch2BackupChannel()
  {
    QLog.i("WorldCupShareFragment", 1, "WL_DEBUG onSwitch2BackupChannel");
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (a(paramCharSequence.toString()) > 0)
    {
      paramCharSequence = (TextView)getView().findViewById(2131371713);
      paramCharSequence.setTextColor(Color.parseColor("#12b7f5"));
      paramCharSequence.setEnabled(true);
    }
  }
  
  public void onTransStart()
  {
    QLog.i("WorldCupShareFragment", 1, "WL_DEBUG onTransStart");
  }
  
  public void onUpdateProgress(int paramInt)
  {
    QLog.i("WorldCupShareFragment", 1, "WL_DEBUG onUpdateProgress transferedSize = " + paramInt);
    a(paramInt);
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("WorldCupShareFragment", 1, "WL_DEBUG onVideoPrepared");
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.WorldCupShareFragment
 * JD-Core Version:    0.7.0.1
 */