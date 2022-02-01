package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.kandian.biz.biu.AtFriendsSpan;
import com.tencent.mobileqq.kandian.biz.biu.BiuTextBuilder;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo.Builder;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyBaseDeliverActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpWebCgiAsyncTask.Callback
{
  protected static int h = 8;
  protected float a;
  protected int a;
  protected long a;
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new ReadInJoyBaseDeliverActivity.4(this);
  protected TextWatcher a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected EditText a;
  protected ImageView a;
  protected TextView a;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new ReadInJoyBaseDeliverActivity.6(this);
  private IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  private PublicAccountGifListener jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = new ReadInJoyBaseDeliverActivity.9(this);
  private PublicAccountHotPicPanel jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  protected VisibleSetParam a;
  protected ReadInJoyDraftboxItem.ReadInJoyDraftboxContent a;
  protected ReadInJoyDraftboxModule a;
  protected INetInfoHandler a;
  protected TroopBarPOI a;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  protected ActionSheet a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = new ReadInJoyBaseDeliverActivity.5(this);
  protected XPanelContainer a;
  private String jdField_a_of_type_JavaLangString;
  protected ArrayList<TroopBarPOI> a;
  protected boolean a;
  protected float b;
  protected int b;
  protected ImageView b;
  private TextView b;
  protected ReadInJoyDraftboxItem.ReadInJoyDraftboxContent b;
  protected ActionSheet b;
  protected String b;
  protected boolean b;
  protected int c;
  protected ImageView c;
  protected String c;
  protected boolean c;
  protected int d;
  private ImageView d;
  protected String d;
  protected boolean d;
  protected int e;
  protected String e;
  protected boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  protected boolean g;
  protected boolean h = false;
  protected int i;
  protected boolean i;
  protected int j;
  protected boolean j;
  private int k = 0;
  protected boolean k;
  protected boolean l = false;
  protected boolean m = false;
  protected boolean n = false;
  protected boolean o = false;
  protected boolean p = true;
  private boolean q = true;
  
  public ReadInJoyBaseDeliverActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 100;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule = ReadInJoyLogicEngine.a().a();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructVisibleSetParam = VisibleSetParam.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructVisibleSetParam;
    this.jdField_i_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidTextTextWatcher = new ReadInJoyBaseDeliverActivity.10(this);
    this.jdField_j_of_type_Int = -1;
  }
  
  public static String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonInfo paramEmoticonInfo, EditText paramEditText)
  {
    int i1;
    int i2;
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      i1 = paramEditText.getSelectionStart();
      i2 = paramEditText.getSelectionEnd();
      if ((i1 < 0) || (i2 < 0) || (i2 < i1)) {
        return;
      }
      try
      {
        paramEditText.getEditableText().replace(i1, i2, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
        return;
      }
      catch (IllegalArgumentException paramQQAppInterface)
      {
        QLog.e("ReadInJoyBaseDeliverActivity", 2, "sendEmoticon: ", paramQQAppInterface);
        return;
      }
    }
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i1 = paramEditText.getSelectionStart();
      i2 = paramEditText.getSelectionEnd();
      int i3 = localSystemAndEmojiEmoticonInfo.emotionType;
      int i4 = localSystemAndEmojiEmoticonInfo.code;
      if ((i1 >= 0) && (i2 >= 0) && (i2 >= i1))
      {
        if (i4 == -1) {
          return;
        }
        if (i3 == 1) {}
        try
        {
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i4);
          break label149;
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(i4);
          label149:
          paramEditText.getEditableText().replace(i1, i2, paramEmoticonInfo);
          paramEditText.requestFocus();
        }
        catch (IllegalArgumentException paramEmoticonInfo)
        {
          QLog.e("ReadInJoyBaseDeliverActivity", 2, "sendEmoticon: ", paramEmoticonInfo);
        }
        localSystemAndEmojiEmoticonInfo.addToCommonUsed(paramQQAppInterface, null);
      }
    }
    else if ((paramEmoticonInfo instanceof ISmallEmoticonInfo))
    {
      paramQQAppInterface = (ISmallEmoticonInfo)paramEmoticonInfo;
      if (paramQQAppInterface.getEmoticon() == null)
      {
        QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion.");
        return;
      }
      new QueryTask(new ReadInJoyBaseDeliverActivity.7(), new ReadInJoyBaseDeliverActivity.8(paramEditText)).a(paramQQAppInterface);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setSelected(paramBoolean);
    }
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, TroopBarPublishLocationSelectActivity.class);
    localIntent.putParcelableArrayListExtra("current_location_list", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI);
    startActivityForResult(localIntent, 1002);
    overridePendingTransition(2130772006, 2130772007);
  }
  
  private void n()
  {
    int i1;
    if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != -1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      requestPermissions(new ReadInJoyBaseDeliverActivity.3(this), 40001, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    m();
  }
  
  private void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.18(this));
      return;
    }
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  protected Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new Dialog(paramContext, 2131756189);
    paramContext.setContentView(2131558954);
    TextView localTextView = (TextView)paramContext.findViewById(2131365648);
    if (localTextView != null) {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      } else {
        localTextView.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131365644);
    if (paramString1 != null) {
      if (paramString4 != null) {
        paramString1.setText(paramString4);
      } else {
        paramString1.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131365633);
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        paramString1.setText(paramString2);
        if (paramOnClickListener1 != null) {
          paramString1.setOnClickListener(paramOnClickListener1);
        }
      }
      else
      {
        paramString1.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131365639);
    if (paramString1 != null) {
      if (paramString3 != null)
      {
        paramString1.setText(paramString3);
        if (paramOnClickListener2 != null)
        {
          paramString1.setOnClickListener(paramOnClickListener2);
          return paramContext;
        }
      }
      else
      {
        paramString1.setVisibility(8);
      }
    }
    return paramContext;
  }
  
  protected Integer a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if (localObject != null) {
      return Integer.valueOf(localObject.length);
    }
    return Integer.valueOf(0);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368874));
    if (this.p) {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "input set error", localException);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366114));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363016));
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379036));
    localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364468));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131376809));
    localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    int i1 = 0;
    ((XPanelContainer)localObject).a(localEditText, false);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback);
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = XPanelContainer.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) {
        this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ReadInJoyBaseDeliverActivity.2(this);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    if (ThemeUtil.isInNightMode(this.app))
    {
      localObject = new View(this);
      ((View)localObject).setBackgroundColor(1996488704);
      addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364162));
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setOnClickListener(this);
      boolean bool = RIJUgcUtils.e();
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!bool) {
        i1 = 8;
      }
      ((TextView)localObject).setVisibility(i1);
    }
  }
  
  protected void a(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else
      {
        this.mSystemBarComp.init();
        if (!SystemUtil.d())
        {
          this.mSystemBarComp.setStatusBarColor(-2368549);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-1);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
    }
    getTitleBarView().setBackgroundColor(-1);
    String str = getString(paramInt);
    setTitle(str, str);
    this.centerView.setTextColor(-16777216);
    setLeftButton(2131717848, this);
    this.leftViewNotBack.setTextColor(-16777216);
    this.leftViewNotBack.setBackgroundColor(0);
    setRightButton(2131717857, this);
    this.rightViewText.setTextColor(Color.parseColor("#07D0B0"));
    this.rightViewText.setBackgroundColor(0);
    getWindow().setBackgroundDrawableResource(2131167394);
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!this.jdField_g_of_type_Boolean) {
        return;
      }
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
      if ((localObject1 != null) && (paramIntent != null))
      {
        int i1 = ((EditText)localObject1).getSelectionStart();
        localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
        paramInt = i1;
        Object localObject2;
        if (localObject1 != null)
        {
          paramInt = i1;
          if (!android.text.TextUtils.isEmpty(localObject1.toString()))
          {
            paramInt = i1;
            if (i1 > 0)
            {
              localObject2 = localObject1.toString();
              int i2 = i1 - 1;
              paramInt = i1;
              if (((String)localObject2).substring(i2, i1).equals("@"))
              {
                ((Editable)localObject1).delete(i2, i1);
                paramInt = i1 - 1;
                this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt);
              }
            }
          }
        }
        if (this.k <= 0)
        {
          this.k = getResources().getDisplayMetrics().widthPixels;
          this.k = (this.k - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
        }
        if (localObject1 != null)
        {
          localObject2 = paramIntent.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
            long l1;
            try
            {
              l1 = Long.parseLong(localResultRecord.a());
            }
            catch (NumberFormatException paramIntent)
            {
              QLog.d("ReadInJoyBaseDeliverActivity", 2, paramIntent.getMessage());
              l1 = 0L;
            }
            if (l1 != 0L)
            {
              paramIntent = ReadInJoyUserInfoModule.a(l1, null);
              if (paramIntent != null) {
                paramIntent = paramIntent.nick;
              } else {
                paramIntent = ReadInJoyUserInfoModule.a();
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("@");
              localStringBuilder.append(paramIntent);
              localStringBuilder.append(" ");
              paramIntent = new SpannableStringBuilder(localStringBuilder.toString());
              paramIntent.setSpan(new AtFriendsSpan(localResultRecord.a(), 0L, paramIntent, getApplicationContext(), this.jdField_a_of_type_AndroidWidgetEditText.getPaint(), this.k), 0, paramIntent.length(), 33);
              ((Editable)localObject1).insert(paramInt, paramIntent);
              paramInt += paramIntent.length();
            }
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt);
        }
      }
    }
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.19(this, paramInt, paramCharSequence));
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    int i1 = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            paramVarArgs = "";
            paramInt = i1;
          }
          else
          {
            localObject = getString(2131717337);
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              QQToast.a(this, paramVarArgs[0], 1).b(getTitleBarHeight());
            }
            e(false);
            paramInt = i1;
            paramVarArgs = (String[])localObject;
          }
        }
        else
        {
          paramVarArgs = getString(2131717338);
          e(false);
          paramInt = i1;
        }
      }
      else if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!android.text.TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (android.text.TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        e(true);
        paramInt = 1;
      }
      else
      {
        a(0, new String[0]);
        e(false);
      }
    }
    else
    {
      paramVarArgs = HardCodeUtil.a(2131712764);
      e(false);
      paramInt = i1;
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramVarArgs);
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      if (paramInt == 0) {
        paramVarArgs = getString(2131696251);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setContentDescription(paramVarArgs);
      }
    }
  }
  
  protected void a(Editable paramEditable)
  {
    int i1;
    if ((paramEditable instanceof BiuTextBuilder)) {
      i1 = ((BiuTextBuilder)paramEditable).a();
    } else {
      i1 = paramEditable.length();
    }
    paramEditable = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramEditable != null)
    {
      boolean bool = this.n;
      if ((bool) && (i1 - this.jdField_c_of_type_Int <= 0))
      {
        if (bool) {
          paramEditable.setVisibility(8);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - i1));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    if (i1 - this.jdField_c_of_type_Int > 0)
    {
      paramEditable = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramEditable != null) {
        paramEditable.setTextColor(Color.parseColor("#FF4222"));
      }
      this.jdField_d_of_type_Boolean = true;
    }
    else
    {
      paramEditable = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramEditable != null) {
        paramEditable.setTextColor(Color.parseColor("#BBBBBB"));
      }
      this.jdField_d_of_type_Boolean = false;
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    } else {
      this.jdField_b_of_type_Boolean = true;
    }
    if ((this.jdField_i_of_type_Boolean) && (Utils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
    {
      if ((this instanceof ReadInJoyDeliverBiuActivity))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009579", "0X8009579", 0, 0, "", "", "", a(), false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800953B", "0X800953B", 0, 0, "", "", "", a(), false);
    }
  }
  
  protected void a(TopicInfo paramTopicInfo)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
    if ((localObject1 != null) && (paramTopicInfo != null))
    {
      int i2 = ((EditText)localObject1).getSelectionStart();
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
      if (localObject1 != null)
      {
        int i1 = i2;
        if (!android.text.TextUtils.isEmpty(localObject1.toString()))
        {
          i1 = i2;
          if (i2 > 0)
          {
            localObject2 = localObject1.toString();
            int i3 = i2 - 1;
            i1 = i2;
            if (((String)localObject2).substring(i3, i2).equals("#"))
            {
              ((Editable)localObject1).delete(i3, i2);
              i1 = i2 - 1;
              this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i1);
            }
          }
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramTopicInfo.a());
        ((StringBuilder)localObject2).append(" ");
        localObject2 = new SpannableStringBuilder(((StringBuilder)localObject2).toString());
        ((SpannableStringBuilder)localObject2).setSpan(new TopicSpan(paramTopicInfo), 0, ((SpannableStringBuilder)localObject2).length(), 33);
        ((Editable)localObject1).insert(i1, (CharSequence)localObject2);
        i2 = ((SpannableStringBuilder)localObject2).length();
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i1 + i2);
      }
    }
  }
  
  protected void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    PublicFragmentActivity.a(this, new Intent(), ReadInJoySelectMemberFragment.class, 10000);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    if (paramInt != 3) {
      return;
    }
    if (paramJSONObject != null) {
      for (;;)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("poilist");
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          } else {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        catch (JSONException paramJSONObject)
        {
          if (!QLog.isColorLevel()) {
            break label232;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("get poi list error: ");
          paramBundle.append(paramJSONObject.toString());
          QLog.d("ReadInJoyBaseDeliverActivity", 2, paramBundle.toString());
        }
        if (paramInt < paramJSONObject.length())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
          paramInt += 1;
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
            this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0));
          }
          if (QLog.isColorLevel())
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI == null) {
              break label309;
            }
            paramJSONObject = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_a_of_type_Int) });
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, paramJSONObject);
      label232:
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI;
      if (paramJSONObject != null)
      {
        if (android.text.TextUtils.isEmpty(paramJSONObject.jdField_c_of_type_JavaLangString)) {
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_d_of_type_JavaLangString;
        } else {
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_c_of_type_JavaLangString;
        }
        a(1, new String[] { paramJSONObject });
        return;
      }
      a(0, new String[0]);
      return;
      a(3, new String[0]);
      return;
      paramInt = 0;
      break;
      label309:
      paramJSONObject = "current poi null";
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      this.q = paramBoolean;
      this.rightViewText.setEnabled(paramBoolean);
      if (paramBoolean)
      {
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
        return;
      }
      this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(2131717862);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131717861, 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoyBaseDeliverActivity.13(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoyBaseDeliverActivity.14(this, paramBoolean2, paramLong, paramBoolean1, paramInt));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver overlong!");
      }
      a(1, getString(2131717856));
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver network error!");
      }
      a(1, getString(2131717855));
      return false;
    }
    return true;
  }
  
  public String b()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("topicid", d());
      ((JSONObject)localObject).put("topic_num", a());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  protected void b()
  {
    Object localObject = getIntent();
    this.jdField_g_of_type_Int = ((Intent)localObject).getIntExtra("arg_ad_tag", 0);
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("arg_topic_id");
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("arg_topic_name");
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("arg_callback");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("arg_ugc_edit_cookie");
    if (this.h) {}
    try
    {
      localObject = TopicInfo.a().a(Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      a(((TopicInfo.Builder)localObject).a(localStringBuilder.toString()).a());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label131:
      int i1;
      break label131;
    }
    QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData: fail to add topic from intent");
    break label157;
    localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(4);
    }
    label157:
    if (!this.n)
    {
      i1 = ReadInJoyHelper.g(this.app);
      if (i1 > 0) {
        this.jdField_c_of_type_Int = i1;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initData count=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", mMaxWordCount=");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        QLog.d("ReadInJoyBaseDeliverActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.jdField_c_of_type_Int = RIJUgcUtils.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData unlimited mode");
      }
    }
    if (this.l)
    {
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ReadInJoyBaseDeliverActivity.NetInfoHandler(this, null);
      AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
  }
  
  protected void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && (paramInt2 == 0) && (isResume()))
    {
      paramCharSequence = paramCharSequence.toString().substring(paramInt1, paramInt1 + 1);
      if ((this.jdField_g_of_type_Boolean) && (paramCharSequence.equals("@")))
      {
        a("2");
        if ((this instanceof ReadInJoyDeliverUGCActivity)) {
          RIJDeliverUGCReportUtil.b("2");
        }
      }
      if ((this.h) && (paramCharSequence.equals("#")) && (a().intValue() < 10)) {
        d(2);
      }
    }
  }
  
  protected void b(String paramString) {}
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNet2None isFromWifi=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ReadInJoyBaseDeliverActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected String c()
  {
    Object localObject3 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      if (((Editable)localObject3).length() <= 0)
      {
        localObject1 = localObject2;
      }
      else
      {
        String str = UUID.randomUUID().toString();
        localObject3 = Utils.a(localObject3.toString(), str).trim();
        if (((String)localObject3).length() <= 0)
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject3;
          if (!this.o) {
            localObject1 = ((String)localObject3).replaceAll("\n|\r\n", "");
          }
          localObject1 = EmotionCodecUtils.a(Utils.b((String)localObject1, str));
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCommentString result=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReadInJoyBaseDeliverActivity", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      c(1);
      return;
    }
    c(2);
  }
  
  protected void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.jdField_d_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130843068);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130843070);
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
      if ((localObject != null) && (((XPanelContainer)localObject).a() != 1)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.jdField_d_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130849672);
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
      if ((localObject != null) && (((XPanelContainer)localObject).a() != 3)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130843070);
      }
    }
    else if (paramInt == 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130843070);
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
      if ((localObject != null) && (((XPanelContainer)localObject).a() != 0)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      localObject = this.jdField_d_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130843068);
      }
    }
    else if (paramInt == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
      if ((localObject != null) && (((XPanelContainer)localObject).a() != 24)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
      }
      localObject = this.jdField_d_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130843068);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130849672);
      }
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNet2Mobile isFromWifi=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ReadInJoyBaseDeliverActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected String d()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject[0].a().a());
      int i2 = localObject.length;
      int i1 = 1;
      while (i1 < i2)
      {
        localStringBuilder.append("|");
        localStringBuilder.append(localObject[i1].a().a());
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  protected void d()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80096D8", "0X80096D8", 0, 0, "", "", "", "", false);
    n();
  }
  
  protected void d(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.jdField_i_of_type_Int);
    QPublicFragmentActivity.startForResult(this, localIntent, ReadInJoyTopicSelectionFragment.class, 3001);
  }
  
  protected void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNet2Wifi isFromMobile=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ReadInJoyBaseDeliverActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1002)
    {
      if (paramInt1 != 3001)
      {
        if (paramInt1 != 10000) {
          return;
        }
        a(paramInt2, paramIntent);
        return;
      }
      if (paramIntent != null)
      {
        if (paramInt2 != -1) {
          return;
        }
        a((TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC"));
      }
    }
    else if (paramIntent != null)
    {
      if (paramInt2 != -1) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult: ");
        localStringBuilder.append(paramInt2);
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI;
        if (paramIntent != null) {
          paramIntent = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { paramIntent.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_a_of_type_Int) });
        } else {
          paramIntent = "current poi null";
        }
        localStringBuilder.append(paramIntent);
        QLog.d("ReadInJoyBaseDeliverActivity", 2, localStringBuilder.toString());
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI;
      if (paramIntent != null)
      {
        if (android.text.TextUtils.isEmpty(paramIntent.jdField_c_of_type_JavaLangString)) {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_d_of_type_JavaLangString;
        } else {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.jdField_c_of_type_JavaLangString;
        }
        a(1, new String[] { paramIntent });
      }
      else
      {
        a(0, new String[0]);
      }
      RIJDeliverUGCReportUtil.k();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject != null) {
      ((EditText)localObject).removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localObject != null)
    {
      ((XPanelContainer)localObject).c();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
    if (localObject != null)
    {
      ((PublicAccountHotPicPanel)localObject).setPublicAccountGifListener(null);
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.p) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyBaseDeliverActivity.1(this), 300L);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    int i1 = 0;
    while (i1 < localViewGroup.getChildCount())
    {
      View localView = localViewGroup.getChildAt(i1);
      if ((localView instanceof TopGestureLayout))
      {
        ((TopGestureLayout)localView).setInterceptTouchFlag(false);
        return;
      }
      i1 += 1;
    }
  }
  
  protected void e()
  {
    onBackEvent();
  }
  
  protected void e(int paramInt)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.c(paramInt);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  protected void f() {}
  
  public void finish()
  {
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localXPanelContainer != null) {
      localXPanelContainer.a();
    }
    if (this.jdField_f_of_type_Boolean) {
      setResult(this.jdField_d_of_type_Int, getIntent());
    }
    super.finish();
    overridePendingTransition(2130771991, 2130771992);
  }
  
  protected void g()
  {
    if (this.jdField_g_of_type_Boolean) {
      a("1");
    }
  }
  
  protected void h()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setMainTitle(HardCodeUtil.a(2131712740));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131712884), 9, "#ff000000");
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131712779), 3);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131712701));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoyBaseDeliverActivity.11(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoyBaseDeliverActivity.12(this));
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.15(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(getString(2131717868)).setNegativeButton(getString(2131717865), new ReadInJoyBaseDeliverActivity.17(this)).setPositiveButton(getString(2131717866), new ReadInJoyBaseDeliverActivity.16(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void l()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379036: 
      if (a().intValue() >= 10)
      {
        QQToast.a(this, 2131718066, 0).a();
        return;
      }
      d(1);
      return;
    case 2131369233: 
      a();
      return;
    case 2131369204: 
      e();
      return;
    case 2131366114: 
      c();
      return;
    case 2131364162: 
      d();
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity
 * JD-Core Version:    0.7.0.1
 */