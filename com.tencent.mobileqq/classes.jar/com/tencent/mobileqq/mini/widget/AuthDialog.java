package com.tencent.mobileqq.mini.widget;

import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class AuthDialog
  extends Dialog
  implements View.OnClickListener
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_ONCE_SUB_RESULT_CB_1 = "key_once_sub_cb1";
  public static final String KEY_ONCE_SUB_RESULT_CB_2 = "key_once_sub_cb2";
  public static final String KEY_ONCE_SUB_RESULT_CB_3 = "key_once_sub_cb3";
  public static final String KEY_ONCE_SUB_RESULT_CB_MAINTAIN = "key_once_sub_cb_maintain";
  public static final String KEY_ONCE_SUB_RSP_DATA = "key_once_sub_rsp_data";
  public static final int REQUEST_CODE_ADD_PHONENUMBER = 1088;
  public static final int REQUEST_CODE_MANAGER_ADD_PHONENUMBER = 1090;
  public static final int REQUEST_CODE_PHONE_MANAGER = 1089;
  private static final String TAG = "AuthDialog";
  public static final int TYPE_NORMAL = 1;
  public static final int TYPE_ONCE_SUB_MSG = 3;
  public static final int TYPE_PHONENUMBER = 2;
  public static final int TYPE_SYS_SUB_MSG = 4;
  private String mAppId = null;
  private TextView mAuthDesc;
  private ImageView mAuthInfoBackIcon;
  private TextView mAuthInfoDetailText1;
  private TextView mAuthInfoDetailText2;
  private ImageView mAuthInfoImageView;
  private RelativeLayout mAuthInfoLayout;
  private TextView mAuthInfoTitle;
  private TextView mAuthTitle;
  private LinearLayout mConfirmLayout;
  private Activity mContext;
  private Bundle mData;
  private boolean mIsConfirm;
  private boolean mIsRefuse;
  private TextView mLeftBtn;
  private View mLineView1;
  private View mLineView2;
  private View mLineView3;
  private View mLineView4;
  private ImageView mMiniAppIcon;
  private LinearLayout mMiniAppInfoLayout;
  private TextView mMiniAppName;
  private TextView mOperateNumberBtn;
  private TextView mPhoneNumber1;
  private TextView mPhoneNumber2;
  private TextView mPhoneNumber3;
  private RelativeLayout mPhoneNumberLayout;
  private RelativeLayout mPhoneNumberLayout1;
  private RelativeLayout mPhoneNumberLayout2;
  private RelativeLayout mPhoneNumberLayout3;
  private ImageView mPhoneNumberSection1;
  private ImageView mPhoneNumberSection2;
  private ImageView mPhoneNumberSection3;
  private AuthDialog.AuthDialogResBuilder mResBuilder;
  private TextView mRightBtn;
  private View mRootView;
  private int mSelectPhoneNumber = 1;
  private int mType = 1;
  private ImageView mUserIcon;
  private TextView mUserName;
  private CheckBox onceSubCheckBox1;
  private CheckBox onceSubCheckBox2;
  private CheckBox onceSubCheckBox3;
  private RelativeLayout onceSubLayout1;
  private RelativeLayout onceSubLayout2;
  private RelativeLayout onceSubLayout3;
  private CheckBox onceSubMaintainCheckBox;
  private final CompoundButton.OnCheckedChangeListener onceSubOnCheckedChangeListener = new AuthDialog.1(this);
  private TextView onceSubTextView1;
  private TextView onceSubTextView2;
  private TextView onceSubTextView3;
  private ImageView onceSubTips1;
  private ImageView onceSubTips2;
  private ImageView onceSubTips3;
  private String uin = null;
  
  public AuthDialog(@NonNull Activity paramActivity)
  {
    super(paramActivity, 2131755403);
    this.mContext = paramActivity;
    initView(paramActivity);
  }
  
  public AuthDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, 2131755403);
    this.mContext = paramActivity;
    this.mType = paramInt;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if ((paramInt == 3) || (paramInt == 4)) {
          initOnceSubMsgView(paramActivity, paramInt);
        }
      }
      else {
        initPhoneNumberView(paramActivity);
      }
    }
    else {
      initView(paramActivity);
    }
    setCanceledOnTouchOutside(true);
    paramActivity = getWindow();
    if (paramActivity != null) {
      paramActivity.setGravity(80);
    }
    setActivityResultListener();
  }
  
  private void initOnceSubMsgView(Context paramContext, int paramInt)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559384, null);
    this.mRootView = paramContext;
    setContentView(paramContext);
    this.mMiniAppIcon = ((ImageView)paramContext.findViewById(2131371125));
    this.mMiniAppName = ((TextView)paramContext.findViewById(2131371140));
    this.mAuthTitle = ((TextView)paramContext.findViewById(2131363069));
    this.mLeftBtn = ((TextView)paramContext.findViewById(2131369942));
    this.mRightBtn = ((TextView)paramContext.findViewById(2131376561));
    this.onceSubLayout1 = ((RelativeLayout)paramContext.findViewById(2131376708));
    this.onceSubLayout2 = ((RelativeLayout)paramContext.findViewById(2131376709));
    this.onceSubLayout3 = ((RelativeLayout)paramContext.findViewById(2131376710));
    this.onceSubCheckBox1 = ((CheckBox)paramContext.findViewById(2131364387));
    this.onceSubCheckBox1.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
    this.onceSubCheckBox2 = ((CheckBox)paramContext.findViewById(2131364388));
    this.onceSubCheckBox2.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
    this.onceSubCheckBox3 = ((CheckBox)paramContext.findViewById(2131364389));
    this.onceSubCheckBox3.setOnCheckedChangeListener(this.onceSubOnCheckedChangeListener);
    this.onceSubMaintainCheckBox = ((CheckBox)paramContext.findViewById(2131364382));
    this.onceSubTextView1 = ((TextView)paramContext.findViewById(2131379795));
    this.onceSubTextView2 = ((TextView)paramContext.findViewById(2131379796));
    this.onceSubTextView3 = ((TextView)paramContext.findViewById(2131379797));
    this.onceSubTips1 = ((ImageView)paramContext.findViewById(2131369431));
    this.onceSubTips2 = ((ImageView)paramContext.findViewById(2131369432));
    this.onceSubTips3 = ((ImageView)paramContext.findViewById(2131369433));
    if (paramInt == 4) {
      paramContext.findViewById(2131376700).setVisibility(8);
    }
  }
  
  private void initPhoneNumberView(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559388, null);
    this.mRootView = paramContext;
    setContentView(paramContext);
    this.mMiniAppInfoLayout = ((LinearLayout)paramContext.findViewById(2131371126));
    this.mMiniAppIcon = ((ImageView)paramContext.findViewById(2131371125));
    this.mMiniAppName = ((TextView)paramContext.findViewById(2131371140));
    this.mAuthInfoImageView = ((ImageView)paramContext.findViewById(2131371069));
    this.mAuthInfoImageView.setOnClickListener(this);
    this.mAuthTitle = ((TextView)paramContext.findViewById(2131363069));
    this.mPhoneNumberLayout = ((RelativeLayout)paramContext.findViewById(2131371076));
    this.mPhoneNumberLayout1 = ((RelativeLayout)paramContext.findViewById(2131371147));
    this.mPhoneNumber1 = ((TextView)paramContext.findViewById(2131371143));
    this.mPhoneNumberSection1 = ((ImageView)paramContext.findViewById(2131371170));
    this.mPhoneNumberLayout1.setOnClickListener(this);
    this.mPhoneNumberLayout2 = ((RelativeLayout)paramContext.findViewById(2131371148));
    this.mPhoneNumber2 = ((TextView)paramContext.findViewById(2131371144));
    this.mPhoneNumberSection2 = ((ImageView)paramContext.findViewById(2131371171));
    this.mPhoneNumberLayout2.setOnClickListener(this);
    this.mPhoneNumberLayout3 = ((RelativeLayout)paramContext.findViewById(2131371149));
    this.mPhoneNumber3 = ((TextView)paramContext.findViewById(2131371145));
    this.mPhoneNumberSection3 = ((ImageView)paramContext.findViewById(2131371172));
    this.mPhoneNumberLayout3.setOnClickListener(this);
    this.mLineView1 = paramContext.findViewById(2131371071);
    this.mLineView2 = paramContext.findViewById(2131371072);
    this.mLineView3 = paramContext.findViewById(2131371073);
    this.mLineView4 = paramContext.findViewById(2131371074);
    this.mOperateNumberBtn = ((TextView)paramContext.findViewById(2131371075));
    this.mOperateNumberBtn.setOnClickListener(this);
    this.mConfirmLayout = ((LinearLayout)paramContext.findViewById(2131371064));
    this.mLeftBtn = ((TextView)paramContext.findViewById(2131371134));
    this.mRightBtn = ((TextView)paramContext.findViewById(2131371200));
    this.mAuthInfoLayout = ((RelativeLayout)paramContext.findViewById(2131371070));
    this.mAuthInfoBackIcon = ((ImageView)paramContext.findViewById(2131371065));
    this.mAuthInfoTitle = ((TextView)paramContext.findViewById(2131371068));
    this.mAuthInfoDetailText1 = ((TextView)paramContext.findViewById(2131371066));
    this.mAuthInfoDetailText2 = ((TextView)paramContext.findViewById(2131371067));
    this.mAuthInfoBackIcon.setOnClickListener(this);
    this.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  private void initView(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559372, null);
    this.mRootView = paramContext;
    setContentView(paramContext);
    this.mMiniAppIcon = ((ImageView)paramContext.findViewById(2131371125));
    this.mMiniAppName = ((TextView)paramContext.findViewById(2131371140));
    this.mAuthTitle = ((TextView)paramContext.findViewById(2131363069));
    this.mUserIcon = ((ImageView)paramContext.findViewById(2131380319));
    this.mUserName = ((TextView)paramContext.findViewById(2131380347));
    this.mAuthDesc = ((TextView)paramContext.findViewById(2131363057));
    this.mLeftBtn = ((TextView)paramContext.findViewById(2131369942));
    this.mRightBtn = ((TextView)paramContext.findViewById(2131376561));
  }
  
  private void loadOnceSubItemView(List<INTERFACE.StSubscribeMessage> paramList, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.onceSubTextView3.setText(((INTERFACE.StSubscribeMessage)paramList.get(2)).example.title.get());
        this.onceSubTips3.setOnClickListener(new AuthDialog.7(this, paramList));
        return;
      }
      this.onceSubTextView2.setText(((INTERFACE.StSubscribeMessage)paramList.get(1)).example.title.get());
      this.onceSubTips2.setOnClickListener(new AuthDialog.6(this, paramList));
      return;
    }
    this.onceSubTextView1.setText(((INTERFACE.StSubscribeMessage)paramList.get(0)).example.title.get());
    this.onceSubTips1.setOnClickListener(new AuthDialog.5(this, paramList));
  }
  
  private void loadOnceSubMsgBottomBtn()
  {
    TextView localTextView = this.mLeftBtn;
    if (localTextView != null)
    {
      localTextView.setText(HardCodeUtil.a(2131701230));
      this.mLeftBtn.setVisibility(0);
      this.mLeftBtn.setOnClickListener(new AuthDialog.3(this));
    }
    localTextView = this.mRightBtn;
    if (localTextView != null)
    {
      localTextView.setText(HardCodeUtil.a(2131701229));
      this.mRightBtn.setVisibility(0);
      this.mRightBtn.setOnClickListener(new AuthDialog.4(this));
    }
  }
  
  private void loadOnceSubMsgView()
  {
    Object localObject = getData();
    if (localObject != null)
    {
      byte[] arrayOfByte = ((Bundle)localObject).getByteArray("key_once_sub_rsp_data");
      localObject = new INTERFACE.StGetUserSettingRsp();
      if (arrayOfByte != null) {
        try
        {
          ((INTERFACE.StGetUserSettingRsp)localObject).mergeFrom(arrayOfByte);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("AuthDialog", 1, "loadOnceSubMsgView - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", localThrowable);
        }
      }
      if (((INTERFACE.StGetUserSettingRsp)localObject).setting != null)
      {
        localObject = ((INTERFACE.StGetUserSettingRsp)localObject).setting.subItems.get();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)((List)localObject).get(i);
          if (localStSubscribeMessage.authState.get() == 0) {
            localArrayList.add(localStSubscribeMessage);
          }
          i += 1;
        }
        i = localArrayList.size();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              QLog.e("AuthDialog", 1, "subMsgNoMaintainAuth size > 3 || size == 0!!");
              return;
            }
            this.onceSubLayout1.setVisibility(0);
            this.onceSubLayout2.setVisibility(0);
            this.onceSubLayout3.setVisibility(0);
            loadOnceSubItemView(localArrayList, 0);
            loadOnceSubItemView(localArrayList, 1);
            loadOnceSubItemView(localArrayList, 2);
            return;
          }
          this.onceSubLayout1.setVisibility(0);
          this.onceSubLayout2.setVisibility(0);
          this.onceSubLayout3.setVisibility(8);
          loadOnceSubItemView(localArrayList, 0);
          loadOnceSubItemView(localArrayList, 1);
          return;
        }
        this.onceSubLayout1.setVisibility(0);
        this.onceSubLayout2.setVisibility(8);
        this.onceSubLayout3.setVisibility(8);
        loadOnceSubItemView(localArrayList, 0);
      }
    }
  }
  
  private void realReportTo4239(String paramString)
  {
    String str2 = this.mResBuilder.getReportSubAction();
    MiniAppConfig localMiniAppConfig = this.mResBuilder.getMiniAppConfig();
    String str1;
    if (localMiniAppConfig.isReportTypeMiniGame()) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    MiniProgramLpReportDC04239.reportMiniAppEvent(localMiniAppConfig, str1, null, "scope", str2, paramString, null);
  }
  
  private void setActivityResultListener()
  {
    MiniAppController.getInstance().setActivityResultListener(new AuthDialog.2(this));
  }
  
  private void showOnceSubItemDetailDialog(INTERFACE.StSubscribeMessage paramStSubscribeMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showOnceSubItemDetailDialog detailItem: ");
    ((StringBuilder)localObject).append(paramStSubscribeMessage.example.title.get());
    QLog.e("AuthDialog", 1, ((StringBuilder)localObject).toString());
    localObject = this.mRootView;
    int i;
    int j;
    if (localObject != null)
    {
      i = ((View)localObject).getHeight();
      j = this.mRootView.getWidth();
    }
    else
    {
      i = -1;
      j = -1;
    }
    new AuthDetailDialog(this.mContext, paramStSubscribeMessage, i, j, 1).show();
  }
  
  private void updatePhoneNumberView(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Object localObject1 = StorageUtil.getPreference();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.uin);
      ((StringBuilder)localObject2).append("_PhoneNumber");
      localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updatePhoneNumberView phoneNumberArray length : ");
      ((StringBuilder)localObject2).append(paramJSONArray.length());
      QLog.d("AuthDialog", 1, ((StringBuilder)localObject2).toString());
      int i = paramJSONArray.length();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          localObject2 = paramJSONArray.optJSONObject(0);
          JSONObject localJSONObject = paramJSONArray.optJSONObject(1);
          paramJSONArray = paramJSONArray.optJSONObject(2);
          if ((localObject2 != null) && (localJSONObject != null) && (paramJSONArray != null))
          {
            this.mPhoneNumberLayout.setVisibility(0);
            this.mPhoneNumberLayout1.setVisibility(0);
            this.mPhoneNumberLayout2.setVisibility(0);
            this.mPhoneNumberLayout3.setVisibility(0);
            this.mPhoneNumber1.setText(((JSONObject)localObject2).optString("purePhoneNumber"));
            this.mPhoneNumber2.setText(localJSONObject.optString("purePhoneNumber"));
            this.mPhoneNumber3.setText(paramJSONArray.optString("purePhoneNumber"));
            if (((String)localObject1).equals(((JSONObject)localObject2).optString("purePhoneNumber")))
            {
              this.mPhoneNumberSection1.setVisibility(0);
              this.mSelectPhoneNumber = 1;
            }
            else
            {
              this.mPhoneNumberSection1.setVisibility(8);
            }
            if (((String)localObject1).equals(localJSONObject.optString("purePhoneNumber")))
            {
              this.mPhoneNumberSection2.setVisibility(0);
              this.mSelectPhoneNumber = 2;
            }
            else
            {
              this.mPhoneNumberSection2.setVisibility(8);
            }
            if (((String)localObject1).equals(paramJSONArray.optString("purePhoneNumber")))
            {
              this.mPhoneNumberSection3.setVisibility(0);
              this.mSelectPhoneNumber = 3;
            }
            else
            {
              this.mPhoneNumberSection3.setVisibility(8);
            }
            this.mLineView1.setVisibility(0);
            this.mLineView2.setVisibility(0);
            this.mLineView3.setVisibility(0);
            this.mLineView4.setVisibility(0);
            this.mOperateNumberBtn.setText("管理手机号码");
            this.mOperateNumberBtn.setVisibility(0);
          }
        }
        else
        {
          localObject2 = paramJSONArray.optJSONObject(0);
          paramJSONArray = paramJSONArray.optJSONObject(1);
          if ((localObject2 != null) && (paramJSONArray != null))
          {
            this.mPhoneNumberLayout.setVisibility(0);
            this.mPhoneNumberLayout1.setVisibility(0);
            this.mPhoneNumberLayout2.setVisibility(0);
            this.mPhoneNumberLayout3.setVisibility(8);
            this.mPhoneNumber1.setText(((JSONObject)localObject2).optString("purePhoneNumber"));
            this.mPhoneNumber2.setText(paramJSONArray.optString("purePhoneNumber"));
            if (((String)localObject1).equals(((JSONObject)localObject2).optString("purePhoneNumber")))
            {
              this.mPhoneNumberSection1.setVisibility(0);
              this.mSelectPhoneNumber = 1;
            }
            else
            {
              this.mPhoneNumberSection1.setVisibility(8);
            }
            if (((String)localObject1).equals(paramJSONArray.optString("purePhoneNumber")))
            {
              this.mPhoneNumberSection2.setVisibility(0);
              this.mSelectPhoneNumber = 2;
            }
            else
            {
              this.mPhoneNumberSection2.setVisibility(8);
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              this.mPhoneNumberSection1.setVisibility(0);
            }
            this.mPhoneNumberSection3.setVisibility(8);
            this.mLineView1.setVisibility(0);
            this.mLineView2.setVisibility(0);
            this.mLineView3.setVisibility(0);
            this.mLineView4.setVisibility(8);
            this.mOperateNumberBtn.setText("管理手机号码");
            this.mOperateNumberBtn.setVisibility(0);
          }
        }
      }
      else
      {
        paramJSONArray = paramJSONArray.optJSONObject(0);
        if (paramJSONArray != null)
        {
          this.mPhoneNumberLayout.setVisibility(0);
          this.mPhoneNumberLayout1.setVisibility(0);
          this.mPhoneNumberLayout2.setVisibility(8);
          this.mPhoneNumberLayout3.setVisibility(8);
          this.mPhoneNumber1.setText(paramJSONArray.optString("purePhoneNumber"));
          this.mPhoneNumberSection1.setVisibility(0);
          this.mPhoneNumberSection2.setVisibility(8);
          this.mPhoneNumberSection3.setVisibility(8);
          this.mSelectPhoneNumber = 1;
          this.mLineView1.setVisibility(0);
          this.mLineView2.setVisibility(0);
          this.mLineView3.setVisibility(8);
          this.mLineView4.setVisibility(8);
          this.mOperateNumberBtn.setText("使用其他号码");
          this.mOperateNumberBtn.setVisibility(0);
        }
      }
    }
  }
  
  public void bindData(Bundle paramBundle)
  {
    this.mData = paramBundle;
    if (paramBundle != null) {
      this.mAppId = paramBundle.getString("key_app_id");
    }
  }
  
  public Bundle getData()
  {
    return this.mData;
  }
  
  public JSONObject getSelectPhoneNumber()
  {
    try
    {
      if (this.mResBuilder != null)
      {
        JSONObject localJSONObject = this.mResBuilder.getPhoneNumberList().optJSONObject(this.mSelectPhoneNumber - 1);
        return localJSONObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AuthDialog", 1, "getSelectPhoneNumber error,", localThrowable);
    }
    return null;
  }
  
  protected URLDrawable getUrlDrawable(String paramString, int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt;
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIcon url: ");
        localStringBuilder.append(paramString);
        QLog.e("AuthDialog", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public boolean isConfirm()
  {
    return this.mIsConfirm;
  }
  
  public boolean isRefuse()
  {
    return this.mIsRefuse;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371149: 
      this.mPhoneNumberSection1.setVisibility(8);
      this.mPhoneNumberSection2.setVisibility(8);
      this.mPhoneNumberSection3.setVisibility(0);
      this.mSelectPhoneNumber = 3;
      return;
    case 2131371148: 
      this.mPhoneNumberSection1.setVisibility(8);
      this.mPhoneNumberSection2.setVisibility(0);
      this.mPhoneNumberSection3.setVisibility(8);
      this.mSelectPhoneNumber = 2;
      return;
    case 2131371147: 
      this.mPhoneNumberSection1.setVisibility(0);
      this.mPhoneNumberSection2.setVisibility(8);
      this.mPhoneNumberSection3.setVisibility(8);
      this.mSelectPhoneNumber = 1;
      return;
    case 2131371075: 
      paramView = new Intent();
      paramView.putExtra("appId", this.mAppId);
      if (this.mOperateNumberBtn.getText().equals("管理手机号码"))
      {
        AuthDialog.AuthDialogResBuilder localAuthDialogResBuilder = this.mResBuilder;
        if ((localAuthDialogResBuilder != null) && (localAuthDialogResBuilder.getPhoneNumberList() != null) && (this.mResBuilder.getPhoneNumberList().length() > 0)) {
          paramView.putExtra("phoneNumberList", this.mResBuilder.getPhoneNumberList().toString());
        }
        PublicFragmentActivity.Launcher.a(this.mContext, paramView, PublicFragmentActivityForMini.class, PhoneNumberManagementFragment.class, 1089);
        return;
      }
      PublicFragmentActivity.Launcher.a(this.mContext, paramView, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, 1088);
      return;
    case 2131371069: 
      this.mAuthInfoLayout.setVisibility(0);
      this.mAuthTitle.setVisibility(4);
      this.mMiniAppInfoLayout.setVisibility(4);
      this.mAuthInfoImageView.setVisibility(4);
      this.mAuthInfoImageView.setVisibility(4);
      this.mPhoneNumberLayout.setVisibility(4);
      this.mConfirmLayout.setVisibility(4);
      return;
    }
    this.mAuthInfoLayout.setVisibility(4);
    this.mAuthTitle.setVisibility(0);
    this.mMiniAppInfoLayout.setVisibility(0);
    this.mAuthInfoImageView.setVisibility(0);
    this.mAuthInfoImageView.setVisibility(0);
    this.mPhoneNumberLayout.setVisibility(0);
    this.mConfirmLayout.setVisibility(0);
  }
  
  public void reportAuthDialogCancelTo4239()
  {
    realReportTo4239("cancel");
  }
  
  public void reportAuthDialogClickTo4239()
  {
    realReportTo4239("click");
  }
  
  public void reportAuthDialogExpoTo4239()
  {
    realReportTo4239("expo");
  }
  
  public void setConfirm(boolean paramBoolean)
  {
    this.mIsConfirm = paramBoolean;
  }
  
  public void setRefuse(boolean paramBoolean)
  {
    this.mIsRefuse = paramBoolean;
  }
  
  public void show()
  {
    super.show();
    reportAuthDialogExpoTo4239();
  }
  
  public void show(AuthDialog.AuthDialogResBuilder paramAuthDialogResBuilder)
  {
    if (paramAuthDialogResBuilder == null)
    {
      QLog.e("AuthDialog", 1, "authdialog show error, resBuilder is null, return.");
      return;
    }
    if ((this.mType == 2) && ((paramAuthDialogResBuilder.getPhoneNumberList() == null) || (paramAuthDialogResBuilder.getPhoneNumberList().length() <= 0)))
    {
      QLog.e("AuthDialog", 1, "authdialog show error, getPhoneNumberList is null, return.");
      return;
    }
    this.mResBuilder = paramAuthDialogResBuilder;
    this.mIsConfirm = false;
    this.mIsRefuse = false;
    int i = ViewUtils.b(26.0F);
    URLDrawable localURLDrawable;
    if ((this.mMiniAppIcon != null) && (!TextUtils.isEmpty(paramAuthDialogResBuilder.getMiniAppIconUrl())))
    {
      localURLDrawable = getUrlDrawable(paramAuthDialogResBuilder.getMiniAppIconUrl(), i);
      if (localURLDrawable != null)
      {
        localURLDrawable.setTag(URLDrawableDecodeHandler.b(i, i, ViewUtils.b(5.0F)));
        localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.i);
        this.mMiniAppIcon.setImageDrawable(localURLDrawable);
      }
    }
    if ((this.mMiniAppName != null) && (!TextUtils.isEmpty(paramAuthDialogResBuilder.getMiniAppName()))) {
      this.mMiniAppName.setText(paramAuthDialogResBuilder.getMiniAppName());
    }
    if ((this.mAuthTitle != null) && (!TextUtils.isEmpty(paramAuthDialogResBuilder.getAuthTitle()))) {
      this.mAuthTitle.setText(paramAuthDialogResBuilder.getAuthTitle());
    }
    if (this.mUserIcon != null) {
      if (!TextUtils.isEmpty(paramAuthDialogResBuilder.getUserIconUrl()))
      {
        int j = ViewUtils.b(40.0F);
        localURLDrawable = getUrlDrawable(paramAuthDialogResBuilder.getUserIconUrl(), j);
        if (localURLDrawable != null)
        {
          localURLDrawable.setTag(URLDrawableDecodeHandler.a(i, i));
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.a);
          this.mUserIcon.setImageDrawable(localURLDrawable);
        }
        this.mUserIcon.setVisibility(0);
      }
      else
      {
        this.mUserIcon.setVisibility(8);
      }
    }
    if (this.mUserName != null) {
      if (!TextUtils.isEmpty(paramAuthDialogResBuilder.getUserName()))
      {
        this.mUserName.setText(paramAuthDialogResBuilder.getUserName());
        this.mUserName.setVisibility(0);
      }
      else
      {
        this.mUserName.setVisibility(8);
      }
    }
    i = this.mType;
    if ((i != 3) && (i != 4))
    {
      if (this.mLeftBtn != null) {
        if (!TextUtils.isEmpty(paramAuthDialogResBuilder.getLeftBtnText()))
        {
          this.mLeftBtn.setText(paramAuthDialogResBuilder.getLeftBtnText());
          this.mLeftBtn.setVisibility(0);
          if (paramAuthDialogResBuilder.getLeftBtnClickListener() != null) {
            this.mLeftBtn.setOnClickListener(paramAuthDialogResBuilder.getLeftBtnClickListener());
          }
        }
        else
        {
          this.mLeftBtn.setVisibility(8);
        }
      }
      if (this.mRightBtn != null) {
        if (!TextUtils.isEmpty(paramAuthDialogResBuilder.getRightBtnText()))
        {
          this.mRightBtn.setText(paramAuthDialogResBuilder.getRightBtnText());
          this.mRightBtn.setVisibility(0);
          if (paramAuthDialogResBuilder.getRightBtnClickListener() != null) {
            this.mRightBtn.setOnClickListener(paramAuthDialogResBuilder.getRightBtnClickListener());
          }
        }
        else
        {
          this.mRightBtn.setVisibility(8);
        }
      }
    }
    else
    {
      loadOnceSubMsgBottomBtn();
    }
    if (this.mAuthDesc != null) {
      if (!TextUtils.isEmpty(paramAuthDialogResBuilder.getAuthDesc()))
      {
        this.mAuthDesc.setVisibility(0);
        this.mAuthDesc.setText(paramAuthDialogResBuilder.getAuthDesc());
      }
      else
      {
        this.mAuthDesc.setVisibility(8);
      }
    }
    if (this.mType == 2) {
      updatePhoneNumberView(paramAuthDialogResBuilder.getPhoneNumberList());
    }
    i = this.mType;
    if ((i == 3) || (i == 4)) {
      loadOnceSubMsgView();
    }
    show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog
 * JD-Core Version:    0.7.0.1
 */