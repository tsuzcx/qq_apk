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
import androidx.annotation.VisibleForTesting;
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
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.kandian.biz.biu.BiuTextBuilder;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity;
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
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
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

@QQPermissionConfig(id="biz_src_kandian_publisher", scene="kandian_publisher_h5")
public class ReadInJoyBaseDeliverActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpWebCgiAsyncTask.Callback
{
  protected static int Q = 8;
  protected boolean A = true;
  protected boolean B = true;
  protected ViewTreeObserver.OnGlobalLayoutListener C;
  protected int D = 0;
  protected int E = 0;
  protected boolean F;
  protected String G;
  protected String H;
  protected String I;
  protected int J;
  protected String K;
  protected boolean L = false;
  protected boolean M = false;
  protected INetInfoHandler N;
  protected float O = 0.0F;
  protected float P = 0.0F;
  protected boolean R = false;
  protected boolean S = false;
  protected TroopBarPOI T = null;
  protected ArrayList<TroopBarPOI> U = null;
  protected ReadInJoyDraftboxModule V = ReadInJoyLogicEngine.a().Z();
  protected long W = -1L;
  protected ReadInJoyDraftboxItem.ReadInJoyDraftboxContent X;
  protected ReadInJoyDraftboxItem.ReadInJoyDraftboxContent Y;
  protected boolean Z = true;
  private ImageView a;
  protected VisibleSetParam aa = VisibleSetParam.a;
  protected boolean ab;
  protected int ac = 0;
  protected String ad = "";
  protected TextWatcher ae = new ReadInJoyBaseDeliverActivity.10(this);
  protected int af = -1;
  private TextView ag;
  private QQPermission.BasePermissionsListener ah;
  private QQPermission ai;
  private Editable.Factory aj = new ReadInJoyBaseDeliverActivity.4(this);
  private XPanelContainer.PanelCallback ak = new ReadInJoyBaseDeliverActivity.5(this);
  private EmoticonCallback al = new ReadInJoyBaseDeliverActivity.6(this);
  private PublicAccountGifListener am = new ReadInJoyBaseDeliverActivity.9(this);
  private int an = 0;
  private IEmoticonMainPanel b;
  private PublicAccountHotPicPanel c;
  private boolean d = true;
  protected BiuEditText e;
  protected ImageView f;
  protected ImageView g;
  protected ImageView h;
  protected TextView i;
  protected XPanelContainer j;
  protected QQProgressDialog k;
  protected ActionSheet l;
  protected ActionSheet m;
  protected QQCustomDialog n;
  protected boolean o = false;
  protected int p = 1;
  protected int q = 1;
  protected boolean r = false;
  protected boolean s = false;
  protected boolean t = false;
  protected int u = 100;
  protected boolean v = false;
  protected boolean w = true;
  protected int x = 0;
  protected boolean y = true;
  protected boolean z = false;
  
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
          break label151;
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(i4);
          label151:
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
    TextView localTextView = this.ag;
    if (localTextView != null) {
      localTextView.setSelected(paramBoolean);
    }
  }
  
  public static String h()
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
  
  private void s()
  {
    this.ah = new ReadInJoyBaseDeliverActivity.3(this);
  }
  
  private void t()
  {
    Intent localIntent = new Intent(this, TroopBarPublishLocationSelectActivity.class);
    localIntent.putParcelableArrayListExtra("current_location_list", this.U);
    localIntent.putExtra("key_selected_poi", this.T);
    startActivityForResult(localIntent, 1002);
    overridePendingTransition(2130772009, 2130772010);
  }
  
  private void u()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.18(this));
      return;
    }
    QQCustomDialog localQQCustomDialog = this.n;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.n.dismiss();
    }
  }
  
  protected Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new Dialog(paramContext, 2131953338);
    paramContext.setContentView(2131624587);
    TextView localTextView = (TextView)paramContext.findViewById(2131431880);
    if (localTextView != null) {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      } else {
        localTextView.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131431876);
    if (paramString1 != null) {
      if (paramString4 != null) {
        paramString1.setText(paramString4);
      } else {
        paramString1.setVisibility(8);
      }
    }
    paramString1 = (TextView)paramContext.findViewById(2131431864);
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
    paramString1 = (TextView)paramContext.findViewById(2131431870);
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
  
  protected void a()
  {
    this.e = ((BiuEditText)findViewById(2131435808));
    if (this.Z) {
      this.e.requestFocus();
    }
    this.e.addTextChangedListener(this.ae);
    try
    {
      this.e.setEditableFactory(this.aj);
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "input set error", localException);
    }
    this.e.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
    this.a = ((ImageView)findViewById(2131432400));
    this.a.setOnClickListener(this);
    this.g = ((ImageView)findViewById(2131428820));
    Object localObject = this.g;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
    this.h = ((ImageView)findViewById(2131447759));
    localObject = this.h;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
    this.i = ((TextView)findViewById(2131430525));
    this.k = new QQProgressDialog(this, super.getTitleBarHeight());
    this.k.setCanceledOnTouchOutside(true);
    this.j = ((XPanelContainer)findViewById(2131445137));
    localObject = this.j;
    BiuEditText localBiuEditText = this.e;
    int i1 = 0;
    ((XPanelContainer)localObject).a(localBiuEditText, false);
    this.j.setOnPanelChangeListener(this.ak);
    if (this.B)
    {
      this.D = XPanelContainer.c;
      if (this.C == null) {
        this.C = new ReadInJoyBaseDeliverActivity.2(this);
      }
      this.j.getViewTreeObserver().addOnGlobalLayoutListener(this.C);
    }
    if (ThemeUtil.isInNightMode(this.app))
    {
      localObject = new View(this);
      ((View)localObject).setBackgroundColor(1996488704);
      addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    }
    this.ag = ((TextView)findViewById(2131430129));
    localObject = this.ag;
    if (localObject != null)
    {
      ((TextView)localObject).setOnClickListener(this);
      boolean bool = RIJUgcUtils.e();
      localObject = this.ag;
      if (!bool) {
        i1 = 8;
      }
      ((TextView)localObject).setVisibility(i1);
    }
    s();
  }
  
  protected void a(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else
      {
        this.mSystemBarComp.init();
        if (!SystemUtil.g())
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
    setLeftButton(2131915321, this);
    this.leftViewNotBack.setTextColor(-16777216);
    this.leftViewNotBack.setBackgroundColor(0);
    setRightButton(2131915330, this);
    this.rightViewText.setTextColor(Color.parseColor("#07D0B0"));
    this.rightViewText.setBackgroundColor(0);
    getWindow().setBackgroundDrawableResource(2131168464);
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!this.y) {
        return;
      }
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      Object localObject1 = this.e;
      if ((localObject1 != null) && (paramIntent != null))
      {
        int i1 = ((BiuEditText)localObject1).getSelectionStart();
        localObject1 = this.e.getEditableText();
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
                this.e.setSelection(paramInt);
              }
            }
          }
        }
        if (this.an <= 0)
        {
          this.an = getResources().getDisplayMetrics().widthPixels;
          this.an = (this.an - this.e.getPaddingLeft() - this.e.getPaddingRight());
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
                paramIntent = ReadInJoyUserInfoModule.d();
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("@");
              localStringBuilder.append(paramIntent);
              localStringBuilder.append(" ");
              paramIntent = new SpannableStringBuilder(localStringBuilder.toString());
              paramIntent.setSpan(new AtFriendsSpan(localResultRecord.a(), 0L, paramIntent, getApplicationContext(), this.e.getPaint(), this.an), 0, paramIntent.length(), 33);
              ((Editable)localObject1).insert(paramInt, paramIntent);
              paramInt += paramIntent.length();
            }
          }
          this.e.setSelection(paramInt);
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
            localObject = getString(2131914810);
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              QQToast.makeText(this, paramVarArgs[0], 1).show(getTitleBarHeight());
            }
            e(false);
            paramInt = i1;
            paramVarArgs = (String[])localObject;
          }
        }
        else
        {
          paramVarArgs = getString(2131914811);
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
      paramVarArgs = HardCodeUtil.a(2131910338);
      e(false);
      paramInt = i1;
    }
    Object localObject = this.ag;
    if (localObject != null) {
      ((TextView)localObject).setText(paramVarArgs);
    }
    if (AppSetting.e)
    {
      if (paramInt == 0) {
        paramVarArgs = getString(2131894017);
      }
      localObject = this.ag;
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
    paramEditable = this.i;
    if (paramEditable != null) {
      if (!this.R)
      {
        paramEditable.setText(String.valueOf(this.u - i1));
        this.i.setVisibility(0);
      }
      else
      {
        paramEditable.setVisibility(8);
      }
    }
    if (i1 - this.u > 0)
    {
      paramEditable = this.i;
      if (paramEditable != null) {
        paramEditable.setTextColor(Color.parseColor("#FF4222"));
      }
      this.t = true;
    }
    else
    {
      paramEditable = this.i;
      if (paramEditable != null) {
        paramEditable.setTextColor(Color.parseColor("#BBBBBB"));
      }
      this.t = false;
    }
    if (this.s) {
      this.s = false;
    } else {
      this.r = true;
    }
    if ((this.A) && (Utils.a(this.e.getText())))
    {
      if ((this instanceof ReadInJoyDeliverBiuActivity))
      {
        PublicAccountReportUtils.a(null, "", "0X8009579", "0X8009579", 0, 0, "", "", "", h(), false);
        return;
      }
      PublicAccountReportUtils.a(null, "", "0X800953B", "0X800953B", 0, 0, "", "", "", h(), false);
    }
  }
  
  protected void a(TopicInfo paramTopicInfo)
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (paramTopicInfo != null))
    {
      int i2 = ((BiuEditText)localObject1).getSelectionStart();
      localObject1 = this.e.getEditableText();
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
              this.e.setSelection(i1);
            }
          }
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramTopicInfo.b());
        ((StringBuilder)localObject2).append(" ");
        localObject2 = new SpannableStringBuilder(((StringBuilder)localObject2).toString());
        ((SpannableStringBuilder)localObject2).setSpan(new TopicSpan(paramTopicInfo), 0, ((SpannableStringBuilder)localObject2).length(), 33);
        ((Editable)localObject1).insert(i1, (CharSequence)localObject2);
        i2 = ((SpannableStringBuilder)localObject2).length();
        this.e.setSelection(i1 + i2);
      }
    }
  }
  
  protected void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(String paramString)
  {
    this.j.b();
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
          if (this.U == null) {
            this.U = new ArrayList();
          } else {
            this.U.clear();
          }
        }
        catch (JSONException paramJSONObject)
        {
          if (!QLog.isColorLevel()) {
            break label234;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("get poi list error: ");
          paramBundle.append(paramJSONObject.toString());
          QLog.d("ReadInJoyBaseDeliverActivity", 2, paramBundle.toString());
        }
        if (paramInt < paramJSONObject.length())
        {
          this.U.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
          paramInt += 1;
        }
        else
        {
          if (this.U.size() > 0) {
            this.T = ((TroopBarPOI)this.U.get(0));
          }
          if (QLog.isColorLevel())
          {
            if (this.T == null) {
              break label311;
            }
            paramJSONObject = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { this.T.c, Integer.valueOf(this.T.f), Integer.valueOf(this.T.d) });
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, paramJSONObject);
      label234:
      paramJSONObject = this.T;
      if (paramJSONObject != null)
      {
        if (android.text.TextUtils.isEmpty(paramJSONObject.c)) {
          paramJSONObject = this.T.e;
        } else {
          paramJSONObject = this.T.c;
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
      label311:
      paramJSONObject = "current poi null";
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.d != paramBoolean)
    {
      this.d = paramBoolean;
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
    if (this.l == null)
    {
      this.l = ((ActionSheet)ActionSheetHelper.b(this, null));
      this.l.setMainTitle(2131915335);
      this.l.addButton(2131915334, 3);
      this.l.addCancelButton(2131887648);
      this.l.setOnDismissListener(new ReadInJoyBaseDeliverActivity.13(this));
      this.l.setOnButtonClickListener(new ReadInJoyBaseDeliverActivity.14(this, paramBoolean2, paramLong, paramBoolean1, paramInt));
    }
    if (!this.l.isShowing())
    {
      this.o = false;
      this.l.show();
    }
  }
  
  protected void b()
  {
    Object localObject = getIntent();
    this.J = ((Intent)localObject).getIntExtra("arg_ad_tag", 0);
    this.G = ((Intent)localObject).getStringExtra("arg_topic_id");
    this.H = ((Intent)localObject).getStringExtra("arg_topic_name");
    this.K = ((Intent)localObject).getStringExtra("arg_callback");
    this.I = getIntent().getStringExtra("arg_ugc_edit_cookie");
    if (this.z)
    {
      if (android.text.TextUtils.isEmpty(this.H))
      {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData: fail to add topic from intent");
      }
      else
      {
        localObject = TopicInfo.g();
        if (this.H.startsWith("#"))
        {
          ((TopicInfo.Builder)localObject).a(this.H);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("#");
          localStringBuilder.append(this.H);
          ((TopicInfo.Builder)localObject).a(localStringBuilder.toString());
        }
        a(((TopicInfo.Builder)localObject).a());
      }
    }
    else
    {
      localObject = this.h;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
    }
    if (!this.R)
    {
      int i1 = ReadInJoyHelper.E(this.app);
      if (i1 > 0) {
        this.u = i1;
      }
      this.i.setText(String.valueOf(this.u));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initData count=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", mMaxWordCount=");
        ((StringBuilder)localObject).append(this.u);
        QLog.d("ReadInJoyBaseDeliverActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.u = RIJUgcUtils.g();
      this.i.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData unlimited mode");
      }
    }
    if (this.L)
    {
      this.N = new ReadInJoyBaseDeliverActivity.NetInfoHandler(this, null);
      AppNetConnInfo.registerConnectionChangeReceiver(this, this.N);
    }
    localObject = this.ag;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
  }
  
  protected void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 1;
    if ((paramInt3 == 1) && (paramInt2 == 0) && (isResume()))
    {
      paramCharSequence = paramCharSequence.toString().substring(paramInt1, paramInt1 + 1);
      if ((this.y) && (paramCharSequence.equals("@")))
      {
        a("2");
        if ((this instanceof ReadInJoyDeliverUGCActivity)) {
          RIJDeliverUGCReportUtil.b("2");
        }
      }
      if ((this.z) && (paramCharSequence.equals("#")) && (r().intValue() < 10) && (!this.ab)) {
        paramInt1 = i1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        e(2);
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
  
  protected boolean c()
  {
    if (this.t)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver overlong!");
      }
      a(1, getString(2131915329));
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver network error!");
      }
      a(1, getString(2131915328));
      return false;
    }
    return true;
  }
  
  protected void d()
  {
    if (this.p == 2)
    {
      d(1);
      return;
    }
    d(2);
  }
  
  protected void d(int paramInt)
  {
    this.p = paramInt;
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130844023);
      }
      localObject = this.f;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130844025);
      }
      localObject = this.j;
      if ((localObject != null) && (((XPanelContainer)localObject).getCurrentPanel() != 1)) {
        this.j.a(1);
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130851377);
      }
      localObject = this.j;
      if ((localObject != null) && (((XPanelContainer)localObject).getCurrentPanel() != 3)) {
        this.j.a(3);
      }
      localObject = this.f;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130844025);
      }
    }
    else if (paramInt == 0)
    {
      localObject = this.f;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130844025);
      }
      localObject = this.j;
      if ((localObject != null) && (((XPanelContainer)localObject).getCurrentPanel() != 0)) {
        this.j.b();
      }
      localObject = this.a;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130844023);
      }
    }
    else if (paramInt == 3)
    {
      localObject = this.j;
      if ((localObject != null) && (((XPanelContainer)localObject).getCurrentPanel() != 24)) {
        this.j.a(24);
      }
      localObject = this.a;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130844023);
      }
      localObject = this.f;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130851377);
      }
    }
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
      this.T = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult: ");
        localStringBuilder.append(paramInt2);
        paramIntent = this.T;
        if (paramIntent != null) {
          paramIntent = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { paramIntent.c, Integer.valueOf(this.T.f), Integer.valueOf(this.T.d) });
        } else {
          paramIntent = "current poi null";
        }
        localStringBuilder.append(paramIntent);
        QLog.d("ReadInJoyBaseDeliverActivity", 2, localStringBuilder.toString());
      }
      paramIntent = this.T;
      if (paramIntent != null)
      {
        if (android.text.TextUtils.isEmpty(paramIntent.c)) {
          paramIntent = this.T.e;
        } else {
          paramIntent = this.T.c;
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
    Object localObject = this.b;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = this.e;
    if (localObject != null) {
      ((BiuEditText)localObject).removeTextChangedListener(this.ae);
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((XPanelContainer)localObject).e();
      this.j.setOnPanelChangeListener(null);
      this.j.getViewTreeObserver().removeGlobalOnLayoutListener(this.C);
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.k = null;
    }
    localObject = this.N;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
      this.N = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((PublicAccountHotPicPanel)localObject).setPublicAccountGifListener(null);
      this.am = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.q = this.p;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.Z) {
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
  
  @VisibleForTesting
  void e()
  {
    PublicAccountReportUtils.a(null, "", "0X80096D8", "0X80096D8", 0, 0, "", "", "", "", false);
    this.ai = QQPermissionFactory.a(this);
    QQPermission localQQPermission = this.ai;
    if (localQQPermission != null)
    {
      QQPermission.BasePermissionsListener localBasePermissionsListener = this.ah;
      localQQPermission.a(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 2, localBasePermissionsListener);
      return;
    }
    QLog.e("ReadInJoyBaseDeliverActivity", 1, "The Permission has not be approved");
  }
  
  protected void e(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.ac);
    QPublicFragmentActivity.startForResult(this, localIntent, ReadInJoyTopicSelectionFragment.class, 3001);
  }
  
  protected void f()
  {
    onBackEvent();
  }
  
  protected void f(int paramInt)
  {
    QQProgressDialog localQQProgressDialog = this.k;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.c(paramInt);
      if (!this.k.isShowing()) {
        this.k.show();
      }
    }
  }
  
  public void finish()
  {
    XPanelContainer localXPanelContainer = this.j;
    if (localXPanelContainer != null) {
      localXPanelContainer.b();
    }
    if (this.w) {
      setResult(this.x, getIntent());
    }
    super.finish();
    overridePendingTransition(2130771994, 2130771995);
  }
  
  protected void g() {}
  
  public String i()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("topicid", q());
      ((JSONObject)localObject).put("topic_num", r());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  protected void j()
  {
    if (this.y) {
      a("1");
    }
  }
  
  protected String k()
  {
    Object localObject3 = this.e.getEditableText();
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
          if (!this.S) {
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
  
  protected void l()
  {
    if (this.m == null)
    {
      this.m = ((ActionSheet)ActionSheetHelper.b(this, null));
      this.m.setMainTitle(HardCodeUtil.a(2131910315));
      this.m.addButton(HardCodeUtil.a(2131910454), 9, "#ff000000");
      this.m.addButton(HardCodeUtil.a(2131910352), 3);
      this.m.addCancelButton(HardCodeUtil.a(2131898212));
      this.m.setOnDismissListener(new ReadInJoyBaseDeliverActivity.11(this));
      this.m.setOnButtonClickListener(new ReadInJoyBaseDeliverActivity.12(this));
    }
    if (!this.m.isShowing())
    {
      this.o = false;
      this.m.show();
    }
  }
  
  protected void m() {}
  
  protected void n() {}
  
  protected void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.15(this));
      return;
    }
    if (this.n == null)
    {
      this.n = DialogUtil.a(this, 230);
      this.n.setMessage(getString(2131915341)).setNegativeButton(getString(2131915338), new ReadInJoyBaseDeliverActivity.17(this)).setPositiveButton(getString(2131915339), new ReadInJoyBaseDeliverActivity.16(this));
      this.n.setCanceledOnTouchOutside(false);
    }
    this.n.show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131447759: 
      if (r().intValue() >= 10)
      {
        QQToast.makeText(this, 2131915543, 0).show();
        return;
      }
      e(1);
      return;
    case 2131436211: 
      c();
      return;
    case 2131436182: 
      f();
      return;
    case 2131432400: 
      d();
      return;
    case 2131430129: 
      e();
      return;
    }
    j();
  }
  
  protected void p()
  {
    QQProgressDialog localQQProgressDialog = this.k;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.k.dismiss();
    }
  }
  
  protected String q()
  {
    Object localObject = this.e.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject[0].b().a());
      int i2 = localObject.length;
      int i1 = 1;
      while (i1 < i2)
      {
        localStringBuilder.append("|");
        localStringBuilder.append(localObject[i1].b().a());
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  protected Integer r()
  {
    Object localObject = this.e.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if (localObject != null) {
      return Integer.valueOf(localObject.length);
    }
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity
 * JD-Core Version:    0.7.0.1
 */