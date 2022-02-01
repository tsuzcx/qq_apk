package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImgHeaderView
  extends RelativeLayout
  implements WadlCmdListener, IHeaderView, HippyViewBase
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQGameMsgInfo jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo;
  private HippyMap jdField_a_of_type_ComTencentMttHippyCommonHippyMap;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public ImgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Activity paramActivity, MessageRecord paramMessageRecord)
  {
    if (!((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(this.jdField_a_of_type_JavaLangString)) {
      a(paramActivity);
    }
    paramActivity = new HashMap();
    GameCenterUtils.a(paramActivity, QQGameConstant.a(paramMessageRecord, 0));
    paramActivity.put(Integer.valueOf(2), QQGameConstant.a(paramMessageRecord));
    paramActivity.put(Integer.valueOf(4), "20");
    AppInterface localAppInterface = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    GameCenterUtils.a(localAppInterface, "769", "205019", QQGameConstant.a(paramMessageRecord, 0), "76901", "1", "160", paramActivity);
    ((IApolloExtensionHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(3, paramMessageRecord.getExtInfoFromExtStr("pa_msgId"), this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramContext.startActivity(localIntent);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt, QQGameMsgInfo paramQQGameMsgInfo, String paramString3)
  {
    if (!((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(this.jdField_a_of_type_JavaLangString)) {
      a(paramContext);
    }
    paramContext = new HashMap();
    paramContext.put(Integer.valueOf(2), paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    paramContext.put(Integer.valueOf(3), localStringBuilder.toString());
    paramContext.put(Integer.valueOf(4), "20");
    paramContext.put(Integer.valueOf(24), paramString3);
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205019", paramString2, "76901", "1", "160", paramContext);
    ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(3, paramString1, this.jdField_a_of_type_JavaLangString);
    try
    {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(118, paramQQGameMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(QQGameMsgInfo paramQQGameMsgInfo)
  {
    Object localObject = URLUtil.a(paramQQGameMsgInfo.url);
    if (localObject != null)
    {
      if (((Map)localObject).containsKey("autodownload")) {
        this.jdField_a_of_type_Boolean = ((String)((Map)localObject).get("autodownload")).equals("1");
      }
      if (((Map)localObject).containsKey("autolaunch")) {
        this.b = ((String)((Map)localObject).get("autolaunch")).equals("1");
      }
    }
    if ((this.jdField_a_of_type_Boolean) || (this.b))
    {
      localObject = GamePubAccountHelper.a(paramQQGameMsgInfo.gameAppId);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramQQGameMsgInfo.gameAppId);
        ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getApkDownloadInfo("10000144", (ArrayList)localObject);
        return;
      }
      a((String)localObject);
    }
  }
  
  private void a(String paramString)
  {
    if (PackageUtil.a(BaseApplicationImpl.getContext(), paramString).equals("0")) {
      paramString = "下载游戏";
    } else {
      paramString = "启动游戏";
    }
    ThreadManagerV2.getUIHandlerV2().post(new ImgHeaderView.5(this, paramString));
  }
  
  public void a() {}
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo = paramQQGameMsgInfo;
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
    try
    {
      Object localObject2 = paramQQGameMsgInfo.coverUrl;
      Object localObject1 = paramQQGameMsgInfo.title;
      this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.url;
      if ("3".equals(paramString)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559148, this, false));
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559149, this, false));
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368631));
      localObject2 = URLDrawable.getDrawable((String)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378460));
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370699);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(-1);
      localObject2 = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412124557_I8OGtzphYZ.png", (URLDrawable.URLDrawableOptions)localObject2);
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365547));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(GamePubAccountConstant.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ImgHeaderView.3(this, paramContext, paramQQGameMsgInfo, paramInt, paramString));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ImgHeaderView.4(this, paramContext, paramQQGameMsgInfo, paramInt, paramString));
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      a(paramQQGameMsgInfo);
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      paramContext = new StringBuilder();
      paramContext.append("init imgHeader failed e=");
      paramContext.append(paramQQGameMsgInfo.toString());
      QLog.e("ImgHeaderView", 1, paramContext.toString());
    }
  }
  
  public void a(HippyArray paramHippyArray)
  {
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    localQQGameMsgInfo.coverUrl = paramHippyArray.getString(0);
    localQQGameMsgInfo.title = paramHippyArray.getString(1);
    localQQGameMsgInfo.url = paramHippyArray.getString(2);
    localQQGameMsgInfo.contentText = paramHippyArray.getString(3);
    localQQGameMsgInfo.limitText = paramHippyArray.getString(4);
    localQQGameMsgInfo.dateTitle = paramHippyArray.getString(5);
    localQQGameMsgInfo.paMsgid = paramHippyArray.getString(6);
    localQQGameMsgInfo.gameAppId = paramHippyArray.getString(7);
    localQQGameMsgInfo.frienduin = paramHippyArray.getString(8);
    localQQGameMsgInfo.uniseq = paramHippyArray.getLong(9);
    localQQGameMsgInfo.advId = paramHippyArray.getString(10);
    localQQGameMsgInfo.triggerInfo = paramHippyArray.getString(11);
    int i = paramHippyArray.getInt(12);
    a(localQQGameMsgInfo, BaseApplicationImpl.getContext(), i, GamePubAccountHelper.a());
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void d()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void e()
  {
    a(((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getMsgInfoByHippyMap(this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap), BaseApplicationImpl.getContext(), ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getMsgPosByHippyMap(this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap), GamePubAccountHelper.a());
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("13169");
    return localHashSet;
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if ("13169".equals(paramString)) {
      try
      {
        paramString = paramJSONObject.optJSONArray("v_appd_down_load_info").getJSONObject(0);
        paramIntent = paramString.optString("pkg_name");
        paramString = paramString.optString("appid");
        if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId.equals(paramString)))
        {
          GamePubAccountHelper.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGameMsgInfo.gameAppId, paramIntent);
          a(paramIntent);
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setSrc(HippyMap paramHippyMap)
  {
    this.jdField_a_of_type_ComTencentMttHippyCommonHippyMap = paramHippyMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ImgHeaderView
 * JD-Core Version:    0.7.0.1
 */