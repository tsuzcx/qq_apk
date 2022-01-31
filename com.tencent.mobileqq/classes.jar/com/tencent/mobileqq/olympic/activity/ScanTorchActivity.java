package com.tencent.mobileqq.olympic.activity;

import agex;
import agey;
import agez;
import agfa;
import agfb;
import agfg;
import agfh;
import agfi;
import agfj;
import agfk;
import agfl;
import agfm;
import agfn;
import agfo;
import agfp;
import agfq;
import agfr;
import agfs;
import agft;
import agfu;
import agfv;
import agfw;
import agfx;
import agfy;
import agfz;
import agga;
import aggb;
import aggc;
import aggd;
import agge;
import aggf;
import aggg;
import aggh;
import aggi;
import aggj;
import aggl;
import aggm;
import aggn;
import aggo;
import aggp;
import aggq;
import aggs;
import aggt;
import aggu;
import aggv;
import aghb;
import aghc;
import aghd;
import aghe;
import aghf;
import aghg;
import aghh;
import aghi;
import aghj;
import aghk;
import aghl;
import agho;
import aghs;
import aghu;
import aghv;
import aghw;
import aghx;
import agig;
import agih;
import agii;
import agij;
import agil;
import agim;
import agin;
import agio;
import agip;
import agiq;
import agis;
import agit;
import agiu;
import agiv;
import agiw;
import agix;
import agiz;
import agja;
import agjb;
import agjc;
import agjd;
import agje;
import agjf;
import agjg;
import agjh;
import agji;
import agjj;
import agjk;
import agjl;
import agjn;
import agjo;
import agjp;
import agjq;
import agjr;
import agjs;
import agjt;
import agju;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARGlobalRemoteManager;
import com.tencent.mobileqq.ar.ARLBSPOIDialog;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;
import com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupRecordController;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable.IWorldCupGameEndCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.ARScanFragment.ARScanFragmentCallback;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.DrawView2.FaceData;
import com.tencent.mobileqq.ar.FaceScanModelsLoader;
import com.tencent.mobileqq.ar.FaceScanNativeSoLoader;
import com.tencent.mobileqq.ar.FaceUIController;
import com.tencent.mobileqq.ar.NeonControl;
import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.WorldCupResPath;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult.POIInfo;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalRecogResultBase;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.MIGObjectSearchResult;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload;
import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload.DownloadListener;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupReport;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.arcard.ARCardHeadIconManager;
import com.tencent.mobileqq.arcard.ARCardUtils;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.mobileqq.armap.ARMapOpenCardDialog;
import com.tencent.mobileqq.armap.ARMapOpenKaquanDialog;
import com.tencent.mobileqq.armap.ARMapOpenRedPackDialog;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.FrameBmpCache.EndListener;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.armap.SdCardImageAnimView;
import com.tencent.mobileqq.binhai.BinHaiConstants;
import com.tencent.mobileqq.binhai.BinHaiConstants.FrameAnimCallback;
import com.tencent.mobileqq.binhai.BinHaiConstants.FrameAnimConfig;
import com.tencent.mobileqq.binhai.BinHaiFuDaiProgressView;
import com.tencent.mobileqq.binhai.BinHaiHandler;
import com.tencent.mobileqq.binhai.BinHaiMsgDialog;
import com.tencent.mobileqq.binhai.BinHaiMsgDialog.Listener;
import com.tencent.mobileqq.binhai.BinHaiObserver;
import com.tencent.mobileqq.binhai.BinHaiOpenRedPackDialog;
import com.tencent.mobileqq.binhai.BinHaiProgressView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity.OcrResultCache;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.mobileqq.olympic.view.ScannerAnimView;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.mobileqq.worldcup.ARWorldCupGameTouchView;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.QQBroadcastReceiver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ScanTorchActivity
  extends OlympicToolBaseActivity
  implements Handler.Callback, View.OnClickListener, ARWorldCupGlobalSceneRenderable.IWorldCupGameEndCallBack, ARScanFragment.ARScanFragmentCallback, AREngineCallback, ScreenshotObserver.Listener
{
  public static boolean h;
  public static boolean i;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I = true;
  private boolean J;
  private boolean K;
  private boolean L;
  private boolean M;
  private boolean N;
  private boolean O;
  private boolean P;
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T;
  private boolean U;
  private boolean V;
  private boolean W;
  private boolean X;
  private boolean Y = true;
  private boolean Z;
  public int a;
  public long a;
  agjr jdField_a_of_type_Agjr = null;
  agjt jdField_a_of_type_Agjt = new agjt();
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new aghb(this);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aghk(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  private SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aggq(this, 3, true, true, 60000L, false, false, "ShopScan");
  public ARArguments a;
  private ARLBSPOIDialog jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog;
  private ARVideoRecordViewProxy jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy;
  public ARScanFragment a;
  private ARTarget jdField_a_of_type_ComTencentMobileqqArARTarget;
  public FaceUIController a;
  public ObjectSurfaceView a;
  public RemoteArConfigManager a;
  public ScanningSurfaceView a;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  private ArEffectConfig jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  ARWorldCupBaseResDownload.DownloadListener jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener = new agjn(this);
  private ARWorldCupBaseResDownload jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload;
  private ARCardHeadIconManager jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager;
  ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new aggv(this);
  public ScanSuccessView a;
  private BinHaiConstants.FrameAnimConfig jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiConstants$FrameAnimConfig;
  private BinHaiFuDaiProgressView jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiFuDaiProgressView;
  private BinHaiMsgDialog.Listener jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener;
  private BinHaiMsgDialog jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog;
  private BinHaiObserver jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiObserver;
  private BinHaiOpenRedPackDialog jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private OcrControl jdField_a_of_type_ComTencentMobileqqOcrOcrControl;
  private ScanOcrActivity.OcrResultCache jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache;
  private ARTipsManager jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager;
  private ScreenshotObserver jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver;
  public ScanIconAnimateView a;
  private ScannerAnimView jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView;
  private StrokeTextView jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private ARWorldCupGameTouchView jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView;
  private MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public HashMap a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private QQBroadcastReceiver jdField_a_of_type_MqqAppQQBroadcastReceiver = new aggp(this);
  private boolean aa;
  private boolean ab;
  private boolean ac;
  private boolean ad;
  private volatile boolean ae = true;
  private boolean af;
  private boolean ag;
  private boolean ah;
  private boolean ai;
  private boolean aj;
  private boolean ak;
  private boolean al;
  private boolean am;
  private boolean an;
  private boolean ao;
  private boolean ap;
  private boolean aq;
  private boolean ar;
  private boolean as;
  private boolean at;
  private boolean au;
  private boolean av;
  public int b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  public TextView b;
  private TouchWebView jdField_b_of_type_ComTencentBizUiTouchWebView;
  private ArCloudConfigInfo jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private ScanSuccessView jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView;
  private BinHaiMsgDialog.Listener jdField_b_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener;
  private ARTipsManager jdField_b_of_type_ComTencentMobileqqOlympicActivityARTipsManager;
  public QQCustomDialog b;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  public String b;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  int jdField_c_of_type_Int = -1;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  public String c;
  int jdField_d_of_type_Int;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_d_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public int e;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_e_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int;
  long jdField_f_of_type_Long = 0L;
  private FrameLayout jdField_f_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private int jdField_g_of_type_Int;
  long jdField_g_of_type_Long = -1L;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int;
  private long jdField_h_of_type_Long = -1L;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private long jdField_i_of_type_Long = -1L;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long = -1L;
  private ImageView jdField_j_of_type_AndroidWidgetImageView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString;
  public boolean j;
  private int jdField_k_of_type_Int;
  private long jdField_k_of_type_Long;
  private ImageView jdField_k_of_type_AndroidWidgetImageView;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private String jdField_k_of_type_JavaLangString;
  boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int;
  private long jdField_l_of_type_Long;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private String jdField_l_of_type_JavaLangString;
  public boolean l;
  private int jdField_m_of_type_Int = 30;
  private long jdField_m_of_type_Long;
  private ImageView jdField_m_of_type_AndroidWidgetImageView;
  private String jdField_m_of_type_JavaLangString;
  public boolean m;
  private int jdField_n_of_type_Int;
  private long jdField_n_of_type_Long;
  private ImageView jdField_n_of_type_AndroidWidgetImageView;
  private String jdField_n_of_type_JavaLangString;
  public volatile boolean n;
  private int jdField_o_of_type_Int = 3;
  private long jdField_o_of_type_Long;
  private ImageView jdField_o_of_type_AndroidWidgetImageView;
  private String jdField_o_of_type_JavaLangString;
  volatile boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int = 1;
  private long jdField_p_of_type_Long;
  private ImageView jdField_p_of_type_AndroidWidgetImageView;
  private String jdField_p_of_type_JavaLangString;
  volatile boolean jdField_p_of_type_Boolean = false;
  private int jdField_q_of_type_Int = 5;
  private long jdField_q_of_type_Long;
  boolean jdField_q_of_type_Boolean = false;
  private long jdField_r_of_type_Long;
  boolean jdField_r_of_type_Boolean = false;
  private long s;
  public boolean s;
  private long t;
  public boolean t;
  private long jdField_u_of_type_Long;
  private boolean jdField_u_of_type_Boolean;
  private long jdField_v_of_type_Long;
  private boolean jdField_v_of_type_Boolean;
  private long jdField_w_of_type_Long = 1L;
  private boolean jdField_w_of_type_Boolean;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public ScanTorchActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_s_of_type_Long = 1000L;
    this.jdField_e_of_type_Int = 0;
  }
  
  private void A()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362840));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131362594));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370939));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370940));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370941));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370902));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370924));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370925));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370926));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370917));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370920));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView = ((ScanIconAnimateView)findViewById(2131370921));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370923));
    Object localObject = (ViewStub)findViewById(2131370943);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy = new ARVideoRecordViewProxy(findViewById(2131363278));
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.setPopUpListener(new agiw(this));
    if (d())
    {
      this.jdField_n_of_type_Boolean = true;
      Looper.myQueue().addIdleHandler(new agji(this));
    }
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370935));
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370937));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370936));
    this.jdField_i_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(new agey(this));
    as();
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView = ((ScannerAnimView)findViewById(2131370933));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.setOnScanAnimEndListener(new agez(this));
    B();
    if (!this.I)
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setText(2131429931);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131364690));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i1 = ImmersiveUtils.a(this);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131370914));
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView = ((ARWorldCupGameTouchView)findViewById(2131370934));
    ARWorldCupGameLogicManager.a().a(findViewById(2131370916));
  }
  
  private void B()
  {
    ImmersiveUtils.a();
    ImmersiveUtils.b();
    Object localObject = getResources().getDisplayMetrics();
    int i2;
    int i1;
    if (((DisplayMetrics)localObject).widthPixels < ((DisplayMetrics)localObject).heightPixels)
    {
      i2 = ((DisplayMetrics)localObject).widthPixels;
      i1 = ((DisplayMetrics)localObject).heightPixels;
    }
    for (;;)
    {
      int i3 = i1;
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        i3 = i1 - ImmersiveUtils.a(this);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, String.format("initQrScanRectDisplay screenWidth=%s, screenHeight=%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
      int i4 = (int)(ScanEntranceDPC.a().jdField_a_of_type_Float * Math.min(i3, i2));
      i1 = i4;
      if (i4 <= 0) {
        i1 = AIOUtils.a(252.0F, getResources());
      }
      i3 = (i3 - i1 - AIOUtils.a(45.0F, getResources())) / 2;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, i1, i1);
      this.jdField_a_of_type_AndroidGraphicsRect.offset(i2 / 2 - this.jdField_a_of_type_AndroidGraphicsRect.centerX(), i3);
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.setBoxRect(this.jdField_a_of_type_AndroidGraphicsRect);
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, String.format("initQrScanRectDisplay mScanRect=%s", new Object[] { this.jdField_a_of_type_AndroidGraphicsRect }));
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.jdField_a_of_type_AndroidGraphicsRect.bottom - AIOUtils.a(65.0F, getResources()));
      this.jdField_d_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i1 = ((DisplayMetrics)localObject).widthPixels;
      i2 = ((DisplayMetrics)localObject).heightPixels;
    }
  }
  
  private void C() {}
  
  private void D()
  {
    long l1 = System.currentTimeMillis();
    ViewStub localViewStub = (ViewStub)findViewById(2131370938);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView = ((ScanningSurfaceView)super.findViewById(2131363276));
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController = new FaceUIController(this, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager);
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.jdField_a_of_type_ComTencentMobileqqArFaceUIController = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
      this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView = ((ObjectSurfaceView)super.findViewById(2131363277));
      this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqArFaceUIController = new FaceUIController(this, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager);
      this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.jdField_a_of_type_ComTencentMobileqqArFaceUIController = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131363271));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363272));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363273));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363274));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131363275));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      J();
      L();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        int i1 = ImmersiveUtils.a(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(0, i1, 0, 0);
      }
      F();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("lazyInitARView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
    if (QLog.isColorLevel()) {}
  }
  
  private void E()
  {
    if (this.jdField_b_of_type_ComTencentBizUiTouchWebView == null)
    {
      long l1 = System.currentTimeMillis();
      this.jdField_b_of_type_ComTencentBizUiTouchWebView = b(null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
      this.jdField_b_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(null);
      this.jdField_b_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_b_of_type_ComTencentBizUiTouchWebView.setBackgroundResource(0);
      Drawable localDrawable = this.jdField_b_of_type_ComTencentBizUiTouchWebView.getBackground();
      if (localDrawable != null) {
        localDrawable.setAlpha(0);
      }
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_ComTencentBizUiTouchWebView, localLayoutParams);
      ARReport.a().a(System.currentTimeMillis() - l1);
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, String.format("lazyInitWebView time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
    }
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("showViewFinder mHasViewFinderShow=%s isPause=%s", new Object[] { Boolean.valueOf(this.jdField_k_of_type_Boolean), Boolean.valueOf(this.jdField_p_of_type_Boolean) }));
    }
    if ((this.jdField_k_of_type_Boolean) || (this.jdField_p_of_type_Boolean)) {}
    for (;;)
    {
      return;
      this.jdField_k_of_type_Boolean = true;
      if (!b())
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      while (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        int i1 = AIOUtils.a(15.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2131492924);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(i1, i1, i1, 0);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.bottomMargin = AIOUtils.a(170.0F, getResources());
        if (this.ad)
        {
          this.ad = false;
          localLayoutParams.addRule(13, 0);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        J();
        return;
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "hideViewFinder");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842934);
    int i1 = AIOUtils.a(15.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.a(170.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(i1, i1, i1, AIOUtils.a(7.0F, getResources()));
    if (this.ad)
    {
      this.ad = false;
      localLayoutParams.addRule(13, 0);
    }
    if (!b()) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_k_of_type_Boolean = false;
      return;
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  private void H()
  {
    if ((this.jdField_u_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)) {
      return;
    }
    I();
  }
  
  private void I()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (!this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment = ARScanFragment.a(this.jdField_a_of_type_ComTencentMobileqqArARArguments, null);
      QLog.i("ScanTorchActivity", 2, "ar resource is not ready,so we have to put empty-value");
    }
    for (;;)
    {
      localFragmentTransaction.add(2131370913, this.jdField_a_of_type_ComTencentMobileqqArARScanFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(this, this);
      if (this.jdField_j_of_type_Long < 0L) {
        this.jdField_j_of_type_Long = System.currentTimeMillis();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment = ARScanFragment.a(this.jdField_a_of_type_ComTencentMobileqqArARArguments, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo);
    }
  }
  
  private void J()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showTouchView");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)) {
      return;
    }
    QLog.d("ScanTorchActivity", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  private void M()
  {
    boolean bool = AREngine.b();
    QLog.d("ScanTorchActivity", 1, String.format("checkAREngineDestroy mCheckDestroyCount=%s isAREngineDestroy=%s", new Object[] { Integer.valueOf(this.jdField_k_of_type_Int), Boolean.valueOf(bool) }));
    if (bool)
    {
      H();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(322);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(321);
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
      {
        int i1 = ImmersiveUtils.a(this);
        int i2 = ScreenUtil.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(i1 / i2);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(i2 / i2, i1 / i2);
      }
    }
    for (;;)
    {
      this.jdField_k_of_type_Int += 1;
      return;
      if (this.jdField_k_of_type_Int < 6)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(323);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(323, 1000L);
      }
      else
      {
        QLog.i("ScanTorchActivity", 1, "ARLoadFailed. mCheckDestroyCount >= CHECK_DESTROY_MAX_COUNT");
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a("AR组件加载失败，请退出后重试。");
        }
        if (f())
        {
          this.jdField_k_of_type_Int = 0;
          if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.b()) {
            e(10);
          }
        }
      }
    }
  }
  
  private void N()
  {
    Intent localIntent = getIntent();
    long l1;
    int i1;
    int i2;
    int i3;
    HashMap localHashMap;
    if ((localIntent != null) && (this.jdField_h_of_type_Long > 0L) && (this.jdField_j_of_type_Long > 0L) && (this.jdField_i_of_type_Long > 0L))
    {
      l1 = localIntent.getLongExtra("click_time", 0L);
      i1 = (int)(this.jdField_h_of_type_Long - l1);
      i2 = (int)(this.jdField_i_of_type_Long - this.jdField_j_of_type_Long);
      i3 = (int)(this.jdField_j_of_type_Long - l1);
      if ((i1 > 0) && (i2 > 0) && (i3 > 0))
      {
        localHashMap = new HashMap();
        if (!localIntent.getBooleanExtra("proc_exist", false)) {
          break label316;
        }
        str = "1";
        localHashMap.put("proc_exist", str);
        if (!localIntent.getBooleanExtra("first_click", false)) {
          break label324;
        }
      }
    }
    label316:
    label324:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("first_click", str);
      localHashMap.put("rcv_kill_broadcast", String.valueOf(this.jdField_f_of_type_Int));
      localHashMap.put("time_oncreate", a(i1));
      localHashMap.put("time_ar_ready", a(i2));
      localHashMap.put("time_add_fragment", a(i3));
      StatisticCollector.a(this).a("", "olympic_tool_proc_report", true, i2, 0L, localHashMap, "", true);
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, new Object[] { "doReport, params=", localHashMap });
      }
      if (this.jdField_g_of_type_Long > 0L)
      {
        l1 = (System.currentTimeMillis() - this.jdField_g_of_type_Long) / 1000L;
        if (l1 < 7200L) {
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceRecog", true, l1, 0L, null, "", true);
        }
      }
      return;
      str = "0";
      break;
    }
  }
  
  private void O()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void P()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  private void Q()
  {
    try
    {
      this.jdField_v_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
      if (!this.jdField_v_of_type_Boolean)
      {
        this.jdField_w_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.d();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ScanTorchActivity", 2, String.format("downloadARResource mIsArSoReady=%s mArSoDownloading=%s", new Object[] { Boolean.valueOf(this.jdField_v_of_type_Boolean), Boolean.valueOf(this.jdField_w_of_type_Boolean) }));
        return;
        this.jdField_w_of_type_Boolean = false;
        this.jdField_g_of_type_Int = 100;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ScanTorchActivity", 2, "downloadARResource fail");
    }
  }
  
  private void R()
  {
    this.x = TVK_SDKMgr.isInstalled(this);
    StatisticCollector.a(this).a(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "immersed_ar_video_sdk_hit", this.x, 0L, 0L, null, "", false);
    if (!this.x)
    {
      this.y = true;
      TVK_SDKMgr.installPlugin(this, new aghe(this));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, String.format("installVideoPlugin mIsVideoPluginReady=%s mVideoPluginDownloading=%s", new Object[] { Boolean.valueOf(this.x), Boolean.valueOf(this.y) }));
      }
      return;
      this.y = false;
      this.jdField_h_of_type_Int = 100;
    }
  }
  
  private void S()
  {
    this.A = FaceScanNativeSoLoader.a();
    if (!this.A)
    {
      this.C = true;
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a(1);
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", "", "0X8008359", "0X8008359", 0, 0, "", "", "so", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("res_type", "so");
      StatisticCollector.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getApp()).a(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "FaceResDownloadByUser", true, 0L, 0L, localHashMap, "", true);
      this.z = FaceScanModelsLoader.a();
      if (this.z) {
        break label321;
      }
      this.B = true;
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a(0);
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", "", "0X8008359", "0X8008359", 0, 0, "", "", "model", "");
      localHashMap = new HashMap();
      localHashMap.put("res_type", "model");
      StatisticCollector.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getApp()).a(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "FaceResDownloadByUser", true, 0L, 0L, localHashMap, "", true);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ScanTorchActivity", 2, String.format("downloadARFaceResources mIsFaceSoReady=%s mFaceSoDownloading=%s", new Object[] { Boolean.valueOf(this.A), Boolean.valueOf(this.C) }));
        QLog.d("ScanTorchActivity", 2, String.format("downloadARFaceResources mIsFaceModelReady=%s mFaceModelDownloading=%s", new Object[] { Boolean.valueOf(this.z), Boolean.valueOf(this.B) }));
      }
      return;
      this.C = false;
      this.jdField_j_of_type_Int = 100;
      break;
      label321:
      this.B = false;
      this.jdField_i_of_type_Int = 100;
    }
  }
  
  private void T()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      if (!OCRManager.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) {
        break label154;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(1, new aghf(this), false);
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X80085B1", "0X80085B1", 0, 0, "", "", "", "");
      int i2;
      int i3;
      String str;
      int i1;
      if (!this.al)
      {
        i2 = 0;
        i3 = 0;
        str = null;
        i1 = i2;
      }
      try
      {
        ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a();
        i1 = i3;
        if (localArrayList != null)
        {
          i1 = i2;
          i2 = localArrayList.size();
          i1 = i2;
          str = localArrayList.toString();
          i1 = i2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
      ScanEntranceReport.a().a(this.jdField_k_of_type_Long, this.jdField_l_of_type_Long, i1, str);
      this.al = true;
      return;
      label154:
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
      {
        str = "提取文字后可进行搜索、翻译等操作。";
        if (TextUtils.equals(DeviceInfoUtil.e(), "MI 6")) {
          str = "提取文字后可进行搜索、翻译等\n操作。";
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(1, "找到文字啦！", str, "拍照提取", new aghg(this), false);
      }
    }
  }
  
  private void U()
  {
    if ((this.mIsResume) && (!this.aj) && (!this.ak)) {
      n();
    }
  }
  
  private void V()
  {
    if ((this.mIsResume) && (!this.aj) && (!this.ak)) {
      d(null);
    }
  }
  
  private void W()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
    {
      Z();
      ab();
      this.aj = false;
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.f(this.aj);
      AREngine localAREngine = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
      if ((localAREngine != null) && (localAREngine.c()))
      {
        if (this.mIsResume)
        {
          localAREngine.e();
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(false);
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.c(false);
          if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null)) {
            this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(true, 1000L);
          }
        }
        f(true);
      }
    }
  }
  
  private void X()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
    {
      Z();
      ab();
      this.ak = false;
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.g(this.ak);
      AREngine localAREngine = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
      if ((localAREngine != null) && (localAREngine.c()))
      {
        if (!this.jdField_p_of_type_Boolean)
        {
          localAREngine.e();
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(false);
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.c(false);
        }
        f(true);
      }
    }
  }
  
  private void Y()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView, localLayoutParams);
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_r_of_type_Long = System.currentTimeMillis();
  }
  
  private void Z()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
  }
  
  private Bitmap a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label137:
    label142:
    int i1;
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)
    {
      localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(paramString);
      boolean bool;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getBinHaiResBitmap res=").append(paramString).append("hit cache=");
        if (localObject1 != null)
        {
          bool = true;
          QLog.d("ScanTorchActivity", 2, bool);
        }
      }
      else if (paramBoolean)
      {
        localObject2 = StatisticCollector.a(BaseApplicationImpl.getContext());
        localObject3 = this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        if (localObject1 == null) {
          break label137;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((StatisticCollector)localObject2).a((String)localObject3, "binhai_hit_cache", paramBoolean, 0L, 0L, null, "", false);
        if (localObject1 == null) {
          break label142;
        }
        paramString = (String)localObject1;
        return paramString;
        bool = false;
        break;
      }
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      localObject2 = ((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + ((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "/" + paramString;
      localObject3 = new File((String)localObject2);
      if (!((File)localObject3).exists())
      {
        QLog.d("ScanTorchActivity", 1, "showBinHaiFuDaiClickTipsView, file not exist");
        return null;
      }
      i1 = 0;
    }
    label296:
    label357:
    for (;;)
    {
      try
      {
        localObject1 = SafeBitmapFactory.decodeFile(((File)localObject3).getAbsolutePath());
        paramString = (String)localObject1;
        if (localObject1 != null) {
          break;
        }
        i1 += 1;
        if (i1 < 2) {
          break label357;
        }
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        if (!QLog.isColorLevel()) {
          break label296;
        }
      }
      QLog.e("ScanTorchActivity", 2, "getBinHaiResBitmap oom " + (String)localObject2, paramString);
      for (;;)
      {
        System.gc();
        break;
        QLog.d("ScanTorchActivity", 1, "getBinHaiResBitmap oom " + (String)localObject2);
      }
      QLog.d("ScanTorchActivity", 1, "getBinHaiResBitmap, null config info, res=" + paramString);
    }
  }
  
  private Drawable a(Bitmap paramBitmap, float paramFloat)
  {
    return new agiu(this, getResources(), paramBitmap, paramFloat, paramBitmap);
  }
  
  private ArCloudConfigInfo.WorldCupResPath a()
  {
    ArCloudConfigInfo.WorldCupResPath localWorldCupResPath = new ArCloudConfigInfo.WorldCupResPath();
    Object localObject1 = WorldCup.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface);
    Object localObject2 = ((WorldCupConfigInfo)localObject1).a(0) + "gesture" + File.separator;
    this.jdField_l_of_type_JavaLangString = ((String)localObject2 + "images" + File.separator);
    this.jdField_m_of_type_JavaLangString = ((String)localObject2 + "gesture_guide_animation.json");
    this.jdField_k_of_type_JavaLangString = ((String)localObject2 + "gesture_guide_background.png");
    this.jdField_n_of_type_JavaLangString = ((String)localObject2 + "gesture_guide_flash_screen.png");
    localWorldCupResPath.jdField_b_of_type_JavaLangString = ((String)localObject2 + "sprite.frag");
    localWorldCupResPath.jdField_a_of_type_JavaLangString = ((String)localObject2 + "sprite.vert");
    localWorldCupResPath.jdField_c_of_type_JavaLangString = ((String)localObject2 + "spark.png");
    localWorldCupResPath.jdField_d_of_type_JavaLangString = ((String)localObject2 + "turn.png");
    localWorldCupResPath.jdField_e_of_type_JavaLangString = ((String)localObject2 + "light.png");
    localWorldCupResPath.f = (((WorldCupConfigInfo)localObject1).a(1) + "gameplay");
    localWorldCupResPath.jdField_g_of_type_JavaLangString = (((WorldCupConfigInfo)localObject1).a(3) + "gameplay");
    QLog.i("ScanTorchActivity", 1, "prepareWorldCupBaseUIRes. sparkFileName = " + localWorldCupResPath.jdField_c_of_type_JavaLangString + ", gamePlayMainPath = " + localWorldCupResPath.f + ", gamePlayExtendPath = " + localWorldCupResPath.jdField_g_of_type_JavaLangString);
    localObject2 = new File(this.jdField_m_of_type_JavaLangString);
    File localFile1 = new File(this.jdField_k_of_type_JavaLangString);
    new File(this.jdField_n_of_type_JavaLangString);
    File localFile2 = new File(localWorldCupResPath.jdField_b_of_type_JavaLangString);
    File localFile3 = new File(localWorldCupResPath.jdField_a_of_type_JavaLangString);
    File localFile4 = new File(localWorldCupResPath.jdField_c_of_type_JavaLangString);
    File localFile5 = new File(localWorldCupResPath.jdField_d_of_type_JavaLangString);
    localObject1 = new File(localWorldCupResPath.jdField_e_of_type_JavaLangString);
    if ((!((File)localObject2).exists()) || (!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists()) || (!localFile4.exists()) || (!localFile5.exists()) || (!((File)localObject1).exists()))
    {
      QLog.i("ScanTorchActivity", 1, "prepareWorldCupBaseUIRes. failed.");
      localWorldCupResPath = null;
    }
    return localWorldCupResPath;
  }
  
  private AREngine a()
  {
    AREngine localAREngine = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
      localAREngine = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a();
    }
    return localAREngine;
  }
  
  private MapView a()
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView == null)
    {
      this.jdField_t_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView = new MapView(this, false);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getUiSettings().setLogoPosition(0);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getUiSettings().setScaleControlsEnabled(false);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getUiSettings().setScrollGesturesEnabled(false);
      TencentMap localTencentMap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getMap();
      localTencentMap.setMinZoomLevel(15);
      localTencentMap.setMaxZoomLevel(17);
      localTencentMap.setOnMapCameraChangeListener(new agje(this));
      localTencentMap.setOnMapLoadedListener(new agjf(this));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.setEnabled(true);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.setClickable(true);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onCreate(null);
    }
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView;
  }
  
  private static String a(int paramInt)
  {
    return String.format("%.2f", new Object[] { Float.valueOf(paramInt / 1000.0F) });
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "setBinHaiState:" + paramInt1 + ", result=" + paramInt2 + ", param=" + paramString);
    }
    AREngine localAREngine = a();
    ArCloudConfigInfo localArCloudConfigInfo = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localAREngine.b(localArCloudConfigInfo, 11, 0, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
  }
  
  private void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache = null;
    this.jdField_o_of_type_JavaLangString = null;
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()))
    {
      ab();
      a(paramOcrRecogResult, paramString);
      return;
    }
    if (paramInt == 1) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439047, 0).a();
    }
    for (;;)
    {
      W();
      return;
      if (paramInt == 0) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439044, 0).a();
      } else {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439046, 0).a();
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (paramView != null)
    {
      if (paramBoolean2) {
        break label33;
      }
      paramView.setAlpha(1.0F);
      if (!paramBoolean1) {
        break label27;
      }
    }
    for (;;)
    {
      paramView.setVisibility(i1);
      return;
      label27:
      i1 = 4;
    }
    label33:
    ObjectAnimator localObjectAnimator;
    if (paramBoolean1)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setAlpha(0.0F);
      paramView.setVisibility(4);
    }
    for (;;)
    {
      localObjectAnimator.addListener(new agjc(this, paramView, paramBoolean1));
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
      paramView.setAlpha(1.0F);
      paramView.setVisibility(0);
    }
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleNoFeatureTrackOpenPOICompleted success: ").append(paramBoolean).append("  noTrackMode?");
      if ((paramArCloudConfigInfo == null) || (paramArCloudConfigInfo.d())) {
        break label135;
      }
    }
    label135:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ScanTorchActivity", 2, bool);
      if ((!paramBoolean) && (paramArCloudConfigInfo != null) && (!paramArCloudConfigInfo.d()) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null))
      {
        if ((paramArCloudConfigInfo.jdField_a_of_type_Int != 1) || (paramArCloudConfigInfo.jdField_e_of_type_Int != 0)) {
          break;
        }
        f(true);
        this.jdField_a_of_type_AndroidOsHandler.post(new aghd(this));
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, "onNoFeatureTrackAnimOpenPOICompleted notPlayModel");
        }
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.d(paramBoolean);
  }
  
  private void a(ARCloudLBSLocationCheckResult.POIInfo paramPOIInfo, ArLBSActivity paramArLBSActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog = new ARLBSPOIDialog(this, a());
      this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.setOnDismissListener(new agjd(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.a();
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.a(paramPOIInfo, paramArLBSActivity);
    }
  }
  
  private void a(ItemInfo paramItemInfo)
  {
    boolean bool = false;
    Object localObject;
    if ((paramItemInfo == null) || (isFinishing())) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("showInfoDialog itemInfo == null ? ");
        if (paramItemInfo == null) {
          bool = true;
        }
        QLog.i("ScanTorchActivity", 2, bool);
      }
    }
    label454:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, "showInfoDialog itemInfo: " + paramItemInfo);
      }
      String str1;
      if ((paramItemInfo.jdField_b_of_type_Int == 2) || (paramItemInfo.jdField_b_of_type_Int == 6) || (paramItemInfo.jdField_b_of_type_Int == 7)) {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new ARMapOpenRedPackDialog(this, this.jdField_b_of_type_ComTencentCommonAppAppInterface, false);
          localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_c_of_type_JavaLangString;
          str1 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_e_of_type_JavaLangString;
          String str2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.f;
          String str3 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_d_of_type_JavaLangString;
          ((ARMapOpenRedPackDialog)this.jdField_a_of_type_AndroidAppDialog).a((String)localObject, str1, str2, str3, paramItemInfo);
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          break label454;
        }
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
        return;
        if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        break;
        if (paramItemInfo.jdField_b_of_type_Int == 4)
        {
          if (this.jdField_a_of_type_AndroidAppDialog == null) {
            this.jdField_a_of_type_AndroidAppDialog = new ARMapOpenKaquanDialog(this, false);
          }
          for (;;)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_c_of_type_JavaLangString;
            str1 = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo.jdField_e_of_type_JavaLangString;
            ((ARMapOpenKaquanDialog)this.jdField_a_of_type_AndroidAppDialog).a((String)localObject, str1, paramItemInfo.jdField_a_of_type_JavaLangString, paramItemInfo.jdField_c_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidAppDialog.show();
            break;
            if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
              this.jdField_a_of_type_AndroidAppDialog.dismiss();
            }
          }
        }
        if (paramItemInfo.jdField_b_of_type_Int == 5)
        {
          if (this.jdField_a_of_type_AndroidAppDialog == null) {
            this.jdField_a_of_type_AndroidAppDialog = new ARMapOpenCardDialog(this, false);
          }
          for (;;)
          {
            ((ARMapOpenCardDialog)this.jdField_a_of_type_AndroidAppDialog).a(paramItemInfo);
            this.jdField_a_of_type_AndroidAppDialog.show();
            break;
            if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
              this.jdField_a_of_type_AndroidAppDialog.dismiss();
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("ScanTorchActivity", 2, "showInfoDialog unkown type: " + paramItemInfo);
        }
      }
    }
  }
  
  private void a(OcrRecogResult paramOcrRecogResult, String paramString)
  {
    Intent localIntent = new Intent(this, OCRRecognitionResultActivity.class);
    localIntent.putExtra("param_recog_ret", paramOcrRecogResult);
    localIntent.putExtra("param_recog_pic_path", paramString);
    localIntent.addFlags(67108864);
    startActivityForResult(localIntent, 0);
    overridePendingTransition(2131034134, 0);
  }
  
  private void a(String paramString)
  {
    QLog.d("ScanTorchActivity", 1, "scanTorch preLaunchToQQBrowseActivity ");
    paramString = b(paramString);
    this.jdField_b_of_type_ComTencentBizUiTouchWebView.onResume();
    this.jdField_b_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    paramString = new StringBuilder().append("updateOperateBtnStatus[").append(paramString).append("], visible[").append(paramBoolean).append("], mIsWorldCupMode[").append(this.V).append("], mIsEnterWorldCupFromScan[").append(this.W).append("], operateBtn[");
    if (this.jdField_p_of_type_AndroidWidgetImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("ScanTorchActivity", 1, bool + "]");
      if (this.jdField_p_of_type_AndroidWidgetImageView != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Agjt.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Agjt.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_p_of_type_AndroidWidgetImageView);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_Agjt);
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Agjt, 500L);
      return;
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_Agjt);
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog = new BinHaiMsgDialog(this);
    }
    Object localObject;
    if (paramBoolean1)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener == null) {
        this.jdField_b_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener = new aghv(this);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog;
      if (!paramBoolean2)
      {
        paramBoolean1 = true;
        ((BinHaiMsgDialog)localObject).jdField_a_of_type_Boolean = paramBoolean1;
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.jdField_a_of_type_Int = paramInt;
        BinHaiMsgDialog localBinHaiMsgDialog = this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog;
        if (!paramBoolean2) {
          break label146;
        }
        localObject = "点击重试";
        label84:
        localBinHaiMsgDialog.a((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.a(this.jdField_b_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.a(paramString, a("res/fudai/alertbg.png", true));
      if (!this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.isShowing())
      {
        f(false);
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.show();
      }
      return;
      paramBoolean1 = false;
      break;
      label146:
      localObject = "我知道啦";
      break label84;
      if (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener == null) {
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener = new aghw(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.a("我知道啦");
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.a(this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog$Listener);
    }
  }
  
  private void a(ArrayList paramArrayList, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHaiRedPackCardList, list=" + paramArrayList);
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.d("ScanTorchActivity", 1, "showBinHaiRedPackCardList list size is 0");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new agiq(this, paramArrayList, paramInt, paramString), 500L);
    ThreadManager.post(new agis(this), 5, null, false);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHaiRedPackCatchCountView, show=" + paramBoolean + ", count=" + paramInt);
    }
    Object localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362427);
    if (!paramBoolean)
    {
      if (localObject1 != null)
      {
        ((LinearLayout)localObject1).clearAnimation();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject1);
      }
      return;
    }
    Object localObject2;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = new LinearLayout(this);
      ((LinearLayout)localObject1).setId(2131362427);
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(19);
      localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(176.5F, getResources()), -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(AIOUtils.a(9.0F, getResources()), 0, 0, AIOUtils.a(5.0F, getResources()));
      localObject3 = new ImageView(this);
      ((ImageView)localObject3).setId(2131362719);
      ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
      Object localObject4 = a("res/redpack/catch_icon.png", true);
      if (localObject4 != null) {
        ((ImageView)localObject3).setImageBitmap((Bitmap)localObject4);
      }
      ((LinearLayout)localObject1).addView((View)localObject3, new LinearLayout.LayoutParams(AIOUtils.a(51.5F, getResources()), AIOUtils.a(61.0F, getResources())));
      localObject3 = new StrokeTextView(this);
      ((StrokeTextView)localObject3).setId(2131364190);
      ((StrokeTextView)localObject3).setInnerTextColor(-460552);
      ((StrokeTextView)localObject3).setStrokeColor(-3325888);
      ((StrokeTextView)localObject3).setStrokeSize(AIOUtils.a(4.0F, getResources()));
      ((StrokeTextView)localObject3).setStrokeEnable(true);
      ((StrokeTextView)localObject3).setTextSize(1, 32.0F);
      ((StrokeTextView)localObject3).setGravity(19);
      localObject4 = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      localObject4 = new File(((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + ((ArCloudConfigInfo)localObject4).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "/" + "res/redpack/cocogoose1.ttf");
      if (((File)localObject4).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, "binhai strokeText setFont=" + ((File)localObject4).getAbsolutePath());
        }
        ((StrokeTextView)localObject3).setTypeface(Typeface.createFromFile((File)localObject4));
      }
      localObject4 = new LinearLayout.LayoutParams(AIOUtils.a(130.0F, getResources()), AIOUtils.a(50.0F, getResources()));
      ((LinearLayout.LayoutParams)localObject4).setMargins(AIOUtils.a(-5.0F, getResources()), 0, 0, 0);
      ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      localObject2 = (StrokeTextView)((LinearLayout)localObject1).findViewById(2131364190);
      if (localObject2 != null)
      {
        localObject3 = new SpannableString(" x " + paramInt);
        ((SpannableString)localObject3).setSpan(new RelativeSizeSpan(0.5F), 0, 1, 33);
        ((SpannableString)localObject3).setSpan(new RelativeSizeSpan(0.5F), 2, 3, 33);
        ((StrokeTextView)localObject2).setText((CharSequence)localObject3);
      }
      if (paramInt == 0)
      {
        localObject1 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { -AIOUtils.a(132.5F, getResources()), 0.0F });
        ((Animator)localObject1).setDuration(1000L);
        ((Animator)localObject1).start();
        return;
      }
      localObject2 = new agio(this);
      ((Animation)localObject2).setDuration(200L);
      ((LinearLayout)localObject1).clearAnimation();
      ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, float paramFloat, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHaiRedPackGameCountDownView, show=" + paramBoolean1 + ", time=" + paramInt + ", progress=" + paramFloat + ", isFirst=" + paramBoolean2);
    }
    Object localObject2 = (BinHaiProgressView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362425);
    if (!paramBoolean1)
    {
      if (localObject2 != null)
      {
        ((BinHaiProgressView)localObject2).clearAnimation();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject2);
      }
      localObject1 = findViewById(2131362426);
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject1);
      }
      return;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new BinHaiProgressView(this);
      ((BinHaiProgressView)localObject2).setId(2131362425);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      ((BinHaiProgressView)localObject2).setFont(((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + ((ArCloudConfigInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "/" + "res/redpack/cocogoose1.ttf");
      localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(57.0F, getResources()), AIOUtils.a(57.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, ImmersiveUtils.a(this) + AIOUtils.a(5.0F, getResources()), AIOUtils.a(5.0F, getResources()), 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject1 = localObject2;
      if (findViewById(2131362426) == null)
      {
        localObject1 = new View(this);
        ((View)localObject1).setId(2131362426);
        ((View)localObject1).setBackgroundColor(0);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(11);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, localLayoutParams);
        localObject1 = localObject2;
      }
    }
    if (paramBoolean2)
    {
      localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { AIOUtils.a(62.0F, getResources()), 0.0F });
      ((Animator)localObject2).setDuration(1000L);
      ((Animator)localObject2).start();
    }
    ((BinHaiProgressView)localObject1).a(paramFloat, String.valueOf(Math.max(0, paramInt)));
  }
  
  private void aA()
  {
    QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideBgImg. file name = " + this.jdField_k_of_type_JavaLangString);
    if (!new File(this.jdField_k_of_type_JavaLangString).exists()) {
      QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideBgImg failed. file not exist.");
    }
    for (;;)
    {
      return;
      int i1 = 0;
      try
      {
        for (;;)
        {
          this.jdField_k_of_type_AndroidWidgetTextView.setBackgroundDrawable(new BitmapDrawable(this.jdField_k_of_type_JavaLangString));
          this.jdField_j_of_type_AndroidWidgetTextView.setBackgroundDrawable(new BitmapDrawable(this.jdField_k_of_type_JavaLangString));
          i1 += 1;
          if (i1 >= 2) {
            break;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          QLog.e("ScanTorchActivity", 2, "loadWorldCupGuideBgImg failed. oom. err = " + localOutOfMemoryError.getMessage());
          System.gc();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ScanTorchActivity", 2, "loadWorldCupGuideBgImg failed. err = " + localException.getMessage());
          System.gc();
        }
      }
    }
  }
  
  private void aB()
  {
    QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideFlashScreen. file name = " + this.jdField_n_of_type_JavaLangString);
    if (!new File(this.jdField_n_of_type_JavaLangString).exists())
    {
      this.aa = false;
      QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideFlashScreen failed. file not exist.");
    }
    for (;;)
    {
      return;
      int i1 = 0;
      try
      {
        for (;;)
        {
          this.aa = true;
          this.jdField_f_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(new BitmapDrawable(this.jdField_n_of_type_JavaLangString));
          i1 += 1;
          if (i1 >= 2) {
            break;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          QLog.e("ScanTorchActivity", 2, "loadWorldCupGuideFlashScreen failed. oom. err = " + localOutOfMemoryError.getMessage());
          System.gc();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ScanTorchActivity", 2, "loadWorldCupGuideFlashScreen failed. err = " + localException.getMessage());
          System.gc();
        }
      }
    }
  }
  
  private void aC()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.a()) {
      this.jdField_e_of_type_Int = 100;
    }
    while (k())
    {
      this.jdField_b_of_type_Int = 100;
      return;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.a();
    }
    aD();
  }
  
  private void aD()
  {
    z();
    this.F = true;
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new agjo(this), 1000L);
  }
  
  private void aa()
  {
    this.jdField_o_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
      if (localObject != null)
      {
        localObject = ((AREngine)localObject).a();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists())) {
          this.jdField_o_of_type_JavaLangString = ((String)localObject);
        }
      }
    }
  }
  
  private void ab()
  {
    a("hideOCRRecognizeView", true);
    if (this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_e_of_type_AndroidWidgetImageView);
    }
  }
  
  private void ac()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiObserver = new aghx(this);
    this.jdField_b_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiObserver);
  }
  
  private void ad()
  {
    QLog.d("ScanTorchActivity", 1, "gotoBinHaiRainingDirectly " + this.jdField_p_of_type_JavaLangString);
    a(5, 1, "");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new agin(this), 500L);
  }
  
  private void ae()
  {
    a(1, 0, "");
  }
  
  private void af()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "startBinHaiFuDaiTimeDown " + this.jdField_v_of_type_Long);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new agip(this));
  }
  
  private void ag()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(343);
    if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
      this.jdField_f_of_type_AndroidWidgetImageView.clearAnimation();
    }
    int[] arrayOfInt = new int[3];
    int[] tmp30_29 = arrayOfInt;
    tmp30_29[0] = 2131362434;
    int[] tmp36_30 = tmp30_29;
    tmp36_30[1] = 2131362436;
    int[] tmp42_36 = tmp36_30;
    tmp42_36[2] = 2131362437;
    tmp42_36;
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(arrayOfInt[i1]);
      if (localView != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      }
      i1 += 1;
    }
  }
  
  private void ah()
  {
    if (this.an) {
      QLog.d("ScanTorchActivity", 1, "startBinHaiFuDaiClick, is clicking, return");
    }
    this.an = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_l_of_type_Int = 0;
    this.jdField_s_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(337);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(337, 1000L);
  }
  
  private void ai()
  {
    this.an = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(337);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = null;
  }
  
  private void aj()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(339);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(339);
    localMessage.arg1 = 1;
    this.jdField_t_of_type_Long = (System.currentTimeMillis() - 100L);
    localMessage.sendToTarget();
  }
  
  private void ak()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onBinHaiRainingEnd, count=" + this.jdField_n_of_type_Int + ", mBinHaiOpenDelay=" + this.jdField_u_of_type_Long);
    }
    a(false, 0, 0.0F, false);
    a(false, 0);
    a(6, 0, "");
    int i1 = this.jdField_n_of_type_Int;
    this.jdField_n_of_type_Int = Math.min(this.jdField_n_of_type_Int, this.jdField_q_of_type_Int);
    this.jdField_n_of_type_Int = Math.max(this.jdField_n_of_type_Int, this.jdField_p_of_type_Int);
    c(true, 1);
    QLog.d("ScanTorchActivity", 1, "binhai showingLoadingTime=" + System.currentTimeMillis());
    if (this.jdField_u_of_type_Long > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new agit(this), this.jdField_u_of_type_Long);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X800838C", "0X800838C", 0, 0, String.valueOf(i1), "", this.jdField_p_of_type_JavaLangString, "");
      return;
      ((BinHaiHandler)this.jdField_b_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(3)).b(this.jdField_p_of_type_JavaLangString, this.jdField_n_of_type_Int);
      QLog.d("ScanTorchActivity", 1, "binhai sendOpenReqTime=" + System.currentTimeMillis());
    }
  }
  
  private void al()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "stopBinHai");
    }
    this.as = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(338);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(339);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(340);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(341);
    if ((this.ar) && (this.jdField_c_of_type_AndroidWidgetFrameLayout != null))
    {
      this.ar = false;
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    if ((this.aq) && (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView != null))
    {
      this.aq = false;
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setVisibility(0);
    }
    if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if ((!b()) && (this.jdField_f_of_type_AndroidWidgetTextView != null)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_o_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = null;
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362431);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject);
    }
    ai();
    i(false);
    a(false, 0, 0.0F, false);
    a(false, 0);
    c(false, 0);
    a(false, null, null, null);
    d(false);
    ag();
    am();
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {}
    for (localObject = a();; localObject = null)
    {
      if (localObject != null)
      {
        ((AREngine)localObject).b(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 9, 1, null);
        ((AREngine)localObject).b(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 12, 0, null);
      }
      F();
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
        f(true);
      }
      this.jdField_p_of_type_JavaLangString = null;
      BinHaiHandler.a = null;
      return;
    }
  }
  
  private void am()
  {
    this.au = false;
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362428);
    if (localView != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
    }
    this.jdField_g_of_type_AndroidWidgetImageView = null;
    this.jdField_h_of_type_AndroidWidgetImageView = null;
    this.jdField_i_of_type_AndroidWidgetImageView = null;
    this.jdField_j_of_type_AndroidWidgetImageView = null;
    this.jdField_k_of_type_AndroidWidgetImageView = null;
    this.jdField_l_of_type_AndroidWidgetImageView = null;
    this.jdField_m_of_type_AndroidWidgetImageView = null;
    this.jdField_n_of_type_AndroidWidgetImageView = null;
  }
  
  private void an()
  {
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362431);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.jdField_o_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_o_of_type_AndroidWidgetImageView = new ImageView(this);
        this.jdField_o_of_type_AndroidWidgetImageView.setId(2131362431);
        this.jdField_o_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localObject1 = a("res/redpack/catch_anim.png", true);
        if (localObject1 != null) {
          this.jdField_o_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
        }
      }
      localObject1 = this.jdField_o_of_type_AndroidWidgetImageView;
      localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(343.0F, getResources()), AIOUtils.a(159.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, getResources().getDisplayMetrics().heightPixels / 2 + AIOUtils.a(50.0F, getResources()), 0, 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(2.4F, 1.0F, 2.4F, 1.0F, 1, 0.5F, 1, 0.5F);
      OvershootInterpolator localOvershootInterpolator = new OvershootInterpolator(1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(localOvershootInterpolator);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject2);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localScaleAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.reset();
    ((ImageView)localObject1).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(341);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(341, 1500L);
  }
  
  private void ao()
  {
    QLog.d("ScanTorchActivity", 1, "handleARStartFail");
    this.H = true;
    if ((this.jdField_a_of_type_JavaLangRunnable == null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a("AR组件加载失败，请退出后重试。");
    }
    if ((!f()) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.b())) {
      return;
    }
    e(10);
  }
  
  private void ap()
  {
    QLog.d("ScanTorchActivity", 1, "handleCameraOpenFail");
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a("相机启动失败，请退出后重试。");
    }
  }
  
  private void aq()
  {
    if (this.jdField_b_of_type_JavaLangRunnable == null)
    {
      this.jdField_b_of_type_JavaLangRunnable = new agiz(this);
      QLog.d("ScanTorchActivity", 2, "startDownloadTimeoutCheck");
    }
    this.av = false;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
  }
  
  private void ar()
  {
    QLog.d("ScanTorchActivity", 2, "stopDownloadTimeoutCheck");
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
  }
  
  private void as()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "resetFlashLightState");
    }
    this.Q = false;
    this.R = false;
    a(this.jdField_i_of_type_AndroidWidgetTextView, this.Q, false);
    TextView localTextView;
    if (!b())
    {
      localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
      if (this.Q) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.g(true);
      }
      return;
    }
  }
  
  private void at()
  {
    if (!(this.jdField_a_of_type_Agjr instanceof agjq)) {}
    Object localObject;
    do
    {
      return;
      localObject = (agjq)this.jdField_a_of_type_Agjr;
    } while (TextUtils.isEmpty(((agjq)localObject).jdField_c_of_type_JavaLangString));
    try
    {
      localObject = new JSONObject(((agjq)localObject).jdField_c_of_type_JavaLangString);
      LottieComposition.Factory.fromJson(getResources(), (JSONObject)localObject, new agja(this));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void au()
  {
    LottieComposition.Factory.fromAssetFileName(this, "qq_ar_light_first_show.json", new agjb(this));
  }
  
  private void av()
  {
    this.jdField_p_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
    this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130842244);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(217.0F, this.jdField_p_of_type_AndroidWidgetImageView.getResources()), AIOUtils.a(47.0F, this.jdField_p_of_type_AndroidWidgetImageView.getResources()));
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    int i1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    int i2 = AIOUtils.a(53.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources());
    localLayoutParams.rightMargin = AIOUtils.a(0.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources());
    localLayoutParams.topMargin = (i1 + i2);
    this.jdField_p_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_p_of_type_AndroidWidgetImageView.setOnTouchListener(new agjg(this));
    this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(new agjh(this));
    this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_p_of_type_AndroidWidgetImageView, localLayoutParams);
    if (this.V)
    {
      QLog.w("ScanTorchActivity", 1, "reallyCreateOperateEntry, 已经在世界杯模式了");
      return;
    }
    a("reallyCreateOperateEntry", true);
  }
  
  private void aw()
  {
    boolean bool = false;
    if (this.jdField_p_of_type_AndroidWidgetImageView != null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_Agjr == null) || (!this.jdField_a_of_type_Agjr.jdField_a_of_type_Boolean))
          {
            localObject = new StringBuilder().append("initOperateEntry, 无需显示入口, mPromotionInfo[");
            if (this.jdField_a_of_type_Agjr != null) {
              bool = true;
            }
            QLog.w("ScanTorchActivity", 1, bool + "]");
            return;
          }
          Object localObject = WorldCup.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface);
          if ((((WorldCupConfigInfo)localObject).a()) && (WorldCupConfigInfo.a((WorldCupConfigInfo)localObject))) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.w("ScanTorchActivity", 1, "initOperateEntry, 入口未打开");
        return;
        if (WorldCup.a()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("ScanTorchActivity", 1, "initOperateEntry, 机器不支持");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.d();
      }
      WorldCup.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, 0);
    } while (this.jdField_f_of_type_Long == 2L);
    av();
  }
  
  private void ax()
  {
    QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. hideNonWorldCupUI.");
    if ((this.Q) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.b(false)))
    {
      this.R = false;
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.g(false);
      j(true);
      k(this.R);
    }
    this.jdField_d_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.setOnScanAnimEndListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqOlympicActivityARTipsManager = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager;
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    L();
  }
  
  private void ay()
  {
    this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131370927));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370928));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370929));
    this.jdField_e_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131429934);
    this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131370915));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131370930));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370932));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370931));
    if (Build.MODEL.equalsIgnoreCase("FRD-AL10"))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = ((int)(localLayoutParams.width * 0.8D));
      localLayoutParams.height = ((int)(localLayoutParams.height * 0.8D));
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    aB();
    aA();
    az();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.ab = false;
    if (!this.aa) {
      this.ab = true;
    }
  }
  
  private void az()
  {
    QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideAnimation. file name = " + this.jdField_m_of_type_JavaLangString);
    if (!new File(this.jdField_m_of_type_JavaLangString).exists())
    {
      QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideAnimation failed. file not exist.");
      return;
    }
    if (!new File(this.jdField_l_of_type_JavaLangString).exists())
    {
      QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideAnimation failed. dir not exist.");
      return;
    }
    if (!new File(this.jdField_l_of_type_JavaLangString + "img_0.png").exists())
    {
      QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideAnimation failed. aniImg1 not exist.");
      return;
    }
    if (!new File(this.jdField_l_of_type_JavaLangString + "img_1.png").exists())
    {
      QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideAnimation failed. aniImg2 not exist.");
      return;
    }
    try
    {
      Bitmap localBitmap1 = SafeBitmapFactory.decodeFile(this.jdField_l_of_type_JavaLangString + "img_0.png");
      Bitmap localBitmap2 = SafeBitmapFactory.decodeFile(this.jdField_l_of_type_JavaLangString + "img_1.png");
      this.jdField_a_of_type_JavaUtilHashMap.put("img_0.png", localBitmap1);
      this.jdField_a_of_type_JavaUtilHashMap.put("img_1.png", localBitmap2);
      try
      {
        LottieComposition.Factory.fromInputStream(this, new FileInputStream(this.jdField_m_of_type_JavaLangString), new agjl(this));
        return;
      }
      catch (Exception localException1)
      {
        QLog.i("ScanTorchActivity", 2, "loadWorldCupGuideAnimation failed. err = " + localException1.getMessage());
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.i("ScanTorchActivity", 2, "loadWorldCupGuideAnimation failed. err = " + localException2.getMessage());
      }
    }
  }
  
  private String b(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("&_wv=");
    paramString.append(Integer.toString(17367040));
    return paramString.toString();
  }
  
  private void b(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    if (paramArLBSActivity == null) {
      new ArLBSActivity();
    }
    do
    {
      return;
      if (paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int == 0)
      {
        if (paramARCloudLBSLocationCheckResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult$POIInfo == null)
        {
          QQToast.a(this, paramArLBSActivity.f, 1).a();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(true);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.c(true);
        f(false);
        a(paramARCloudLBSLocationCheckResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult$POIInfo, paramArLBSActivity);
        return;
      }
      if (paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(true);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.c(true);
        f(false);
        if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, paramArLBSActivity.jdField_g_of_type_JavaLangString, paramArLBSActivity.jdField_h_of_type_JavaLangString, "确定", "去设置", new aghh(this), new aghi(this));
        }
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new aghj(this));
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    } while (paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int != -1);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624516);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969180);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363399)).setText(paramString);
    if (!isFinishing()) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onBinHaiRedPackGameReady, lookUp=" + paramBoolean + ", timeLeft=" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(338);
    if (paramBoolean)
    {
      i(true);
      a(4, 0, "");
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(342, 5000L);
      return;
    }
    i(false);
    d(true);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(342);
  }
  
  private void c(String paramString)
  {
    if ((this.mIsResume) && (!this.aj) && (!this.ak)) {
      d(paramString);
    }
  }
  
  private void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHaiRedPackLoadingView show=" + paramBoolean + ", which=" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(340);
    if (!paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362429);
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject1);
      }
      return;
    }
    Object localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362429);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new RelativeLayout(this);
      ((RelativeLayout)localObject1).setBackgroundColor(1426063360);
      ((RelativeLayout)localObject1).setId(2131362429);
      localObject2 = new ImageView(this);
      ((ImageView)localObject2).setId(2131362430);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
      Object localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(165.0F, getResources()), AIOUtils.a(146.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this);
      ((TextView)localObject3).setTextSize(1, 16.0F);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setText("正在统计你的红包，\n请稍候...");
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, 2131362430);
      localLayoutParams.setMargins(0, AIOUtils.a(20.0F, getResources()), 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject3, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(341);
      localObject3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362431);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((View)localObject3).clearAnimation();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject3);
      }
    }
    for (localObject1 = localObject2;; localObject1 = (ImageView)((RelativeLayout)localObject1).findViewById(2131362430))
    {
      localObject2 = a(String.format(Locale.getDefault(), "res/redpack/loading_0%d.png", new Object[] { Integer.valueOf(paramInt % 3 + 1) }), true);
      if (localObject2 != null) {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(340);
      ((Message)localObject1).arg1 = (paramInt + 1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 200L);
      return;
    }
  }
  
  private void d(String paramString)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("enterOCRPreviewModel filePath=%s", new Object[] { paramString }));
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
      if ((localObject != null) && (((AREngine)localObject).c()))
      {
        ((AREngine)localObject).a(false);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(true);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.c(true);
        f(false);
        as();
      }
      Y();
      if (!TextUtils.isEmpty(paramString)) {
        bool = true;
      }
      h(bool);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      ThreadManager.getSubThreadHandler().post(new aghl(this, paramString));
      this.aj = true;
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.f(this.aj);
    }
  }
  
  private void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "doSearchQuestion filePath:" + paramString);
    }
    if (!this.ak)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "doSearchQuestion but is not in search question!");
      }
      return;
    }
    paramString = EditPicActivity.a(getActivity(), paramString, false, false, false, true, false, 2, 99, 9);
    paramString.putExtra("babyq_ability", 2L);
    paramString.putExtra("sub_business_id", 105);
    startActivity(paramString);
  }
  
  private void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget == null) || (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      }
      if (this.ad)
      {
        this.ad = false;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.bottomMargin = AIOUtils.a(170.0F, getResources());
        localLayoutParams.addRule(13, 0);
      }
    } while (!paramBoolean);
    this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "", "");
  }
  
  private void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl = new OcrControl(this.jdField_b_of_type_ComTencentCommonAppAppInterface, new aghs(this), 0);
      this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.a(paramString, false);
  }
  
  private void f(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.w("ScanTorchActivity", 1, "setHaveEdge, flag[" + paramBoolean + "], mIsWorldCupMode[" + this.V + "], mIsEnterWorldCupFromScan[" + this.W + "]");
    }
    if (((this.V) || (this.W)) && (paramBoolean))
    {
      a("setHaveEdge", false);
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(paramBoolean);
      }
      this.ag = false;
      this.af = false;
      if (!paramBoolean) {
        break label172;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.a())
      {
        if (this.jdField_p_of_type_Boolean) {
          break label166;
        }
        if (!isInMultiWindow()) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.a(true);
        }
      }
    }
    label166:
    label172:
    do
    {
      return;
      a("setHaveEdge", paramBoolean);
      break;
      this.af = true;
      return;
      this.jdField_q_of_type_Boolean = false;
    } while (!this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.a());
    ScannerAnimView localScannerAnimView = this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView;
    if (!this.jdField_o_of_type_Boolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localScannerAnimView.b(paramBoolean);
      return;
    }
  }
  
  private void g(String paramString)
  {
    a(paramString, false, false, 0);
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new agfk(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new agfm(this));
  }
  
  private boolean g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  private void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "playBinHaiEffectMusic:" + paramString);
    }
    a().b(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 13, 0, paramString);
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.jdField_a_of_type_Int);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ScanSuccessView localScanSuccessView = this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView;
    if (paramBoolean) {}
    for (Object localObject = "正在识别...";; localObject = "正在提取...")
    {
      localScanSuccessView.setScanText((String)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      a("showOCRRecognizeView", false);
      if (this.jdField_e_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(this);
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130842902);
        this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(new aghu(this));
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(getString(2131433015));
      }
      localObject = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, getResources()), AIOUtils.a(40.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(40.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_e_of_type_AndroidWidgetImageView.bringToFront();
      return;
    }
  }
  
  private boolean h()
  {
    if (this.Z) {
      return this.Z;
    }
    if (!WorldCupConfigInfo.a(WorldCup.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface)))
    {
      if (this.jdField_f_of_type_Long == 2L) {
        QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. isSupportWorldCup == false. no world cup activity.");
      }
      this.Z = false;
      return false;
    }
    if (!WorldCup.a())
    {
      QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. isSupportWorldCup == false. Device not support.");
      this.Z = false;
      return false;
    }
    this.Z = true;
    QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. isSupportWorldCup == true.");
    return true;
  }
  
  private void i(String paramString)
  {
    if (this.X) {}
    label24:
    do
    {
      do
      {
        return;
        int i1 = 7;
        try
        {
          int i2 = Integer.parseInt(this.jdField_a_of_type_Agjr.jdField_g_of_type_JavaLangString);
          i1 = i2;
        }
        catch (Exception localException)
        {
          break label24;
        }
        WorldCupReport.a(i1);
        QLog.w("ScanTorchActivity", 1, "onClickOperateEntry[" + paramString + "], source[" + i1 + "], mH5Source[" + this.jdField_a_of_type_Agjr.jdField_g_of_type_JavaLangString + "]");
        ARWorldCupGameLogicManager.a().a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, this, a(), this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView);
        ax();
        if (this.jdField_b_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
          this.jdField_b_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
        }
        a(true);
      } while (!this.V);
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload == null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload = new ARWorldCupBaseResDownload(this.jdField_b_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager, this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener);
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.a()) || (!i()));
    if (this.jdField_b_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
      this.jdField_b_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
    }
    ARWorldCupGameLogicManager.a().a(this.jdField_e_of_type_AndroidWidgetFrameLayout, this.jdField_j_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetButton);
    a(false, false);
  }
  
  private void i(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHaiRedPackLookUpView, show=" + paramBoolean);
    }
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362424);
    if (!paramBoolean) {
      if (localLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localLinearLayout);
      }
    }
    while (localLinearLayout != null) {
      return;
    }
    localLinearLayout = new LinearLayout(this);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setId(2131362424);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ImageView(this);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    Object localObject2 = a("res/redpack/raise.png", true);
    if (localObject2 != null) {
      ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
    }
    localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(AIOUtils.a(130.5F, getResources()), AIOUtils.a(146.0F, getResources())));
    localObject1 = new ImageView(this);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    localObject2 = a("res/redpack/raisetips.png", true);
    if (localObject2 != null) {
      ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
    }
    localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(280.0F, getResources()), AIOUtils.a(70.0F, getResources()));
    ((LinearLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.a(20.0F, getResources()), 0, 0);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
  }
  
  private boolean i()
  {
    ArCloudConfigInfo.WorldCupResPath localWorldCupResPath = a();
    if (localWorldCupResPath == null)
    {
      this.V = false;
      if (this.jdField_p_of_type_AndroidWidgetImageView != null) {
        this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return this.V;
    }
    this.X = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(localWorldCupResPath);
    ay();
    WorldCup.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, 1);
    return true;
  }
  
  private void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("updateFlashLightView byUserClick=%s mIsFlashLightVisible=%s mIsFlashLightOn=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Q), Boolean.valueOf(this.R) }));
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView != null)
    {
      if ((this.Q) && (!this.R) && (!this.S))
      {
        this.S = true;
        au();
      }
    }
    else {
      return;
    }
    TextView localTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    boolean bool = this.Q;
    if (!paramBoolean)
    {
      paramBoolean = true;
      a(localTextView, bool, paramBoolean);
      if (!b())
      {
        localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
        if ((this.Q) && (!this.R)) {
          break label192;
        }
      }
    }
    label192:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(localTextView, paramBoolean, true);
      if (!this.R) {
        break label197;
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130842227, 0, 0);
      this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429933);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-16717057);
      return;
      paramBoolean = false;
      break;
    }
    label197:
    this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130842226, 0, 0);
    this.jdField_i_of_type_AndroidWidgetTextView.setText(2131429932);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private boolean j()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.a()) && (k());
  }
  
  private void k(boolean paramBoolean)
  {
    if ((!this.T) && (paramBoolean))
    {
      ReportController.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 1, 0, "", "", "", "");
      this.T = true;
    }
    while ((this.U) || (paramBoolean)) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008C91", "0X8008C91", 0, 0, "", "", "", "");
    this.U = true;
  }
  
  private boolean k()
  {
    boolean bool2 = ARDeviceController.a().a();
    boolean bool3 = ARDeviceController.a().b();
    this.jdField_v_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
    if ((bool2) && (bool3) && (this.jdField_v_of_type_Boolean) && (this.x)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. isArResReadyTmp = " + bool1 + ", isAREnable = " + bool2 + ", isSupportAr = " + bool3 + ", mIsArSoReady = " + this.jdField_v_of_type_Boolean + ", mIsVideoPluginReady = " + this.x);
      if (bool1) {
        this.jdField_b_of_type_Int = 100;
      }
      return bool1;
    }
  }
  
  private boolean l()
  {
    if ((this.jdField_w_of_type_Boolean) || (this.y) || (this.B) || (this.C)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. isArResDownloading = " + bool + ", mArSoDownloading = " + this.jdField_w_of_type_Boolean + ", mVideoPluginDownloading = " + this.y + ", mFaceModelDownloading = " + this.B + ", mFaceSoDownloading = " + this.C);
      return bool;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    ARCardUtils.jdField_a_of_type_Boolean = true;
    ARCardUtils.jdField_c_of_type_JavaLangString = b();
    Object localObject = getIntent();
    if (localObject != null)
    {
      ((Intent)localObject).setExtrasClassLoader(ScanTorchActivity.class.getClassLoader());
      jdField_i_of_type_Boolean = ((Intent)localObject).getBooleanExtra("log_on", false);
      this.jdField_h_of_type_JavaLangString = ((Intent)localObject).getStringExtra("CurrentNickname");
      this.jdField_i_of_type_JavaLangString = ((Intent)localObject).getStringExtra("CurrentLocInfo");
      localObject = ((Intent)localObject).getBundleExtra("ARRelationShipPromotion");
      if (QLog.isDevelopLevel()) {
        AudioHelper.a("ScanTorchActivity.initData", (Bundle)localObject);
      }
      this.jdField_f_of_type_Long = 0L;
      if (localObject != null) {
        this.jdField_f_of_type_Long = ((Bundle)localObject).getLong("ar_promotion_type", 0L);
      }
      if (this.jdField_f_of_type_Long != 2L) {
        break label278;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload == null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload = new ARWorldCupBaseResDownload(this.jdField_b_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager, this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener);
      }
      this.jdField_a_of_type_Agjr = new agju();
      this.jdField_a_of_type_Agjr.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agjr == null)
      {
        this.jdField_a_of_type_Agjr = new agjs();
        QLog.w("ScanTorchActivity", 1, "initData, 没有运营数据");
      }
      if (b()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(326);
      }
      this.jdField_a_of_type_ComTencentMobileqqArARArguments = new ARArguments(false);
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = new RemoteArConfigManager();
      r();
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager = new ARTipsManager(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, new agex(this));
      return;
      label278:
      if (this.jdField_f_of_type_Long == 1L)
      {
        agjq localagjq = new agjq();
        this.jdField_a_of_type_Agjr = localagjq;
        this.jdField_a_of_type_Agjr.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject);
        ARCardUtils.jdField_a_of_type_Boolean = agjq.a(localagjq);
        if (!ARCardUtils.jdField_a_of_type_Boolean) {
          ReportController.b(null, "dc00898", "", "", "0X8008F23", "0X8008F23", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_Agjr = new agjs();
        this.jdField_a_of_type_Agjr.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface, (Bundle)localObject);
      }
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("initArConfig mArEnabled=%s", new Object[] { Boolean.valueOf(this.I) }));
    }
    if (!this.I) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a(this, true, new agfl(this), new agfw(this), new aggh(this));
    this.jdField_m_of_type_Long = System.currentTimeMillis();
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("checkArConfigReady mHasGetARConfig=%s mHasFirstWindowFocus=%s", new Object[] { Boolean.valueOf(this.O), Boolean.valueOf(this.P) }));
    }
    if ((this.O) && (this.P))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(324);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(324);
    }
  }
  
  private void t()
  {
    boolean bool1 = ARDeviceController.a().a();
    boolean bool2 = ARDeviceController.a().b();
    QLog.i("ScanTorchActivity", 1, "checkArDependenceReady. isAREnable = " + bool1 + ", isSupportAr = " + bool2 + ", mIsArSoReady = " + this.jdField_v_of_type_Boolean + ", mIsVideoPluginReady = " + this.x);
    if ((bool1) && (bool2) && (this.jdField_v_of_type_Boolean) && (this.x))
    {
      this.jdField_q_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(b(), c());
        }
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a();
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.isEnableVideoRecord != 1L) {
            break label257;
          }
        }
      }
    }
    label257:
    for (bool1 = true;; bool1 = false)
    {
      ARVideoRecordUIControllerImpl.a().a(bool1);
      QLog.d("ScanTorchActivity", 1, String.format("checkARVideoRecordEnable enable=%s", new Object[] { Boolean.valueOf(bool1) }));
      E();
      if ((h()) && (this.jdField_f_of_type_Long == 2L) && (!j())) {
        aC();
      }
      return;
    }
  }
  
  private void u()
  {
    boolean bool = OCRManager.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("checkOCREnable enable=%s", new Object[] { Boolean.valueOf(bool) }));
    }
  }
  
  private void v()
  {
    long l2 = 8000L;
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("addTimeoutCheck mArEnabled=%s mHasCallRemoveTimeoutCheck=%s", new Object[] { Boolean.valueOf(this.I), Boolean.valueOf(this.ac) }));
    }
    if ((!this.I) || (this.ac)) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new aggu(this);
    }
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARNoResultCheckTime;
      if (l1 > 0L) {
        break label127;
      }
      l1 = l2;
    }
    label127:
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l1);
      return;
    }
  }
  
  private void w()
  {
    this.ac = true;
    this.F = false;
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "removeTimeoutCheck");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  private void x()
  {
    if ((!this.D) || (this.av)) {}
    do
    {
      do
      {
        return;
        if ((!this.jdField_v_of_type_Boolean) || (!this.x) || (!this.z) || (!this.A)) {
          break;
        }
      } while ((!this.E) && (!this.F));
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
      }
      this.E = false;
      this.F = false;
      ar();
    } while ((!f()) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.b()));
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.a())
    {
      e(9);
      return;
    }
    e(10);
    return;
    if (((!this.jdField_v_of_type_Boolean) && (!this.jdField_w_of_type_Boolean)) || ((!this.x) && (!this.y)) || ((!this.z) && (!this.B)) || ((!this.A) && (!this.C)))
    {
      QLog.i("ScanTorchActivity", 1, "ARLoadFailed. mIsArSoReady = " + this.jdField_v_of_type_Boolean + ", mArSoDownloading = " + this.jdField_w_of_type_Boolean + ", mIsVideoPluginReady = " + this.x + ", mVideoPluginDownloading = " + this.y + ", mIsFaceModelReady = " + this.z + ", mFaceModelDownloading = " + this.B + ", mIsFaceSoReady = " + this.A + ", mFaceSoDownloading = " + this.C);
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a("AR组件加载失败", "立即重试", new agij(this));
      }
      if ((!f()) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload.b())) {}
      for (;;)
      {
        this.E = true;
        ar();
        if (this.J) {
          break;
        }
        this.J = true;
        ReportController.b(null, "dc00898", "", "", "0X80085B5", "0X80085B5", 0, 0, "", "", "", "");
        return;
        e(10);
      }
    }
    z();
    this.F = true;
  }
  
  private void y()
  {
    if ((!this.D) || (this.av)) {}
    while (!this.F) {
      return;
    }
    z();
  }
  
  private void z()
  {
    int i2 = (this.jdField_g_of_type_Int + this.jdField_h_of_type_Int + this.jdField_i_of_type_Int + this.jdField_j_of_type_Int) / 4;
    this.jdField_b_of_type_Int = i2;
    if ((h()) && (f())) {
      b(11, (this.jdField_b_of_type_Int + this.jdField_e_of_type_Int) / 2);
    }
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy.a()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label150;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
      }
    }
    for (;;)
    {
      aq();
      if (!this.K)
      {
        this.K = true;
        ReportController.b(null, "dc00898", "", "", "0X80085B6", "0X80085B6", 0, 0, "", "", "", "");
      }
      return;
      i1 = 0;
      break;
      label150:
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a("AR组件加载中，请耐心等候...", i2);
      }
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Agjr != null) {
      return this.jdField_a_of_type_Agjr.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  String a(long paramLong)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      this.jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      String str = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ScanTorchActivity", 2, "getCurrentDateString exception", localException);
    }
    return localObject;
    return null;
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.startsWith("http")) {
        str = "http://" + paramString;
      }
    }
    return str;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    if (!this.au) {
      return;
    }
    runOnUiThread(new agiv(this, paramBoolean, paramFloat1));
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 13)
    {
      WorldCupShareFragment.a(this, ARWorldCupRecordController.jdField_a_of_type_JavaLangString, ARWorldCupRecordController.jdField_b_of_type_JavaLangString);
      WorldCupShareFragment.a("0X8009317", 1);
    }
    while (paramInt != 15) {
      return;
    }
    WorldCupShareFragment.a(this, ARWorldCupRecordController.jdField_a_of_type_JavaLangString, ARWorldCupRecordController.jdField_b_of_type_JavaLangString);
    WorldCupShareFragment.a("0X8009317", 2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.V) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidOsHandler.post(new aggo(this));
      w();
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      return;
    }
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(311);
  }
  
  public void a(int paramInt1, ARTarget paramARTarget, int paramInt2)
  {
    if (this.V) {
      return;
    }
    if ((paramARTarget == null) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null))
    {
      QLog.d("ScanTorchActivity", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
    }
    QLog.d("ScanTorchActivity", 1, "onARAnimationStateChanged, remainCount " + paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(this.jdField_a_of_type_Int), ", newState=", paramInt1 + ", target=" + paramARTarget });
    }
    label232:
    int i1;
    boolean bool;
    int i2;
    switch (paramInt1)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        this.jdField_a_of_type_Int = paramInt1;
        return;
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
        this.jdField_a_of_type_AndroidOsHandler.post(new aggb(this, paramARTarget));
        for (paramInt2 = 100;; paramInt2 = 100)
        {
          try
          {
            switch (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int)
            {
            case 0: 
              ReportController.b(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(i1), "");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              QLog.d("ScanTorchActivity", 1, "0X80081DF ReportController  error " + localException1.getMessage());
            }
            this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "2");
          }
          if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean)) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new aggc(this, paramARTarget));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
          return;
          if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
          {
            paramInt2 = 3;
            break label1706;
          }
          if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) {
            break label1706;
          }
          paramInt2 = 0;
          break label1706;
          if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
          {
            paramInt2 = 1;
            break label1712;
          }
          if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.i()) {
            break label1712;
          }
          paramInt2 = 5;
          break label1712;
          if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
          {
            paramInt2 = 2;
            break label1718;
          }
          bool = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j();
          if (bool)
          {
            paramInt2 = 4;
            break label1718;
          }
          paramInt2 = 6;
          break label1718;
          i1 = 0;
        }
        continue;
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
        if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) {
          this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "2");
        }
        if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int == 0) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int == 5)) {
          break label1691;
        }
        i2 = ARVideoUtil.a(paramARTarget);
        i1 = i2;
        if (i2 == 0) {
          i1 = 2147483647;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, "AREngineCallback.AR_ANIMATION_STATE_END, remainCount is " + i1 + ",remainCount" + paramInt2);
        }
        if (paramInt2 == 0) {
          i1 = 100;
        }
        label712:
        String str2;
        try
        {
          switch (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int)
          {
          case 0: 
            ReportController.b(null, "CliOper", "", "", "0X80081E1", "0X80081E1", 0, 0, paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, String.valueOf(i1), String.valueOf(i2), "");
            if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int != 1) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int != 0)) {
              break label1226;
            }
          }
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "1", "2", "");
              if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) {
                break label1082;
              }
              String str1 = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString.toLowerCase();
              if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(str1)) {
                break label1179;
              }
              if (!c()) {
                break label1160;
              }
              if (NetworkUtil.d(this)) {
                break label1094;
              }
              QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
              a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
              break;
              if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
              {
                i1 = 3;
                break label1734;
              }
              if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) {
                break label1734;
              }
              i1 = 0;
              break label1734;
              if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
              {
                i1 = 1;
                break label1740;
              }
              if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.i()) {
                break label1740;
              }
              i1 = 5;
              break label1740;
              if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
              {
                i1 = 2;
                break label1746;
              }
              bool = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j();
              if (bool)
              {
                i1 = 4;
                break label1746;
              }
              i1 = 6;
              break label1746;
              i2 = 0;
              i1 = 100;
            }
            localException2 = localException2;
            QLog.d("ScanTorchActivity", 1, "0X80081E1 ReportController  error " + localException2.getMessage());
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              QLog.d("ScanTorchActivity", 1, "0X80081DF ReportController  error " + localException3.getMessage());
              continue;
              label1082:
              str2 = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString;
            }
            label1094:
            this.jdField_g_of_type_JavaLangString = str2;
            this.jdField_b_of_type_JavaUtilHashMap.put(str2, Integer.valueOf(0));
            this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
            SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(300, 30000L);
          }
        }
        continue;
        label1160:
        this.jdField_a_of_type_AndroidOsHandler.post(new aggd(this));
        continue;
        label1179:
        if (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(str2)).intValue() == -1)
        {
          a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
          this.jdField_a_of_type_AndroidOsHandler.post(new agge(this));
        }
      }
      label1226:
      if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 0) || ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 1) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int == 1)) || ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (!TextUtils.isEmpty(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))) {}
      for (bool = true;; bool = false)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new aggf(this, paramARTarget, paramInt2, bool));
        this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "");
        break;
      }
    case 2: 
      label619:
      paramInt2 = 100;
    }
    for (;;)
    {
      try
      {
        switch (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int)
        {
        case 0: 
          ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, String.valueOf(paramInt2), String.valueOf(i1), "");
        }
      }
      catch (Exception localException4)
      {
        QLog.d("ScanTorchActivity", 1, "0X80081E1 ReportController  error " + localException4.getMessage());
        continue;
      }
      this.jdField_j_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
      this.jdField_a_of_type_AndroidOsHandler.post(new aggg(this));
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "");
      break;
      if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
      {
        paramInt2 = 3;
      }
      else if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
      {
        paramInt2 = 0;
        break label1761;
        if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
        {
          paramInt2 = 1;
          break label1767;
        }
        if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.i()) {
          break label1767;
        }
        paramInt2 = 5;
        break label1767;
        if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
        {
          paramInt2 = 2;
          break label1773;
        }
        bool = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j();
        if (bool)
        {
          paramInt2 = 4;
          break label1773;
        }
        paramInt2 = 6;
        break label1773;
        i1 = 0;
        paramInt2 = 100;
        continue;
        this.jdField_j_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
        this.jdField_a_of_type_AndroidOsHandler.post(new aggi(this));
        break;
        label1691:
        i1 = 1;
        break label619;
        i1 = 2;
        paramInt2 = 100;
        break label232;
        label1706:
        i1 = 2;
        break label232;
        label1712:
        i1 = 1;
        break label232;
        label1718:
        i1 = 1;
        break label232;
        i2 = 2;
        i1 = 100;
        break label712;
        label1734:
        i2 = 2;
        break label712;
        label1740:
        i2 = 1;
        break label712;
        label1746:
        i2 = 1;
        break label712;
        i1 = 2;
        paramInt2 = 100;
        continue;
      }
      label1761:
      i1 = 2;
      continue;
      label1767:
      i1 = 1;
      continue;
      label1773:
      i1 = 1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("ScanTorchActivity", 2, "onStartLoadUrl");
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new aggl(this, paramString));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
  }
  
  public void a(long paramLong, int paramInt, ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    if (this.V) {}
    label438:
    label994:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            w();
            if ((paramLong != 128L) || (!(paramARLocalRecogResultBase instanceof ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult))) {
              break label655;
            }
            paramARLocalRecogResultBase = (ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult)paramARLocalRecogResultBase;
            if (QLog.isColorLevel()) {
              QLog.d("ScanTorchActivity", 1, " externalRenderResult info is isValidData=" + paramARLocalRecogResultBase.jdField_a_of_type_Boolean + "isNeedShowViewFinder " + paramARLocalRecogResultBase.jdField_b_of_type_Boolean);
            }
            if (!paramARLocalRecogResultBase.jdField_a_of_type_Boolean)
            {
              this.ae = false;
              g(paramARLocalRecogResultBase.jdField_b_of_type_Boolean);
              this.jdField_a_of_type_AndroidOsHandler.post(new agfn(this));
              return;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("MIG object RectF(协议原始的数据) ");
              if (paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult == null) {
                break;
              }
              paramARRenderTrackInfo = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF.toString();
              QLog.d("AREngine_MIGObjectClassifyResult", 1, paramARRenderTrackInfo);
            }
            g(false);
          } while (paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult == null);
          Object localObject = new DrawView2.FaceData();
          ((DrawView2.FaceData)localObject).jdField_a_of_type_Float = 99.0F;
          ((DrawView2.FaceData)localObject).jdField_c_of_type_JavaLangString = ("相似度" + (int)(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_Double * 100.0D) + "%");
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, " scantorch activitity result ok " + paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_Double);
          }
          ((DrawView2.FaceData)localObject).jdField_a_of_type_Int = 10;
          ((DrawView2.FaceData)localObject).jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF);
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_MIGObjectClassifyResult", 1, "MIG mapMigObjectRect2Screen(协议转化后的数据) object RectF " + ((DrawView2.FaceData)localObject).jdField_a_of_type_AndroidGraphicsRectF);
          }
          ((DrawView2.FaceData)localObject).jdField_a_of_type_ArrayOfFloat = null;
          ((DrawView2.FaceData)localObject).jdField_h_of_type_JavaLangString = null;
          ((DrawView2.FaceData)localObject).jdField_c_of_type_Boolean = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_Boolean;
          ((DrawView2.FaceData)localObject).jdField_d_of_type_Boolean = false;
          ((DrawView2.FaceData)localObject).jdField_a_of_type_Boolean = true;
          ((DrawView2.FaceData)localObject).jdField_b_of_type_Boolean = true;
          ((DrawView2.FaceData)localObject).jdField_e_of_type_Boolean = false;
          ((DrawView2.FaceData)localObject).jdField_a_of_type_JavaLangString = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_JavaLangString))
          {
            paramARRenderTrackInfo = " ";
            ((DrawView2.FaceData)localObject).jdField_d_of_type_JavaLangString = paramARRenderTrackInfo;
            if (!TextUtils.isEmpty(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString)) {
              break label642;
            }
          }
          for (paramARRenderTrackInfo = " ";; paramARRenderTrackInfo = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString)
          {
            ((DrawView2.FaceData)localObject).jdField_e_of_type_JavaLangString = paramARRenderTrackInfo;
            ((DrawView2.FaceData)localObject).jdField_b_of_type_JavaLangString = null;
            ((DrawView2.FaceData)localObject).f = null;
            ((DrawView2.FaceData)localObject).jdField_g_of_type_JavaLangString = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_d_of_type_JavaLangString;
            if (QLog.isColorLevel())
            {
              QLog.d("ScanTorchActivity", 1, " label name is " + ((DrawView2.FaceData)localObject).jdField_a_of_type_JavaLangString + "isAutoJump " + ((DrawView2.FaceData)localObject).jdField_c_of_type_Boolean);
              if (TextUtils.isEmpty(paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_c_of_type_JavaLangString)) {
                QLog.d("ScanTorchActivity", 1, " profileContent    null  ");
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView != null) {
              this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new agfo(this));
            }
            paramARRenderTrackInfo = new ArrayList();
            paramARRenderTrackInfo.add(localObject);
            this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.setFaceData(paramARRenderTrackInfo);
            return;
            paramARRenderTrackInfo = "error happen";
            break;
            paramARRenderTrackInfo = paramARLocalRecogResultBase.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult.jdField_b_of_type_JavaLangString;
            break label438;
          }
          if (paramLong != 4L) {
            break;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null))
          {
            int i1 = this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
            if ((i1 != 3) && (i1 != 2) && (i1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
            }
          }
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            QLog.d("ScanTorchActivity", 2, "onARTrackComplete, recogType = " + paramLong + ",trackMode = " + paramInt + ",trackResult = " + paramARRenderTrackInfo + ",localRecogResult = " + paramARLocalRecogResultBase + ",isPause = " + this.jdField_p_of_type_Boolean);
          }
        } while ((this.jdField_p_of_type_Boolean) || (paramLong != 4L) || (!(paramARLocalRecogResultBase instanceof ARLocalFaceRecogResult)));
        paramARRenderTrackInfo = (ARLocalFaceRecogResult)paramARLocalRecogResultBase;
      } while (paramARRenderTrackInfo == null);
      if ((paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
      for (;;)
      {
        if (!paramARRenderTrackInfo.jdField_a_of_type_Boolean) {
          break label994;
        }
        this.jdField_o_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.c();
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a();
        this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new agfq(this));
        this.jdField_a_of_type_AndroidOsHandler.post(new agfr(this));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
          this.jdField_a_of_type_AndroidOsHandler.post(new agfp(this));
        }
      }
      if (!this.jdField_o_of_type_Boolean)
      {
        this.jdField_o_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.post(new agfs(this));
      }
      if (this.jdField_g_of_type_Long < 0L) {
        this.jdField_g_of_type_Long = System.currentTimeMillis();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView == null);
    label642:
    label655:
    if (this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new agft(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.setFaceData(paramARRenderTrackInfo.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(long paramLong, ARTarget paramARTarget)
  {
    if (this.V) {}
    do
    {
      return;
      w();
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
      }
      if ((paramARTarget != null) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ScanTorchActivity", 1, "onARRecogComplete empty value");
    return;
    String str;
    if (!this.am) {
      str = null;
    }
    for (;;)
    {
      try
      {
        localArrayList = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a();
        if (localArrayList == null) {
          break label703;
        }
        i1 = localArrayList.size();
      }
      catch (Exception localException1)
      {
        try
        {
          ArrayList localArrayList;
          str = localArrayList.toString();
          ScanEntranceReport.a().b(this.jdField_k_of_type_Long, this.jdField_l_of_type_Long, i1, str);
          ARDebugReport.a().b(this.jdField_k_of_type_Long, System.currentTimeMillis());
          this.am = true;
          if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f()) {
            break;
          }
          if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int != 1) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int != 0)) {
            continue;
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new agfg(this));
          if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) {
            continue;
          }
          str = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString.toLowerCase();
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(str)) {
            continue;
          }
          if (!c()) {
            continue;
          }
          if (NetworkUtil.d(this)) {
            continue;
          }
          QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
          a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject;
          continue;
        }
        localException1 = localException1;
        i1 = 0;
        localObject = null;
        continue;
        localObject = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString;
        continue;
        this.jdField_g_of_type_JavaLangString = ((String)localObject);
        this.jdField_b_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(0));
        this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(300, 30000L);
        if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new agfj(this, paramARTarget));
          if (!this.jdField_l_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(306);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(313, 100L);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(312, 100000L);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ScanTorchActivity", 1, "onARRecogComplete start jump :" + paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
          return;
          this.jdField_a_of_type_AndroidOsHandler.post(new agfh(this));
          continue;
          if (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(localObject)).intValue() != -1) {
            continue;
          }
          a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
          this.jdField_a_of_type_AndroidOsHandler.post(new agfi(this));
          continue;
        }
      }
      if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int != 6) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) || (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString))) {
        break;
      }
      paramARTarget = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramARTarget);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      startActivity((Intent)localObject);
      if (!(this instanceof Activity)) {
        break;
      }
      overridePendingTransition(2131034134, 0);
      return;
      label703:
      int i1 = 0;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, ARTarget paramARTarget)
  {
    if (this.V) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onAREnableModelRender, isEnable = " + paramBoolean);
    }
    int i1;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new agfu(this));
      i1 = 100;
    }
    for (;;)
    {
      try
      {
        switch (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_d_of_type_Int)
        {
        case 0: 
          ReportController.b(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, String.valueOf(i1), String.valueOf(i2), "");
        }
      }
      catch (Exception localException)
      {
        QLog.d("ScanTorchActivity", 1, "0X80081E0 ReportController  error " + localException.getMessage());
        continue;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null) || ((this.jdField_b_of_type_JavaUtilHashMap.containsValue(Integer.valueOf(0))) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "onARStateChanged, AR_RECOG_STATE_LOST in");
      }
      if (this.ah == true) {
        break;
      }
      f(true);
      this.jdField_a_of_type_AndroidOsHandler.post(new agfv(this));
      return;
      if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
      {
        i1 = 3;
      }
      else if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
      {
        i1 = 0;
        break label716;
        if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j())
        {
          i1 = 1;
          break label722;
        }
        if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.i()) {
          break label722;
        }
        i1 = 5;
        break label722;
        if (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
        {
          i1 = 2;
          break label728;
        }
        paramBoolean = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j();
        if (paramBoolean)
        {
          i1 = 4;
          break label728;
        }
        i1 = 6;
        break label728;
        i2 = 0;
        i1 = 100;
        continue;
        this.jdField_a_of_type_AndroidOsHandler.post(new agfx(this));
        String str;
        if ((paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 1) && (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int == 0))
        {
          i1 = 1;
          if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && ((i1 == 0) || (paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())))
          {
            f(false);
            this.jdField_a_of_type_AndroidOsHandler.post(new agfy(this));
          }
          if (i1 == 0) {
            break;
          }
          if (!paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) {
            break label565;
          }
          str = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString.toLowerCase();
        }
        for (;;)
        {
          if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(str))
          {
            if (c())
            {
              if (!NetworkUtil.d(this))
              {
                QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
                a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
                return;
                i1 = 0;
                break;
                label565:
                str = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString;
                continue;
              }
              this.jdField_g_of_type_JavaLangString = str;
              this.jdField_b_of_type_JavaUtilHashMap.put(str, Integer.valueOf(0));
              this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
              SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(300, 30000L);
              return;
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new agfz(this));
            return;
          }
        }
        if (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(str)).intValue() != -1) {
          break;
        }
        a(paramARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
        this.jdField_a_of_type_AndroidOsHandler.post(new agga(this));
        return;
        i2 = 2;
        i1 = 100;
        continue;
      }
      label716:
      int i2 = 2;
      continue;
      label722:
      i2 = 1;
      continue;
      label728:
      i2 = 1;
    }
  }
  
  public void a(Uri paramUri)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = paramUri;
      if (paramUri == null) {
        localObject = "null";
      }
      QLog.d("ScanTorchActivity", 2, new Object[] { "onDetectScreenshot, uri=", localObject });
    }
    if (!this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8006ABD", "0X8006ABD", 0, 0, "1", "", "", "");
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo1, ArCloudConfigInfo paramArCloudConfigInfo2, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onCommonCallbackFromUI, config=" + paramArCloudConfigInfo1 + ", action=" + paramInt1 + ", result=" + paramInt2 + ", data=" + paramObject);
    }
    if (((paramArCloudConfigInfo1 != null) && (paramArCloudConfigInfo1.a())) || ((paramArCloudConfigInfo2 != null) && (paramArCloudConfigInfo2.a()))) {}
    switch (paramInt1)
    {
    default: 
    case 10: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 54: 
      do
      {
        return;
        ThreadManager.post(new agig(this), 5, null, false);
        w();
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
        }
        ac();
        paramArCloudConfigInfo2 = (BinHaiHandler)this.jdField_b_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(3);
        this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo1;
        if (paramArCloudConfigInfo1 != null)
        {
          paramObject = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
          this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiConstants$FrameAnimConfig = BinHaiConstants.a(paramObject.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + paramObject.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "/" + "res/welcome/config.xml");
          this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiConstants$FrameAnimConfig.jdField_b_of_type_JavaLangString = "res/welcome/";
          a().b(paramArCloudConfigInfo1, 14, 1, null);
          if (!a().a().b()) {
            break label383;
          }
          paramArCloudConfigInfo2.a(paramArCloudConfigInfo1, paramArCloudConfigInfo1.jdField_b_of_type_JavaLangString + "");
        }
        for (;;)
        {
          this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008387", "0X8008387", 0, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiObserver.a(false, -101, "参加活动需要手机支持陀螺仪", "", 0, 0, 0, 0, 1L, 1L);
        }
        paramArCloudConfigInfo1 = Build.MODEL.toLowerCase();
        paramArCloudConfigInfo2 = Build.MANUFACTURER.toLowerCase();
        paramObject = new StringBuilder();
        paramObject.append("0");
        if (("MI 2".equalsIgnoreCase(paramArCloudConfigInfo1)) && ("Xiaomi".equalsIgnoreCase(paramArCloudConfigInfo2))) {
          paramObject.append(":no_look_down");
        }
        paramArCloudConfigInfo1 = paramObject.toString();
        QLog.d("ScanTorchActivity", 1, "binhai device:" + paramArCloudConfigInfo1);
        a(999, 888, paramArCloudConfigInfo1);
        if (this.at)
        {
          ad();
          return;
        }
        ae();
        return;
        ah();
        af();
        return;
        if (QLog.isColorLevel())
        {
          paramArCloudConfigInfo1 = new StringBuilder().append("ACTION_GAME_CALLBACK_CLICK_FUDAI, clicking=").append(this.an).append(", count=");
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger != null) {
            break label620;
          }
        }
        for (paramInt1 = 0;; paramInt1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
        {
          QLog.d("ScanTorchActivity", 2, paramInt1);
          if ((!this.an) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger == null)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new agih(this));
        return;
        paramArCloudConfigInfo1 = paramObject.toString().split(":");
      } while ((!this.au) || (paramArCloudConfigInfo1.length < 3));
      a(Float.parseFloat(paramArCloudConfigInfo1[0]), "1".equals(paramArCloudConfigInfo1[1]), Float.parseFloat(paramArCloudConfigInfo1[2]));
      return;
    case 52: 
      label383:
      this.jdField_n_of_type_Int += 1;
      label620:
      if (this.jdField_n_of_type_Int >= this.jdField_q_of_type_Int)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(339);
        this.jdField_a_of_type_AndroidOsHandler.post(new agii(this));
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new agil(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new agim(this));
  }
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    if (this.V) {
      return;
    }
    QLog.d("ScanTorchActivity", 2, "onLBSLocationComplete. retCode = " + paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int + ", LBSActivity = " + paramArLBSActivity);
    ThreadManager.getUIHandler().post(new agfa(this, paramARCloudLBSLocationCheckResult, paramArLBSActivity));
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    if (this.V) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new aggj(this, paramARRenderMangerInnerCallback, paramArVideoResourceInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onEnginePause resetFaceUI = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_o_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.c();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a();
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.post(new aggm(this));
      this.jdField_a_of_type_AndroidOsHandler.post(new aggn(this));
    }
  }
  
  public void a(boolean paramBoolean, BinHaiConstants.FrameAnimConfig paramFrameAnimConfig, FrameBmpCache.EndListener paramEndListener, BinHaiConstants.FrameAnimCallback paramFrameAnimCallback)
  {
    SdCardImageAnimView localSdCardImageAnimView = (SdCardImageAnimView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362433);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHaiFrameAnimView=" + paramBoolean + ", imageAnimView=" + localSdCardImageAnimView + " , config=" + paramFrameAnimConfig);
    }
    if (!paramBoolean)
    {
      if (localSdCardImageAnimView != null)
      {
        localSdCardImageAnimView.a();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localSdCardImageAnimView);
      }
      return;
    }
    if (localSdCardImageAnimView != null)
    {
      localSdCardImageAnimView.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localSdCardImageAnimView);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null)
    {
      QLog.d("ScanTorchActivity", 1, "showBinHaiFrameAnimView, mBinHaiCOnfisInfo is null");
      return;
    }
    localSdCardImageAnimView = new SdCardImageAnimView(this);
    localSdCardImageAnimView.setId(2131362433);
    float f1 = 1.0F * paramFrameAnimConfig.jdField_e_of_type_Int / paramFrameAnimConfig.jdField_d_of_type_Int;
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = (int)(f1 * i1);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHaiFrameAnimView:w=" + i1 + ", h=" + i2);
    }
    Object localObject = new RelativeLayout.LayoutParams(i1, i2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localSdCardImageAnimView, (ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
    localSdCardImageAnimView.setAnimationData(BinHaiConstants.a(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + ((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "/" + paramFrameAnimConfig.jdField_b_of_type_JavaLangString, paramFrameAnimConfig.jdField_c_of_type_Int));
    localSdCardImageAnimView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localSdCardImageAnimView.setFPS(paramFrameAnimConfig.jdField_b_of_type_Int);
    localSdCardImageAnimView.a().jdField_a_of_type_Boolean = true;
    localSdCardImageAnimView.setEndListener(paramEndListener);
    if (paramFrameAnimCallback != null) {
      paramFrameAnimCallback.a();
    }
    localSdCardImageAnimView.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    QLog.i("ScanTorchActivity", 1, "enableWorldCupMode. mIsWorldCupMode = " + this.V + ", on = " + paramBoolean);
    if (this.V == paramBoolean) {
      return this.V;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a() != null)) {
      if (paramBoolean)
      {
        if (this.jdField_p_of_type_AndroidWidgetImageView != null) {
          this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a().h(false);
        this.V = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(true);
        if (this.V) {
          break label137;
        }
        return this.V;
      }
    }
    for (this.V = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(paramBoolean);; this.V = false) {
      label137:
      return this.V;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ScanTorchActivity", 1, "pauseWorldCup. pause = " + paramBoolean1 + ", isOnlyUI = " + paramBoolean2);
    if (!this.V) {
      return this.Y;
    }
    if (!this.X) {
      return this.Y;
    }
    if (this.Y == paramBoolean1) {
      return this.Y;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a() != null)) {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.Y = paramBoolean1;
          this.jdField_a_of_type_AndroidOsHandler.post(new agjj(this));
        }
      }
    }
    label120:
    for (this.Y = paramBoolean1;; this.Y = true)
    {
      return this.Y;
      this.Y = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(true);
      break;
      WorldCup.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, 1);
      if (this.ab)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        if (paramBoolean2) {}
        for (this.Y = paramBoolean1;; this.Y = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(false))
        {
          f(true);
          L();
          break;
        }
      }
      this.ab = true;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      f(false);
      L();
      this.jdField_f_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new agjk(this, paramBoolean2, paramBoolean1), 1000L);
      break label120;
    }
  }
  
  public long b()
  {
    return this.jdField_k_of_type_Long;
  }
  
  String b()
  {
    if (this.jdField_a_of_type_Agjr != null) {
      return this.jdField_a_of_type_Agjr.jdField_g_of_type_JavaLangString;
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ScanTorchActivity", 2, "onInitComplete retCode" + paramInt);
    }
    if (paramInt != 0)
    {
      if (paramInt != 8) {
        break label50;
      }
      d(8);
    }
    label50:
    while (paramInt != 3) {
      return;
    }
    d(3);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 11)
    {
      if (this.jdField_c_of_type_Int == paramInt2) {}
      while ((this.jdField_c_of_type_Int != -1) && (paramInt2 < 90) && (paramInt2 / 10 == this.jdField_c_of_type_Int / 10)) {
        return;
      }
      this.jdField_c_of_type_Int = paramInt2;
    }
    ThreadManager.getUIHandler().post(new agfb(this, paramInt1, paramInt2));
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("ScanTorchActivity", 2, String.format("onPreOcrReqComplete containWords=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean)
    {
      w();
      T();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a(1);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Agjr instanceof agjq;
  }
  
  String c()
  {
    if ((this.jdField_a_of_type_Agjr instanceof agjq)) {
      return ((agjq)this.jdField_a_of_type_Agjr).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aghc(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    ARVideoRecordUIControllerImpl.a().b(4);
    if ((paramBoolean) && (this.as)) {
      QLog.i("ScanTorchActivity", 2, "doOnBackPressed inBinhai, return");
    }
    while ((this.V) && (ARWorldCupGameLogicManager.a().c())) {
      return;
    }
    if (this.aj)
    {
      W();
      return;
    }
    if (this.ak)
    {
      X();
      return;
    }
    setResult(11);
    finish();
  }
  
  boolean c()
  {
    boolean bool1 = ArMapUtil.c(this);
    boolean bool2 = ArMapUtil.b(this);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "isLbsEnabled, isNetworkOn = " + bool1 + ", isGPSOn = " + bool2);
    }
    return (bool1) || (bool2);
  }
  
  String d()
  {
    if ((this.jdField_a_of_type_Agjr instanceof agjq)) {
      return ((agjq)this.jdField_a_of_type_Agjr).jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public void d(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
      if (this.jdField_i_of_type_Long < 0L) {
        this.jdField_i_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "onArReady success");
      }
      if (this.jdField_k_of_type_Long > 0L)
      {
        ScanEntranceReport.a().a(this.jdField_k_of_type_Long, this.jdField_q_of_type_Long, this.N);
        ScanEntranceReport.a().a(this.jdField_m_of_type_Long, this.jdField_n_of_type_Long, this.jdField_o_of_type_Long, this.jdField_p_of_type_Long, this.jdField_q_of_type_Long);
      }
      if ((f()) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a().h(true);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(295);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(305);
      return;
    case 6: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(308);
      return;
    case 7: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(309);
      return;
    case 8: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(310);
      return;
    case 2: 
      if (this.jdField_i_of_type_Long < 0L) {
        this.jdField_i_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "onArReady open camera failed.");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(294);
      return;
    }
    if (this.jdField_i_of_type_Long < 0L) {
      this.jdField_i_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onArReady start ar failed.");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(296);
  }
  
  public void d(boolean paramBoolean)
  {
    SdCardImageAnimView localSdCardImageAnimView = (SdCardImageAnimView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362432);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showBinHai321goAnimView=" + paramBoolean + ", imageAnimView=" + localSdCardImageAnimView);
    }
    if (!paramBoolean) {
      if (localSdCardImageAnimView != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localSdCardImageAnimView);
      }
    }
    while (localSdCardImageAnimView != null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null)
    {
      QLog.d("ScanTorchActivity", 1, "showBinHai321goAnimView, mBinHaiCOnfisInfo is null");
      return;
    }
    localSdCardImageAnimView = new SdCardImageAnimView(this);
    localSdCardImageAnimView.setId(2131362432);
    int i1 = getResources().getDisplayMetrics().widthPixels;
    i1 = Math.min(AIOUtils.a(256.0F, getResources()), i1);
    Object localObject = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localSdCardImageAnimView, (ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
    localSdCardImageAnimView.setAnimationData(BinHaiConstants.a(((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString + ((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString + "/res/redpack/"));
    localSdCardImageAnimView.setFPS(12);
    localSdCardImageAnimView.a().jdField_a_of_type_Boolean = true;
    localSdCardImageAnimView.setEndListener(new agix(this));
    localSdCardImageAnimView.a();
    h("res/music/321ready.mp3");
  }
  
  boolean d()
  {
    SharedPreferences localSharedPreferences = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    boolean bool = localSharedPreferences.getBoolean("key_show_reddot", false);
    ArMapHandler localArMapHandler;
    long l1;
    if (!e())
    {
      localArMapHandler = (ArMapHandler)this.jdField_b_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2);
      l1 = localSharedPreferences.getLong("key_ar_act_id", 0L);
    }
    try
    {
      localArMapHandler.a(Long.parseLong(this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()), l1);
      label69:
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "shouldShowActRedDot  result = " + bool);
      }
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label69;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "doOnActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2 + ", data=" + paramIntent);
    }
    if (paramInt1 == 0)
    {
      String str = null;
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("ocr_pic_path");
      }
      if (TextUtils.isEmpty(str)) {
        break label248;
      }
      this.jdField_o_of_type_JavaLangString = str;
      f(false);
      h(false);
      f(this.jdField_o_of_type_JavaLangString);
    }
    for (;;)
    {
      if ((paramInt1 == 5) && (paramInt2 == -1) && (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog != null) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("result");
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, "doOnActivityResult, binhai=" + paramIntent);
        }
      }
      try
      {
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramInt1 = new JSONObject(paramIntent).optInt("resultCode", -1);
          if (paramInt1 == 0) {
            break label255;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(344);
          QLog.d("ScanTorchActivity", 1, "binhai remove MSG_BINHAI_FINISH_ACTIVITY");
          BinHaiHandler.a("binhai_open_redpack", false, paramInt1, true);
          if (!this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog.isShowing()) {
            this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog.show();
          }
        }
        return;
        label248:
        W();
        continue;
        label255:
        finish();
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("ScanTorchActivity", 2, "doOnActivityResult ex=" + paramIntent.getMessage(), paramIntent);
          return;
        }
        QLog.e("ScanTorchActivity", 1, "doOnActivityResult ex=" + paramIntent.getMessage());
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnBackPressed");
    }
    c(true);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnCreate");
    }
    getWindow().setFormat(-3);
    getWindow().addFlags(128);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(256);
      super.getWindow().addFlags(512);
    }
    this.jdField_u_of_type_Boolean = false;
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(ArConfigInfo.class.getClassLoader());
      long l2 = System.currentTimeMillis();
      super.doOnCreate(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, String.format("super.doOnCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) }));
      }
      setContentView(2130970507);
      if (isInMultiWindow())
      {
        QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
        finish();
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.d("ScanTorchActivity", 1, "doOnCreate fail!", paramBundle);
      this.jdField_a_of_type_MqqAppQQBroadcastReceiver = null;
      finish();
      return true;
    }
    hideTitleBar();
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("from_qr", false))) {
      this.I = paramBundle.getBooleanExtra("ar_enabled", false);
    }
    A();
    q();
    p();
    u();
    if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq__alive");
      paramBundle.addAction("tencent.ar.worldcup.finishScanTorch");
      registerReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver, paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver = new ScreenshotObserver(this.jdField_a_of_type_AndroidOsHandler, this);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.a(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    ARGlobalRemoteManager.a(this).a();
    ARVideoRecordUIControllerImpl.a().a();
    ARVideoRecordUIControllerImpl.a().a(this);
    ARVideoRecordUIControllerImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy);
    if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager = new ARCardHeadIconManager(this);
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager.a();
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager.a(getCurrentAccountUin());
    ScanEntranceReport.a().a();
    if (AREngine.b()) {
      H();
    }
    for (;;)
    {
      ARWorldCupGameLogicManager.a().a(this);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ScanTorchActivity", 2, String.format("doOnCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      return true;
      QLog.d("ScanTorchActivity", 1, "doOnCreate AREngine has not destroy? add Fragment later.");
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnDestroy,  needReportRedDot = " + this.jdField_n_of_type_Boolean);
    }
    if (this.jdField_n_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
    }
    if (this.V)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      a(false);
    }
    if (NeonControl.jdField_a_of_type_Boolean) {
      NeonControl.a().a();
    }
    SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiObserver != null) {
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiObserver);
    }
    O();
    try
    {
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_b_of_type_JavaUtilHashMap != null) {
        this.jdField_b_of_type_JavaUtilHashMap.clear();
      }
      N();
    }
    catch (Exception localException2)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b(4);
          this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a();
          this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = null;
        }
        if ((this.jdField_c_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null))
        {
          this.jdField_c_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_b_of_type_ComTencentBizUiTouchWebView);
          this.jdField_b_of_type_ComTencentBizUiTouchWebView = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView != null) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.a();
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
              QLog.d("ScanTorchActivity", 2, "doOnDestroy mControlPanelBtnFind stopPendulumAnim success. ");
            }
            super.doOnDestroy();
            this.jdField_u_of_type_Boolean = true;
            if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl != null) {
              this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl.e();
            }
            w();
            ScannerUtils.a(this);
            ARVideoRecordUIControllerImpl.a().g();
            ARGreetingCardListManager.a().a();
            ARWorldCupGameLogicManager.a().b();
            if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager.b();
              this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager = null;
            }
            return;
            localException1 = localException1;
            localException1.printStackTrace();
          }
          localException2 = localException2;
          QLog.d("ScanTorchActivity", 2, "doOnDestroy mArconfigManager unbind fail. ", localException2);
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            QLog.d("ScanTorchActivity", 2, "doOnDestroy mControlPanelBtnFind stopPendulumAnim fail. ", localException3);
          }
        }
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("doOnNewIntent filePath=%s", new Object[] { paramIntent }));
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      this.jdField_j_of_type_JavaLangString = paramIntent;
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnPause");
    }
    if (this.V)
    {
      a(true, true);
      ARWorldCupGameLogicManager.a().c();
      ARVideoRecordUIControllerImpl.a().f();
      this.jdField_p_of_type_Boolean = true;
      super.doOnPause();
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b(3);
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.d("ScanTorchActivity", 1, "doOnPause fail.", localException1);
        return;
      }
      ARVideoRecordUIControllerImpl.a().f();
      this.jdField_p_of_type_Boolean = true;
      if (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_b_of_type_ComTencentBizUiTouchWebView.onPause();
      }
      al();
      super.doOnPause();
      as();
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b(3);
        }
        if (this.ao)
        {
          this.ao = false;
          QLog.d("ScanTorchActivity", 1, "binhai send MSG_BINHAI_FINISH_ACTIVITY");
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(344, 2000L);
        }
        if (this.ak) {
          X();
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARLBSPOIDialog.dismiss();
        }
        if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          continue;
        }
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.d("ScanTorchActivity", 1, "doOnPause fail.", localException2);
        }
      }
    }
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    if (((this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog.isShowing())) || ((this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiMsgDialog.isShowing())))
    {
      a().b(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 14, 1, null);
      f(false);
    }
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnResume");
    }
    super.doOnResume();
    if (this.V)
    {
      this.jdField_p_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b(2);
      }
      ARVideoRecordUIControllerImpl.a().b();
      if ((isInMultiWindow()) && (!this.jdField_r_of_type_Boolean))
      {
        QQToast.a(this, "该功能可能无法在分屏模式下正常使用。", 1).a();
        this.jdField_r_of_type_Boolean = true;
      }
      a(false, true);
      return;
    }
    this.jdField_p_of_type_Boolean = false;
    if (!this.jdField_k_of_type_Boolean)
    {
      F();
      label108:
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(344);
      if (this.af) {
        f(true);
      }
      if (this.jdField_b_of_type_JavaUtilHashMap != null) {
        this.jdField_b_of_type_JavaUtilHashMap.clear();
      }
      if (this.ai)
      {
        this.ai = false;
        if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null) || (this.aj) || (this.ak)) {
          break label581;
        }
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(false);
        f(true);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.ah == true))
      {
        f(true);
        if (this.jdField_b_of_type_ComTencentBizUiTouchWebView != null) {
          this.jdField_b_of_type_ComTencentBizUiTouchWebView.setVisibility(4);
        }
      }
      this.ah = false;
      this.jdField_l_of_type_Boolean = false;
      this.jdField_m_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArFaceUIController != null) && (this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArFaceUIController.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
      }
      if ((this.aj) && (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = (ScreenUtil.jdField_a_of_type_Int / 2);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (ScreenUtil.jdField_b_of_type_Int / 2);
        localObject = URLDrawable.getDrawable(new File(this.jdField_o_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache != null) && (this.jdField_o_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_JavaLangString))) {
          a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$OcrResultCache.jdField_a_of_type_Long);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b(2);
      }
      if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
      {
        c(this.jdField_j_of_type_JavaLangString);
        this.jdField_j_of_type_JavaLangString = null;
        w();
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager.a();
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(true, 1000L);
      }
      ARVideoRecordUIControllerImpl.a().b();
      if ((!isInMultiWindow()) || (this.jdField_r_of_type_Boolean)) {
        break;
      }
      QQToast.a(this, "该功能可能无法在分屏模式下正常使用。", 1).a();
      this.jdField_r_of_type_Boolean = true;
      return;
      if ((!b()) || (this.jdField_f_of_type_AndroidWidgetTextView == null)) {
        break label108;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label108;
      label581:
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null) {
        f(false);
      }
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStart");
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.a();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "doOnStop");
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069CB", "0X80069CB", 0, 0, "1", String.valueOf(l1 - l2), "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.b();
    }
  }
  
  /* Error */
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 3915	com/tencent/mobileqq/olympic/activity/OlympicToolBaseActivity:doOnWindowFocusChanged	(Z)V
    //   5: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +37 -> 45
    //   11: ldc_w 483
    //   14: iconst_2
    //   15: ldc_w 3917
    //   18: iconst_2
    //   19: anewarray 487	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 668	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_0
    //   32: getfield 3919	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:G	Z
    //   35: invokestatic 668	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: invokestatic 499	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokestatic 502	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: monitorenter
    //   47: iload_1
    //   48: ifeq +23 -> 71
    //   51: aload_0
    //   52: getfield 2840	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:P	Z
    //   55: ifne +16 -> 71
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield 2840	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:P	Z
    //   63: aload_0
    //   64: invokespecial 2459	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:s	()V
    //   67: aload_0
    //   68: invokespecial 3921	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:v	()V
    //   71: aload_0
    //   72: monitorexit
    //   73: iload_1
    //   74: ifeq +10 -> 84
    //   77: aload_0
    //   78: invokestatic 552	java/lang/System:currentTimeMillis	()J
    //   81: putfield 1025	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_l_of_type_Long	J
    //   84: iload_1
    //   85: ifeq +89 -> 174
    //   88: aload_0
    //   89: getfield 3919	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:G	Z
    //   92: ifne +82 -> 174
    //   95: aload_0
    //   96: getfield 694	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArARScanFragment	Lcom/tencent/mobileqq/ar/ARScanFragment;
    //   99: ifnull +222 -> 321
    //   102: aload_0
    //   103: getfield 762	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   106: sipush 322
    //   109: invokevirtual 768	android/os/Handler:sendEmptyMessage	(I)Z
    //   112: pop
    //   113: aload_0
    //   114: getfield 762	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   117: sipush 321
    //   120: invokevirtual 768	android/os/Handler:sendEmptyMessage	(I)Z
    //   123: pop
    //   124: aload_0
    //   125: getfield 694	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArARScanFragment	Lcom/tencent/mobileqq/ar/ARScanFragment;
    //   128: ifnull +41 -> 169
    //   131: aload_0
    //   132: invokestatic 422	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   135: istore_2
    //   136: getstatic 771	com/tencent/mobileqq/shortvideo/util/ScreenUtil:jdField_b_of_type_Int	I
    //   139: istore_3
    //   140: aload_0
    //   141: getfield 694	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArARScanFragment	Lcom/tencent/mobileqq/ar/ARScanFragment;
    //   144: iload_2
    //   145: i2f
    //   146: iload_3
    //   147: i2f
    //   148: fdiv
    //   149: invokevirtual 774	com/tencent/mobileqq/ar/ARScanFragment:a	(F)V
    //   152: aload_0
    //   153: getfield 694	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_ComTencentMobileqqArARScanFragment	Lcom/tencent/mobileqq/ar/ARScanFragment;
    //   156: iload_3
    //   157: i2f
    //   158: iload_3
    //   159: i2f
    //   160: fdiv
    //   161: iload_2
    //   162: i2f
    //   163: iload_3
    //   164: i2f
    //   165: fdiv
    //   166: invokevirtual 777	com/tencent/mobileqq/ar/ARScanFragment:a	(FF)V
    //   169: aload_0
    //   170: iconst_1
    //   171: putfield 3919	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:G	Z
    //   174: iload_1
    //   175: ifeq +138 -> 313
    //   178: aload_0
    //   179: getfield 3923	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:M	Z
    //   182: ifne +131 -> 313
    //   185: aload_0
    //   186: invokevirtual 806	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:getIntent	()Landroid/content/Intent;
    //   189: astore 8
    //   191: aload 8
    //   193: ifnull +108 -> 301
    //   196: aload 8
    //   198: ldc_w 816
    //   201: iconst_0
    //   202: invokevirtual 820	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   205: istore_1
    //   206: aload 8
    //   208: ldc_w 808
    //   211: lconst_0
    //   212: invokevirtual 814	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   215: lstore 4
    //   217: aload 8
    //   219: ldc_w 3925
    //   222: lconst_0
    //   223: invokevirtual 814	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   226: lstore 6
    //   228: aload 8
    //   230: ldc_w 3927
    //   233: invokevirtual 2760	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 8
    //   238: invokestatic 1021	com/tencent/mobileqq/ar/ScanEntranceReport:a	()Lcom/tencent/mobileqq/ar/ScanEntranceReport;
    //   241: iload_1
    //   242: lload 4
    //   244: lload 6
    //   246: aload 8
    //   248: invokevirtual 3930	com/tencent/mobileqq/ar/ScanEntranceReport:a	(ZJJLjava/lang/String;)V
    //   251: aload_0
    //   252: getfield 3932	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:L	Z
    //   255: ifeq +46 -> 301
    //   258: lload 4
    //   260: lconst_0
    //   261: lcmp
    //   262: ifle +39 -> 301
    //   265: ldc_w 3934
    //   268: iconst_1
    //   269: anewarray 487	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: invokestatic 552	java/lang/System:currentTimeMillis	()J
    //   277: lload 4
    //   279: lsub
    //   280: invokestatic 615	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   283: aastore
    //   284: invokestatic 499	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   287: astore 8
    //   289: aload_0
    //   290: iconst_0
    //   291: aload 8
    //   293: iconst_0
    //   294: invokestatic 3937	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   297: invokevirtual 1431	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   300: pop
    //   301: aload_0
    //   302: iconst_1
    //   303: putfield 3923	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:M	Z
    //   306: aload_0
    //   307: invokestatic 552	java/lang/System:currentTimeMillis	()J
    //   310: putfield 1023	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_k_of_type_Long	J
    //   313: return
    //   314: astore 8
    //   316: aload_0
    //   317: monitorexit
    //   318: aload 8
    //   320: athrow
    //   321: aload_0
    //   322: invokespecial 3939	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:M	()V
    //   325: goto -156 -> 169
    //   328: astore 8
    //   330: goto -29 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	ScanTorchActivity
    //   0	333	1	paramBoolean	boolean
    //   135	27	2	i1	int
    //   139	25	3	i2	int
    //   215	63	4	l1	long
    //   226	19	6	l2	long
    //   189	103	8	localObject1	Object
    //   314	5	8	localObject2	Object
    //   328	1	8	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   51	71	314	finally
    //   71	73	314	finally
    //   316	318	314	finally
    //   289	301	328	java/lang/Exception
  }
  
  public String e()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public void e(int paramInt)
  {
    b(paramInt, 0);
  }
  
  boolean e()
  {
    boolean bool2 = false;
    String str1 = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).getString("key_click_reddot_date", null);
    String str2 = a(NetConnInfoCenter.getServerTimeMillis());
    boolean bool1 = bool2;
    if (str1 != null)
    {
      bool1 = bool2;
      if (str1.equals(str2)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "hasClickedRedDotToday  result = " + bool1 + ",curDate = " + str2 + ",clickDate = " + str1);
    }
    return bool1;
  }
  
  public String f()
  {
    return this.jdField_i_of_type_JavaLangString;
  }
  
  public boolean f()
  {
    return (h()) && ((this.jdField_f_of_type_Long == 2L) || (this.W));
  }
  
  public String g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArcardARCardHeadIconManager.a(getCurrentAccountUin());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.V) {
      return true;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null) {
        continue;
      }
      paramMessage = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, paramMessage);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(352);
      if (!g()) {
        continue;
      }
      f(false);
      this.ag = true;
      continue;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(313, 50L);
      this.jdField_d_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.jdField_d_of_type_Int);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null) {
        continue;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
      if ((this.ag) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(352, 2500L);
      }
      QLog.d("ScanTorchActivity", 1, "MSG_HIDE_SCAN_SUCCESS_PROGRESS,juhua has call finished ");
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setTotalProgress(this.jdField_d_of_type_Int);
      continue;
      if ((!this.ag) || (isFinishing())) {
        continue;
      }
      f(true);
      continue;
      ap();
      continue;
      e(false);
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
      {
        i1 = ImmersiveUtils.a(this);
        int i2 = ScreenUtil.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(i1 / i2);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(i2 / i2, i1 / i2);
      }
      if ((this.jdField_a_of_type_Agjr instanceof agjq))
      {
        paramMessage = (agjq)this.jdField_a_of_type_Agjr;
        ARGreetingCardListManager.a().a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, this, a(), this.jdField_d_of_type_AndroidWidgetFrameLayout, b(), agjq.a(paramMessage), this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramMessage.f, agjq.a(paramMessage), agjq.b(paramMessage), this.jdField_a_of_type_Agjr.jdField_g_of_type_JavaLangString);
        ARGreetingCardListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
      }
      if ((this.jdField_k_of_type_Long > 0L) && (this.L) && (this.mIsResume)) {
        paramMessage = String.format("AR初始化耗时:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_k_of_type_Long) });
      }
      try
      {
        QQToast.a(this, 0, paramMessage, 0).a();
        label711:
        if ((!f()) || (!j())) {
          continue;
        }
        i("MSG_AR_READY");
        continue;
        ao();
        continue;
        ao();
        continue;
        ao();
        continue;
        ao();
        continue;
        if (this.jdField_b_of_type_ComTencentBizUiTouchWebView == null) {
          continue;
        }
        this.jdField_b_of_type_ComTencentBizUiTouchWebView.onPause();
        continue;
        QQToast.a(this, 0, "摄像头被占用", 0).b(getTitleBarHeight());
        finish();
        continue;
        b("正在请求...");
        continue;
        paramMessage = (String)paramMessage.obj;
        this.jdField_b_of_type_JavaUtilHashMap.remove(paramMessage);
        if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null) {
          continue;
        }
        f(true);
        continue;
        paramMessage = (String)paramMessage.obj;
        this.jdField_b_of_type_JavaUtilHashMap.remove(paramMessage);
        this.jdField_b_of_type_JavaUtilHashMap.put(paramMessage, Integer.valueOf(-1));
        continue;
        P();
        QQToast.a(this, 0, "请求超时，请检查你的网络", 0).b(getTitleBarHeight());
        continue;
        paramMessage = (String)paramMessage.obj;
        if (TextUtils.isEmpty(paramMessage)) {
          return true;
        }
        g(paramMessage);
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(337);
        if ((!this.an) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger == null)) {
          continue;
        }
        ((BinHaiHandler)this.jdField_b_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(3)).a(this.jdField_p_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        this.jdField_l_of_type_Int += this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(338);
        b(false, paramMessage.arg1);
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(339);
        long l1 = System.currentTimeMillis();
        i1 = (int)(this.jdField_m_of_type_Int - (l1 - this.jdField_t_of_type_Long) / 1000L);
        float f1 = (float)(this.jdField_m_of_type_Int * 1000 - (l1 - this.jdField_t_of_type_Long)) * 1.0F / (this.jdField_m_of_type_Int * 1000);
        if (QLog.isColorLevel()) {
          QLog.d("ScanTorchActivity", 2, "MSG_REPORT_BINHAI_RAINING_COUNT_DOWN, time=" + i1);
        }
        if (paramMessage.arg1 == 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(true, i1, f1, bool);
          if (i1 >= 0) {
            break label1161;
          }
          ak();
          break;
        }
        label1161:
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(339);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 100L);
        continue;
        c(true, paramMessage.arg1);
        continue;
        paramMessage = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362431);
        if (paramMessage == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(paramMessage);
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(342);
        b(false, this.jdField_o_of_type_Int + 1);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView == null) {
          continue;
        }
        l1 = NetConnInfoCenter.getServerTimeMillis();
        l1 = this.jdField_v_of_type_Long - l1;
        if (l1 < 0L)
        {
          ag();
          continue;
        }
        paramMessage = BinHaiConstants.a(l1);
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramMessage);
        if (this.jdField_w_of_type_Long > 0L) {
          this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiFuDaiProgressView.a(this.jdField_w_of_type_Long - l1, this.jdField_w_of_type_Long);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(343, 66L);
        continue;
        QLog.d("ScanTorchActivity", 1, "binhai MSG_BINHAI_FINISH_ACTIVITY");
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog.isShowing())) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog.dismiss();
        }
        catch (Throwable paramMessage)
        {
          QLog.e("ScanTorchActivity", 1, "binhai MSG_BINHAI_FINISH_ACTIVITY", paramMessage);
        }
        continue;
        D();
        C();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(this.jdField_a_of_type_AndroidGraphicsRect);
        continue;
        M();
        continue;
        t();
        continue;
        if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (this.jdField_h_of_type_AndroidWidgetTextView == null)) {
          continue;
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString.replace("\\n", "\n"));
        continue;
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        at();
        this.jdField_g_of_type_AndroidWidgetTextView.setText(d());
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      catch (Exception paramMessage)
      {
        break label711;
      }
    }
  }
  
  public void i()
  {
    setResult(11);
    finish();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    this.jdField_s_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(312);
    QLog.d("ScanTorchActivity", 1, "scanTorch notifyRenderReady " + this.jdField_m_of_type_Boolean);
    if (this.jdField_m_of_type_Boolean)
    {
      k();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(313);
    }
  }
  
  public void k()
  {
    QLog.d("ScanTorchActivity", 1, "scanTorch notifyRenderReady isNotifyRecivied " + this.jdField_s_of_type_Boolean);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_b_of_type_ComTencentBizUiTouchWebView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      ARVideoRecordUIControllerImpl.a().b(6);
    }
    for (;;)
    {
      if (this.jdField_s_of_type_Boolean)
      {
        ARTransparentWebviewPlugin.b();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(307);
      }
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("ar_model", Build.MODEL);
      localHashMap.put("ar_type", "3");
      localHashMap.put("ar_reason", "1");
      StatisticCollector.a(BaseApplication.getContext()).a("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void l()
  {
    if (isFinishing()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = ArMapUtil.c(this);
      bool2 = ArMapUtil.b(this);
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "checkLBSSwitcher, isNetworkOn = " + bool1 + ", isGPSOn = " + bool2);
      }
    } while ((bool1) || (bool2));
    m();
  }
  
  void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "showOpenLBSDialog");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, "打开Wi-Fi和GPS定位服务，抢奖励会更准哦！现在开启？", "取消", "去开启", new aggs(this), new aggt(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    }
    if ((!isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("enterQuestionPreviewModel", new Object[0]));
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
    {
      AREngine localAREngine = this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
      if ((localAREngine != null) && (localAREngine.c()))
      {
        localAREngine.a(false);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b(true);
        this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.c(true);
        f(false);
      }
      Y();
      h(false);
      ThreadManager.getSubThreadHandler().post(new agho(this));
      this.ak = true;
      this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.g(this.ak);
    }
  }
  
  /* Error */
  public void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 2094	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:au	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 276	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   18: ldc_w 2095
    //   21: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +11 -> 37
    //   29: aload_0
    //   30: getfield 276	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   33: aload_2
    //   34: invokevirtual 1749	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   37: aload_0
    //   38: invokestatic 4104	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   41: ldc_w 4105
    //   44: aconst_null
    //   45: invokevirtual 4108	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   48: checkcast 274	android/widget/RelativeLayout
    //   51: astore_2
    //   52: aload_2
    //   53: ldc_w 2095
    //   56: invokevirtual 2428	android/widget/RelativeLayout:setId	(I)V
    //   59: aload_0
    //   60: getfield 276	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   63: aload_2
    //   64: new 428	android/widget/RelativeLayout$LayoutParams
    //   67: dup
    //   68: iconst_m1
    //   69: iconst_m1
    //   70: invokespecial 1091	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   73: invokevirtual 1092	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   76: aload_0
    //   77: ldc_w 4110
    //   80: iconst_1
    //   81: invokespecial 1108	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   84: astore_3
    //   85: aload_0
    //   86: aload_3
    //   87: fconst_0
    //   88: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   91: astore 4
    //   93: aload_0
    //   94: aload_3
    //   95: ldc_w 4113
    //   98: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   101: astore 5
    //   103: aload_0
    //   104: aload_2
    //   105: ldc_w 4114
    //   108: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   111: checkcast 301	android/widget/ImageView
    //   114: putfield 2097	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_g_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   117: aload_0
    //   118: getfield 2097	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_g_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   121: aload 5
    //   123: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   126: aload_0
    //   127: aload_2
    //   128: ldc_w 4115
    //   131: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   134: checkcast 301	android/widget/ImageView
    //   137: putfield 2099	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_h_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   140: aload_0
    //   141: getfield 2099	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_h_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   144: aload 4
    //   146: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   149: aload_0
    //   150: aload_3
    //   151: ldc_w 522
    //   154: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   157: astore 4
    //   159: aload_0
    //   160: aload_2
    //   161: ldc_w 4116
    //   164: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   167: checkcast 301	android/widget/ImageView
    //   170: putfield 2101	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_i_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   173: aload_0
    //   174: getfield 2101	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_i_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   177: aload 4
    //   179: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   182: aload_0
    //   183: aload_3
    //   184: ldc_w 4117
    //   187: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   190: astore 4
    //   192: aload_0
    //   193: aload_2
    //   194: ldc_w 4118
    //   197: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   200: checkcast 301	android/widget/ImageView
    //   203: putfield 2103	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_j_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   206: aload_0
    //   207: getfield 2103	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_j_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   210: aload 4
    //   212: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   215: aload_0
    //   216: aload_3
    //   217: ldc_w 4119
    //   220: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   223: astore 4
    //   225: aload_0
    //   226: aload_2
    //   227: ldc_w 4120
    //   230: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   233: checkcast 301	android/widget/ImageView
    //   236: putfield 2105	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_k_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   239: aload_0
    //   240: getfield 2105	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_k_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   243: aload 4
    //   245: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   248: aload_0
    //   249: aload_3
    //   250: ldc_w 4121
    //   253: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   256: astore 4
    //   258: aload_0
    //   259: aload_2
    //   260: ldc_w 4122
    //   263: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   266: checkcast 301	android/widget/ImageView
    //   269: putfield 2107	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_l_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   272: aload_0
    //   273: getfield 2107	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_l_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   276: aload 4
    //   278: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   281: aload_0
    //   282: aload_3
    //   283: ldc_w 4123
    //   286: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   289: astore 4
    //   291: aload_0
    //   292: aload_2
    //   293: ldc_w 4124
    //   296: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   299: checkcast 301	android/widget/ImageView
    //   302: putfield 2109	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_m_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   305: aload_0
    //   306: getfield 2109	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_m_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   309: aload 4
    //   311: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   314: aload_0
    //   315: aload_3
    //   316: ldc_w 4125
    //   319: invokespecial 4112	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/drawable/Drawable;
    //   322: astore_3
    //   323: aload_0
    //   324: aload_2
    //   325: ldc_w 4126
    //   328: invokevirtual 1743	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   331: checkcast 301	android/widget/ImageView
    //   334: putfield 2111	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_n_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   337: aload_0
    //   338: getfield 2111	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:jdField_n_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   341: aload_3
    //   342: invokevirtual 1096	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   345: aload_0
    //   346: iconst_1
    //   347: putfield 2094	com/tencent/mobileqq/olympic/activity/ScanTorchActivity:au	Z
    //   350: goto -339 -> 11
    //   353: astore_2
    //   354: aload_0
    //   355: monitorexit
    //   356: aload_2
    //   357: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	ScanTorchActivity
    //   6	2	1	bool	boolean
    //   24	301	2	localObject1	Object
    //   353	4	2	localObject2	Object
    //   84	258	3	localObject3	Object
    //   91	219	4	localDrawable1	Drawable
    //   101	21	5	localDrawable2	Drawable
    // Exception table:
    //   from	to	target	type
    //   2	7	353	finally
    //   14	25	353	finally
    //   29	37	353	finally
    //   37	350	353	finally
  }
  
  public void onClick(View paramView)
  {
    label425:
    label496:
    label503:
    Object localObject;
    switch (paramView.getId())
    {
    case 2131370942: 
    default: 
    case 2131370939: 
    case 2131363274: 
      do
      {
        return;
        c(false);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ScanTorchActivity", 2, "onClick R.id.text_help");
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      startActivity(paramView);
      this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069D3", "0X80069D3", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "", "");
      return;
    case 2131363275: 
      if (QLog.isColorLevel()) {
        QLog.i("ScanTorchActivity", 2, "onClick R.id.touch_view");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_e_of_type_Int == 1))
      {
        ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "0", "2", "");
        if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString.toLowerCase();
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramView)) {
            break label503;
          }
          if (!c()) {
            break label496;
          }
          if (NetworkUtil.d(this)) {
            break label425;
          }
          QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 1).b(getTitleBarHeight());
        }
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqArARTarget == null) || (this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString))) {
        while ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "");
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString;
          continue;
          this.jdField_g_of_type_JavaLangString = paramView;
          this.jdField_b_of_type_JavaUtilHashMap.put(paramView, Integer.valueOf(0));
          this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
          SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(297, 2000L);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(300, 30000L);
          L();
          continue;
          l();
          continue;
          if (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramView)).intValue() == -1)
          {
            QQToast.a(getApplicationContext(), "你已经参加过抽奖啦，不要太贪心哦。", 1).b(getTitleBarHeight());
            a(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false);
          }
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "0", "1", "");
        paramView = this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
        setResult(11);
        ARVideoRecordUIControllerImpl.a().b(3);
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", a(paramView));
        startActivity((Intent)localObject);
        this.af = true;
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (!this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())) {
          this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "2");
        }
        L();
        break;
        ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "0", "0", "");
        this.ah = true;
        if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.e(true);
          f(false);
        }
        G();
        J();
        if (this.jdField_a_of_type_ComTencentMobileqqArARScanFragment != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.a(1L);
          this.jdField_a_of_type_ComTencentMobileqqArARScanFragment.b();
        }
        k();
      }
    case 2131370941: 
      paramView = new Intent();
      paramView.setClass(this, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanTorchActivity.class.getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
      startActivity(paramView);
      AlbumUtil.a(this, false, true);
      return;
    case 2131370917: 
      paramView = this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        this.jdField_h_of_type_JavaLangString = paramView;
      }
      localObject = new Intent(this, QRDisplayActivity.class);
      ((Intent)localObject).putExtra("from", "ScannerActivity");
      ((Intent)localObject).putExtra("title", getString(2131430000));
      ((Intent)localObject).putExtra("nick", this.jdField_h_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uin", paramView);
      ((Intent)localObject).putExtra("type", 1);
      startActivity((Intent)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "find button clicked what2scanUrl = " + this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_b_of_type_ComTencentCommonAppAppInterface.reportClickEvent("dc00898", "", this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "0X8008615", "0X8008615", 0, 0, "", "", "", "");
    paramView = ArMapUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.b();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localObject = a(NetConnInfoCenter.getServerTimeMillis());
      paramView.edit().putString("key_click_reddot_date", (String)localObject).commit();
      paramView.edit().putBoolean("key_show_reddot", false).commit();
    }
    try
    {
      paramView = this.jdField_b_of_type_JavaLangString;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        paramView = "https://ti.qq.com/arinfo/index.html?_nav_alpha=true";
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "find button clicked jumpurl  = " + paramView);
      }
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("finish_animation_up_down", false);
      startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("ScanTorchActivity", 1, "find button clicked start QQBrowserActivity catch an Exception.", paramView);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    QLog.i("ScanTorchActivity", 2, "onMultiWindowModeChanged" + paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView == null) {}
    do
    {
      return;
      if (!isInMultiWindow()) {
        break;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.a());
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.b(true);
    this.jdField_q_of_type_Boolean = true;
    return;
    if (this.jdField_q_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView.a(true);
      this.jdField_q_of_type_Boolean = false;
    }
    this.jdField_r_of_type_Boolean = false;
  }
  
  void p()
  {
    QLog.i("ScanTorchActivity", 1, "WorldCupMainFlow. doOnCreate. mPromotionType = " + this.jdField_f_of_type_Long);
    AudioHelper.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface);
    if (this.jdField_f_of_type_Long == 2L)
    {
      ax();
      if (!h())
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        ThreadManager.getUIHandler().postDelayed(new agjp(this), 1000L);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload == null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload = new ARWorldCupBaseResDownload(this.jdField_b_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager, this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener);
      }
    }
    while (!h()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload == null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload = new ARWorldCupBaseResDownload(this.jdField_b_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager, this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener);
    }
    aw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ScanTorchActivity
 * JD-Core Version:    0.7.0.1
 */