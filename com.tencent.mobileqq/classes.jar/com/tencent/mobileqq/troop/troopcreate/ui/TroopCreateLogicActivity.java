package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneShareApi;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateLogicActivity
  extends QBaseActivity
  implements ITroopCreateInfoService.TroopCreateCallback
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ICreateTroopShare jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateICreateTroopShare;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
  ITroopCreateService jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService = null;
  TroopManagerBizObserver jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver = new TroopCreateLogicActivity.2(this);
  ITroopShareUtility jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility;
  IWXShareHelperListener jdField_a_of_type_ComTencentMobileqqWxapiListenerIWXShareHelperListener = new TroopCreateLogicActivity.1(this);
  public String a;
  public boolean a;
  
  public TroopCreateLogicActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a()
  {
    if (getIntent() != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateICreateTroopShare.miniAppShareQQDirectly(getIntent(), this);
    }
  }
  
  private void a(String paramString, TroopCreateLogicActivity.OnGetBitmapCallback paramOnGetBitmapCallback)
  {
    if (paramOnGetBitmapCallback != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      paramString.setURLDrawableListener(new TroopCreateLogicActivity.5(this, paramString, paramOnGetBitmapCallback));
      paramString.setDownloadListener(new TroopCreateLogicActivity.6(this, paramString, paramOnGetBitmapCallback));
      if (paramString.getStatus() == 1)
      {
        paramOnGetBitmapCallback.a(BaseImageUtil.a(paramString, 100, 100));
        return;
      }
      paramString.startDownload();
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateICreateTroopShare.ShareToQQ(paramJSONObject, this);
  }
  
  private void b()
  {
    if (getIntent() != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateICreateTroopShare.miniAppShareQQDirectlyWithOutDialog(getIntent(), this);
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    Object localObject = paramJSONObject.optString("shareIcon");
    paramJSONObject = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.add(localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("title", str2);
    ((Bundle)localObject).putString("desc", str3);
    ((Bundle)localObject).putLong("req_share_id", 0L);
    ((Bundle)localObject).putString("detail_url", str1);
    ((Bundle)localObject).putString("url", str1);
    ((Bundle)localObject).putStringArrayList("image_url", paramJSONObject);
    ((Bundle)localObject).putString("bizname", "SharePlato");
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(this.mRuntime.getCurrentAccountUin(), this, (Bundle)localObject, null, 1001);
  }
  
  private void c()
  {
    Object localObject = getIntent();
    int i = ((Intent)localObject).getIntExtra("chanelId", -1);
    localObject = ((Intent)localObject).getStringExtra("params");
    try
    {
      localObject = new JSONObject((String)localObject);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("unrecognized channel! shareChanel = ");
              ((StringBuilder)localObject).append(i);
              QLog.e("qqBaseActivity", 1, ((StringBuilder)localObject).toString());
              finish();
              return;
            }
            d((JSONObject)localObject);
            return;
          }
          c((JSONObject)localObject);
          return;
        }
        b((JSONObject)localObject);
        return;
      }
      a((JSONObject)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "commonShare failed! exception = ", localException);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131694424, 1).a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new TroopCreateLogicActivity.3(this, str2, str3, str1));
    finish();
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131694424, 1).a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new TroopCreateLogicActivity.4(this, str2, str3, str1));
    finish();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    String str = "";
    localObject = (ITroopInfoService)((AppInterface)localObject).getRuntimeService(ITroopInfoService.class, "");
    if (localObject == null)
    {
      finish();
      return;
    }
    TroopInfo localTroopInfo = ((ITroopInfoService)localObject).findTroopInfo(paramString);
    if (localTroopInfo == null)
    {
      finish();
      return;
    }
    localObject = new JSONObject();
    paramString = str;
    try
    {
      if (!TextUtils.isEmpty(localTroopInfo.mRichFingerMemo)) {
        paramString = new QQText(localTroopInfo.mRichFingerMemo, 11).toPlainText();
      }
      ((JSONObject)localObject).put("classify", localTroopInfo.dwGroupClassExt);
      ((JSONObject)localObject).put("name", localTroopInfo.troopname);
      ((JSONObject)localObject).put("introduction", paramString);
      ((JSONObject)localObject).put("location", localTroopInfo.strLocation);
      ((JSONObject)localObject).put("percentage", "1.0");
      paramString = new Intent();
      paramString.putExtra("modifiedInfo", ((JSONObject)localObject).toString());
      setResult(-1, paramString);
      finish();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      finish();
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        String str1 = paramString;
        try
        {
          if (Long.parseLong(paramString) > 0L) {
            break label67;
          }
          finish();
          return;
        }
        catch (JSONException localJSONException1) {}
        finish();
      }
      catch (JSONException localJSONException2)
      {
        paramString = "";
      }
      localJSONException2.printStackTrace();
      String str2 = paramString;
      label67:
      if (TextUtils.isEmpty(str2))
      {
        finish();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin = str2;
      paramString = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      if (paramString != null)
      {
        paramString = paramString.findTroopInfo(str2);
        if (paramString != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopChatSetting(paramString, getResources(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember = true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility = ((ITroopShareUtility)QRoute.api(ITroopShareUtility.class));
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility.initTroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility.handleTroopLinkShare(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
      }
      return;
    }
    finish();
  }
  
  /* Error */
  public void c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 291	com/tencent/mobileqq/troop/troopcreate/ui/TroopCreateLogicActivity:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: astore 5
    //   6: iconst_0
    //   7: istore_2
    //   8: aload 5
    //   10: ifnull +162 -> 172
    //   13: aload_1
    //   14: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +155 -> 172
    //   20: new 121	org/json/JSONObject
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 210	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: ldc_w 365
    //   33: invokevirtual 368	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 6
    //   38: aload_1
    //   39: ldc_w 404
    //   42: invokevirtual 368	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 7
    //   47: aload 6
    //   49: invokestatic 374	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   52: lstore_3
    //   53: aload 7
    //   55: astore_1
    //   56: aload 6
    //   58: astore 5
    //   60: lload_3
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +117 -> 180
    //   66: iconst_1
    //   67: istore_2
    //   68: aload 7
    //   70: astore_1
    //   71: aload 6
    //   73: astore 5
    //   75: goto +105 -> 180
    //   78: astore 5
    //   80: aload 7
    //   82: astore_1
    //   83: aload 5
    //   85: astore 7
    //   87: aload 6
    //   89: astore 5
    //   91: goto +55 -> 146
    //   94: astore 5
    //   96: aload 7
    //   98: astore_1
    //   99: aload 5
    //   101: astore 7
    //   103: aload 6
    //   105: astore 5
    //   107: goto +57 -> 164
    //   110: astore 7
    //   112: ldc_w 293
    //   115: astore_1
    //   116: aload 6
    //   118: astore 5
    //   120: goto +26 -> 146
    //   123: astore 7
    //   125: ldc_w 293
    //   128: astore_1
    //   129: aload 6
    //   131: astore 5
    //   133: goto +31 -> 164
    //   136: astore 7
    //   138: ldc_w 293
    //   141: astore 5
    //   143: aload 5
    //   145: astore_1
    //   146: aload 7
    //   148: invokevirtual 405	java/lang/NumberFormatException:printStackTrace	()V
    //   151: goto +29 -> 180
    //   154: astore 7
    //   156: ldc_w 293
    //   159: astore 5
    //   161: aload 5
    //   163: astore_1
    //   164: aload 7
    //   166: invokevirtual 363	org/json/JSONException:printStackTrace	()V
    //   169: goto +11 -> 180
    //   172: ldc_w 293
    //   175: astore 5
    //   177: aload 5
    //   179: astore_1
    //   180: iload_2
    //   181: ifeq +66 -> 247
    //   184: new 308	com/tencent/mobileqq/data/troop/TroopInfo
    //   187: dup
    //   188: invokespecial 406	com/tencent/mobileqq/data/troop/TroopInfo:<init>	()V
    //   191: astore 6
    //   193: aload 6
    //   195: aload 5
    //   197: putfield 409	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   200: aload 6
    //   202: aload_1
    //   203: putfield 334	com/tencent/mobileqq/data/troop/TroopInfo:troopname	Ljava/lang/String;
    //   206: aload 6
    //   208: aload_0
    //   209: getfield 291	com/tencent/mobileqq/troop/troopcreate/ui/TroopCreateLogicActivity:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   212: invokevirtual 381	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   215: putfield 412	com/tencent/mobileqq/data/troop/TroopInfo:Administrator	Ljava/lang/String;
    //   218: aload_0
    //   219: getfield 291	com/tencent/mobileqq/troop/troopcreate/ui/TroopCreateLogicActivity:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   222: ldc_w 295
    //   225: ldc_w 293
    //   228: invokevirtual 301	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   231: checkcast 295	com/tencent/mobileqq/troop/api/ITroopInfoService
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +11 -> 247
    //   239: aload_1
    //   240: aload 6
    //   242: invokeinterface 416 2 0
    //   247: aload_0
    //   248: invokevirtual 236	com/tencent/mobileqq/troop/troopcreate/ui/TroopCreateLogicActivity:finish	()V
    //   251: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	TroopCreateLogicActivity
    //   0	252	1	paramString	String
    //   7	174	2	i	int
    //   52	9	3	l	long
    //   4	70	5	localObject1	Object
    //   78	6	5	localNumberFormatException1	java.lang.NumberFormatException
    //   89	1	5	localObject2	Object
    //   94	6	5	localJSONException1	JSONException
    //   105	91	5	localObject3	Object
    //   36	205	6	localObject4	Object
    //   45	57	7	localObject5	Object
    //   110	1	7	localNumberFormatException2	java.lang.NumberFormatException
    //   123	1	7	localJSONException2	JSONException
    //   136	11	7	localNumberFormatException3	java.lang.NumberFormatException
    //   154	11	7	localJSONException3	JSONException
    // Exception table:
    //   from	to	target	type
    //   47	53	78	java/lang/NumberFormatException
    //   47	53	94	org/json/JSONException
    //   38	47	110	java/lang/NumberFormatException
    //   38	47	123	org/json/JSONException
    //   20	38	136	java/lang/NumberFormatException
    //   20	38	154	org/json/JSONException
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService != null)
    {
      ((ITroopCreateInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(paramString, 5);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService.createTroop(this, this);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    ITroopCreateForStructMsg localITroopCreateForStructMsg;
    int i;
    if (paramInt1 != 3)
    {
      if (paramInt1 != 1001)
      {
        if (paramInt1 == 1002)
        {
          if (paramInt2 == -1)
          {
            localObject = paramIntent.getByteArrayExtra("stuctmsg_bytes");
            localITroopCreateForStructMsg = (ITroopCreateForStructMsg)QRoute.api(ITroopCreateForStructMsg.class);
            localITroopCreateForStructMsg.setAbsStructMsgFromByte((byte[])localObject);
            localObject = paramIntent.getStringExtra("uin");
            i = paramIntent.getIntExtra("uintype", -1);
            if ((localITroopCreateForStructMsg != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
            {
              localITroopCreateForStructMsg.sendStructingMsg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, i, null);
            }
            else if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("friendUin = ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" structMsg = ");
              localStringBuilder.append(localITroopCreateForStructMsg);
              QLog.e("qqBaseActivity", 2, localStringBuilder.toString());
            }
          }
          finish();
        }
      }
      else {
        finish();
      }
    }
    else
    {
      if (paramInt2 == -1)
      {
        i = getResources().getDimensionPixelSize(2131299168);
        QQToast.a(this, 2, getString(2131696494), 0).b(i);
        localObject = paramIntent.getByteArrayExtra("stuctmsg_bytes");
        localITroopCreateForStructMsg = (ITroopCreateForStructMsg)QRoute.api(ITroopCreateForStructMsg.class);
        localITroopCreateForStructMsg.setAbsStructMsgFromByte((byte[])localObject);
        if (!localITroopCreateForStructMsg.instanceofImgaeShare())
        {
          localObject = paramIntent.getStringExtra("uin");
          i = paramIntent.getIntExtra("uintype", -1);
          localITroopCreateForStructMsg.sendStructingMsg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, i, null);
          localITroopCreateForStructMsg.onDestroy();
        }
      }
      this.jdField_a_of_type_Boolean = false;
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService = ((ITroopCreateService)this.mRuntime.getRuntimeService(ITroopCreateService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateICreateTroopShare = ((ICreateTroopShare)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ICreateTroopShare.class, ""));
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", -1);
    if (i == 1)
    {
      d(paramBundle.getStringExtra("cfg"));
    }
    else if (i == 2)
    {
      e(paramBundle.getStringExtra("troop_uin"));
    }
    else if (i == 3)
    {
      b(paramBundle.getStringExtra("cfg"));
    }
    else if (i == 4)
    {
      a(paramBundle.getStringExtra("troop_uin"));
    }
    else if (i == 5)
    {
      String str = paramBundle.getStringExtra("troop_location");
      long l = paramBundle.getLongExtra("troop_uin", 0L);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
      ((ITroopManagerBizHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopManagerBizHandlerName())).a(l, TextUtils.isEmpty(str), str);
    }
    else if (i == 6)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService == null)
      {
        finish();
      }
      else
      {
        paramBundle = new Intent();
        paramBundle.putExtra("has_head", ((ITroopCreateInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo().hasTroopHead);
        setResult(-1, paramBundle);
        finish();
      }
    }
    else if (i == 7)
    {
      c(paramBundle.getStringExtra("cfg"));
    }
    else if (i == 8)
    {
      c();
    }
    else if (i == 9)
    {
      a();
    }
    else if (i == 10)
    {
      b();
    }
    else
    {
      finish();
    }
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(i);
    TroopTechReportUtils.a("TroopCreateLogicActivity", new String[] { paramBundle.toString() });
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility;
    if (localObject != null)
    {
      ((ITroopShareUtility)localObject).onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver((BusinessObserver)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateICreateTroopShare;
    if (localObject != null) {
      ((ICreateTroopShare)localObject).onDestroy();
    }
  }
  
  public void e(String paramString)
  {
    ITroopCreateService localITroopCreateService = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService;
    if (localITroopCreateService != null) {
      localITroopCreateService.terminateLogic();
    }
    TextUtils.isEmpty(paramString);
    finish();
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreateTroopCompletely(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("retCode", paramInt);
    localIntent.putExtra("troopUin", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  public void onInviteComplete(int paramInt, String paramString) {}
  
  public void onReusedTroop(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity
 * JD-Core Version:    0.7.0.1
 */