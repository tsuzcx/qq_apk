import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;

public class nin
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  protected alox a;
  protected amnh a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  protected Handler.Callback a;
  View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQAppInterface a;
  AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  String jdField_a_of_type_JavaLangString;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  protected ArrayList<String> a;
  protected MqqHandler a;
  protected njs a;
  npo jdField_a_of_type_Npo = null;
  nps jdField_a_of_type_Nps = new nip(this);
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = true;
  boolean c = true;
  protected boolean d;
  protected boolean e;
  boolean f = false;
  
  public nin(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Alox = new njd(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new njj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((BaseActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
    this.jdField_a_of_type_Njs = new njs(this, this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Njs);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin)) && (!TextUtils.isEmpty(paramQQAppInterface.c()))) {
      a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin), Long.parseLong(paramQQAppInterface.c()));
    }
    a();
    this.jdField_a_of_type_MqqOsMqqHandler = new bdbw(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
  }
  
  private View a(npo paramnpo)
  {
    if ((TextUtils.isEmpty(paramnpo.g)) || (TextUtils.isEmpty(paramnpo.f))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    TextView localTextView = (TextView)localView.findViewById(2131377884);
    String str1 = paramnpo.jdField_a_of_type_JavaLangString;
    String str2 = paramnpo.jdField_b_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1))
    {
      localTextView.setText(str1);
      localView.setOnClickListener(new nio(this, paramnpo, str2));
      return localView;
    }
    return null;
  }
  
  private View a(npo paramnpo, int paramInt)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new njq(this, paramInt, paramnpo));
    return localView;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    return localLinearLayout;
  }
  
  private String a()
  {
    int i = syb.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_JavaLangString;
  }
  
  private yqd a()
  {
    yqd localyqd = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localyqd = new yqd(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localyqd;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ConfigSvc.getRecvMsgState");
    Object localObject = new GetRecvMsgStateReq();
    ((GetRecvMsgStateReq)localObject).puin = paramLong1;
    ((GetRecvMsgStateReq)localObject).uin = paramLong2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("GetRecvMsgStateReq", localObject);
    localToServiceMsg.setAttributes(localHashMap);
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), nrz.class);
    ((NewIntent)localObject).putExtra("cmd", "ConfigSvc.getRecvMsgState");
    ((NewIntent)localObject).putExtra("uin", paramLong1);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getName(), localToServiceMsg);
    nrz.a((Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = (ImageView)paramView.findViewById(2131368507);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  private void a(ViewGroup paramViewGroup, List<npo> paramList)
  {
    PhotoWallViewForAccountDetail localPhotoWallViewForAccountDetail = new PhotoWallViewForAccountDetail((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localPhotoWallViewForAccountDetail.setPhotoWallCallback(this.jdField_a_of_type_Nps);
    localPhotoWallViewForAccountDetail.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramList);
    localPhotoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.addView(localPhotoWallViewForAccountDetail);
  }
  
  private void a(String paramString)
  {
    Dialog localDialog = new Dialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131755801);
    localDialog.setContentView(2131560888);
    ((TextView)localDialog.findViewById(2131365269)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365258);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365256);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365262);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690648);
    localTextView3.setText(2131691699);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new njf(this, localDialog));
    localTextView3.setOnClickListener(new njg(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(npo paramnpo)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      int i = paramnpo.jdField_d_of_type_Int;
      if ((i == 1) || (i == 2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693898);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693899);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "parseTribeTroopJsonObject jsonObject is null");
      }
    }
    do
    {
      do
      {
        return;
        i = -1;
        if (paramJSONObject.has("retcode")) {
          i = paramJSONObject.optInt("retcode");
        }
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_reward", 2, "parseTribeTroopJsonObject errorCode is " + i);
        }
      } while (i != 0);
      localObject = paramJSONObject.optJSONObject("result").optJSONObject("group_bar");
    } while (localObject == null);
    paramJSONObject = new ArrayList();
    Object localObject = ((JSONObject)localObject).optJSONArray("group_list");
    int j = ((JSONArray)localObject).length();
    int i = j;
    if (j > 3) {
      i = 3;
    }
    j = 0;
    while (j < i)
    {
      paramJSONObject.add(((JSONArray)localObject).optJSONObject(j).optString("code"));
      j += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramJSONObject);
    localObject = (bcic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("mIsAbleBindTroop", this.d);
    localBundle.putStringArrayList("mBindedTroopUins", paramJSONObject);
    ((bcic)localObject).a(this.jdField_a_of_type_JavaLangString, localBundle);
    d();
  }
  
  private void a(boolean paramBoolean, LinearLayout paramLinearLayout, JSONArray paramJSONArray)
  {
    int k = paramJSONArray.length();
    if (k <= 0) {
      return;
    }
    int i = 0;
    while ((i < 3) && (i + 1 <= k))
    {
      int j = (int)(6.0F * this.jdField_a_of_type_Float);
      int m = (int)(32.0F * this.jdField_a_of_type_Float);
      ImageView localImageView = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
      if (i == 2)
      {
        j = 0;
        label101:
        localLayoutParams.setMargins(0, 0, j, 0);
        localImageView.setLayoutParams(localLayoutParams);
      }
      try
      {
        if (TextUtils.isEmpty(paramJSONArray.getString(i))) {
          localImageView.setImageResource(2130839371);
        }
        for (;;)
        {
          paramLinearLayout.addView(localImageView);
          i += 1;
          break;
          break label101;
          localImageView.setImageDrawable(URLDrawable.getDrawable(paramJSONArray.getString(i)));
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private boolean a(npn paramnpn, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup start");
    }
    Object localObject = paramnpn.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      return false;
      localViewGroup = a();
      if (paramnpn.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = paramnpn.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        npo localnpo = (npo)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localnpo.jdField_e_of_type_JavaLangString)) {
          ((Iterator)localObject).remove();
        } else if ((localnpo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
          ((Iterator)localObject).remove();
        }
      }
    } while (paramnpn.jdField_a_of_type_JavaUtilList.size() < 3);
    a(localViewGroup, paramnpn.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    return false;
    int i = ((List)localObject).size();
    if (i <= 0) {
      return true;
    }
    if ((paramInt1 > 0) && (i > 0) && (paramBoolean))
    {
      paramnpn = new View((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      paramnpn.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.jdField_a_of_type_Float)));
      paramnpn.setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView(paramnpn);
    }
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      if (i > 1) {
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        a(localViewGroup, (npo)((List)localObject).get(paramInt2), paramInt1);
        paramInt2 += 1;
        break;
        if (paramInt2 == i - 1)
        {
          paramInt1 = 2;
        }
        else
        {
          paramInt1 = 3;
          continue;
          paramInt1 = 0;
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup exit");
    }
    return true;
  }
  
  private boolean a(npo paramnpo)
  {
    if ((paramnpo.jdField_a_of_type_Int == 3) && ((paramnpo.jdField_c_of_type_Int == 3) || (paramnpo.jdField_c_of_type_Int == 16) || (paramnpo.jdField_c_of_type_Int == 21) || (paramnpo.jdField_c_of_type_Int == 13))) {}
    while ((paramnpo.jdField_e_of_type_Int == 5) || ((paramnpo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1))) {
      return true;
    }
    return false;
  }
  
  private View b()
  {
    return ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559004, null);
  }
  
  private View b(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    String str = paramnpo.h;
    if (str != null)
    {
      str = str.trim();
      if (!Pattern.compile("[\\d-]+?").matcher(str).matches()) {
        return null;
      }
    }
    else
    {
      return null;
    }
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    localView.setOnClickListener(new njb(this, str, paramnpo));
    return localView;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      Toast.makeText(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext(), paramInt, 0).show();
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    View localView = new View((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(0.7D * this.jdField_a_of_type_Float)));
    localView.setBackgroundColor(Color.parseColor("#dedfe0"));
    paramViewGroup.addView(localView);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), PublicAccountBrowser.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
    paramString = paramString.replace("${puin}", this.jdField_a_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("big_brother_source_key", syb.b(this.jdField_a_of_type_JavaLangString));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
  }
  
  private View c(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559004, null);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      if (paramInt != 0) {
        break label38;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693898);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label38:
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693900);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693901);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693897);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693902);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  private View d(npo paramnpo)
  {
    boolean bool = false;
    if ((paramnpo.jdField_a_of_type_JavaLangString.contains(alpo.a(2131700113))) && (this.jdField_a_of_type_Boolean)) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559445, null);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    String str = paramnpo.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      localView.findViewById(2131368998).setVisibility(0);
      localView.setOnClickListener(new njl(this, str, paramnpo));
      bool = true;
    }
    try
    {
      for (;;)
      {
        paramnpo = new JSONArray(paramnpo.jdField_e_of_type_JavaLangString);
        a(bool, (LinearLayout)localView.findViewById(2131368163), paramnpo);
        return localView;
        localView.findViewById(2131368998).setVisibility(8);
      }
    }
    catch (JSONException paramnpo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetailGroupListContainer", 2, "RICH_PIC_TEXT:pic json error!");
        }
        paramnpo.printStackTrace();
      }
    }
  }
  
  private View e(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new njm(this, paramnpo));
    return localView;
  }
  
  private View f(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new njn(this, paramnpo));
    return localView;
  }
  
  private View g(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new njo(this, paramnpo));
    return localView;
  }
  
  private View h(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new njp(this, paramnpo));
    return localView;
  }
  
  private View i(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    String str = paramnpo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new njr(this, str, paramnpo));
    return localView;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise))) {
      return;
    }
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559469, null);
    String str = "";
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin)) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin + "\n";
    }
    str = str + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise;
    ((TextView)localView.findViewById(2131364085)).setText(str);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View j(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562788, null);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary))) {
      return;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559469, null);
    ((TextView)localView.findViewById(2131364085)).setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    ((ImageView)localView.findViewById(2131368507)).setVisibility(8);
    ((TextView)localView.findViewById(2131377884)).setText(2131695772);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View k(npo paramnpo)
  {
    this.jdField_a_of_type_Npo = paramnpo;
    if (paramnpo.jdField_e_of_type_Int != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailGroupListContainer", 2, "Unhandled ConfigInfo(" + paramnpo.jdField_a_of_type_Int + ", " + paramnpo.jdField_c_of_type_Int + ", " + paramnpo.jdField_e_of_type_Int + ")");
      }
      return null;
    }
    paramnpo = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562646, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramnpo.findViewById(2131376954));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramnpo.findViewById(2131376965));
    ((TextView)paramnpo.findViewById(2131377884)).setText(this.jdField_a_of_type_Npo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
    int i;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("setting_result_" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -10000);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("setting_status_" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
    }
    for (;;)
    {
      if ((i == 0) && (this.jdField_a_of_type_Int > -1))
      {
        this.jdField_b_of_type_Boolean = false;
        c(this.jdField_a_of_type_Int);
        paramnpo.setOnClickListener(new niq(this));
      }
      for (;;)
      {
        return paramnpo;
        a(this.jdField_a_of_type_Npo);
        paramnpo.setOnClickListener(new nir(this));
      }
      i = -10000;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new yqb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), a(), 1, a()).a();
  }
  
  private View l(npo paramnpo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562682, null);
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    Switch localSwitch = (Switch)localView.findViewById(2131376947);
    if (paramnpo.jdField_d_of_type_Int == 1) {
      localSwitch.setChecked(true);
    }
    for (;;)
    {
      localSwitch.setOnCheckedChangeListener(new niy(this, paramnpo, localSwitch));
      return localView;
      localSwitch.setChecked(false);
    }
  }
  
  private View m(npo paramnpo)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramnpo.jdField_a_of_type_JavaLangString.contains(alpo.a(2131700115)))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559206, null);
    a(localView, paramnpo.i);
    String str = paramnpo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131377884)).setText(paramnpo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364770)).setText(paramnpo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new niz(this, str, paramnpo));
    return localView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  void a()
  {
    if (!a()) {
      return;
    }
    Object localObject = ((bcic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.d = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
      localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      }
    }
    g();
    h();
  }
  
  void a(int paramInt)
  {
    bhpy localbhpy = (bhpy)bhql.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localbhpy.a(2131693898, 5, false);
    localbhpy.a(2131693897, 5, false);
    localbhpy.a(2131693900, 5, false);
    if (paramInt == 0) {
      localbhpy.d(0);
    }
    for (;;)
    {
      localbhpy.c(2131690648);
      localbhpy.setOnDismissListener(new niv(this));
      localbhpy.a(new niw(this, localbhpy));
      if (!localbhpy.isShowing())
      {
        this.f = false;
        localbhpy.show();
      }
      return;
      if (paramInt == 1) {
        localbhpy.d(2);
      } else if (paramInt == 2) {
        localbhpy.d(1);
      }
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if (!a()) {}
    int j;
    do
    {
      return;
      f();
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "addBindedTroopItem:" + j + "," + this.d);
      }
    } while ((j == 0) && (!this.d));
    View localView = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2131559826, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131368163);
    Object localObject = localView.findViewById(2131364770);
    this.jdField_a_of_type_AndroidViewViewGroup = localLinearLayout;
    if (j == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_num", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      ((View)localObject).setVisibility(0);
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        localObject = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        int k = (int)(32.0F * this.jdField_a_of_type_Float);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.leftMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)));
        ((ImageView)localObject).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        localLinearLayout.addView((View)localObject);
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      localLinearLayout.setVisibility(0);
      ((View)localObject).setVisibility(8);
    }
    localView.setOnClickListener(new nja(this, j));
    paramViewGroup.addView(localView);
    b(paramViewGroup);
  }
  
  void a(ViewGroup paramViewGroup, npo paramnpo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountDetailItem");
    }
    if (a(paramnpo)) {
      return;
    }
    label58:
    int i;
    if (paramnpo.jdField_a_of_type_Int == 3) {
      if (paramnpo.jdField_c_of_type_Int == 10)
      {
        this.jdField_a_of_type_AndroidViewView = k(paramnpo);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        if (this.jdField_a_of_type_AndroidViewView == null) {
          break label490;
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837519);
        paramInt = (int)(16.0F * this.jdField_a_of_type_Float);
        i = (int)(12.0F * this.jdField_a_of_type_Float);
        if (paramnpo.jdField_a_of_type_Int != 4) {
          break label492;
        }
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
      }
    }
    for (;;)
    {
      paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
      b(paramViewGroup);
      return;
      if (paramnpo.jdField_c_of_type_Int == 7)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 8)
      {
        this.jdField_a_of_type_AndroidViewView = b(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 11)
      {
        this.jdField_a_of_type_AndroidViewView = e(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 20)
      {
        this.jdField_a_of_type_AndroidViewView = f(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = g(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 17)
      {
        this.jdField_a_of_type_AndroidViewView = h(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramnpo, 9);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 18)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramnpo, 10);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 22)
      {
        this.jdField_a_of_type_AndroidViewView = i(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_c_of_type_Int == 24)
      {
        this.jdField_a_of_type_AndroidViewView = j(paramnpo);
        break label58;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramnpo.jdField_c_of_type_Int);
      return;
      if (paramnpo.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView = m(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = l(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_AndroidViewView = c(paramnpo);
        break label58;
      }
      if (paramnpo.jdField_a_of_type_Int == 5)
      {
        this.jdField_a_of_type_AndroidViewView = d(paramnpo);
        break label58;
      }
      this.jdField_a_of_type_AndroidViewView = b();
      break label58;
      label490:
      break;
      label492:
      if ((paramnpo.jdField_a_of_type_Int == 2) || ((paramnpo.jdField_a_of_type_Int == 5) && (!paramnpo.jdField_e_of_type_JavaLangString.equals("[]")))) {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, 0, paramInt, 0);
      } else {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
      }
    }
  }
  
  void a(npo paramnpo, int paramInt)
  {
    bhpy localbhpy = (bhpy)bhql.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localbhpy.a(2131693898, 5, false);
    localbhpy.a(2131693899, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localbhpy.d(0);
    }
    for (;;)
    {
      if ((paramInt != 1) && (paramInt == 2)) {}
      localbhpy.c(2131690648);
      localbhpy.setOnDismissListener(new nis(this));
      localbhpy.a(new nit(this, paramnpo, localbhpy));
      if (!localbhpy.isShowing())
      {
        this.f = false;
        localbhpy.show();
      }
      return;
      localbhpy.d(1);
    }
  }
  
  void a(npo paramnpo, Switch paramSwitch)
  {
    boolean bool = true;
    if (paramnpo.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      this.c = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  void a(npo paramnpo, Switch paramSwitch, boolean paramBoolean)
  {
    bdfq localbdfq = bdcd.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0);
    localbdfq.setCanceledOnTouchOutside(false);
    String str2 = alpo.a(2131700111);
    String str1 = paramnpo.jdField_d_of_type_JavaLangString;
    if (3 == paramnpo.jdField_e_of_type_Int) {
      str1 = String.format(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131692258), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name });
    }
    localbdfq.setTitle(str2);
    localbdfq.setMessage(str1);
    localbdfq.setOnCancelListener(new njh(this, paramnpo, paramSwitch));
    paramnpo = new nji(this, paramnpo, paramBoolean, paramSwitch);
    localbdfq.setNegativeButton(alpo.a(2131700110), paramnpo);
    localbdfq.setPositiveButton(alpo.a(2131700116), paramnpo);
    try
    {
      localbdfq.show();
      return;
    }
    catch (Exception paramnpo) {}
  }
  
  void a(npo paramnpo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      nhx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramnpo, i);
      return;
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      bool1 = bool2;
      if (syb.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) != -2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "needShowBindTroopItem:" + bool1);
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Njs != null)
    {
      this.jdField_a_of_type_Njs.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Njs);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amnh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getBaseContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
    this.jdField_a_of_type_Float = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDisplayMetrics().density;
    d();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    List localList;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.paConfigAttrs;
      if (localList == null) {
        localList = npn.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList);
      }
    }
    for (;;)
    {
      int i;
      if (localList != null)
      {
        int j = localList.size();
        i = 0;
        boolean bool = false;
        if (i < j)
        {
          if ((((npn)localList.get(i)).jdField_a_of_type_Int != 0) && (((npn)localList.get(i)).jdField_a_of_type_Int != 1)) {
            break label128;
          }
          bool = a((npn)localList.get(i), i, j, bool);
        }
      }
      label128:
      for (;;)
      {
        i += 1;
        break;
        e();
        return;
      }
      continue;
      localList = null;
    }
  }
  
  void e()
  {
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    j();
    i();
  }
  
  void f()
  {
    if (a())
    {
      Object localObject = ((bcic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.d = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
        localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "loadCache, hit cache");
        }
      }
    }
  }
  
  public void g()
  {
    if (!a()) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "getBindedTroops:" + l);
        }
        if (l == -1L) {
          continue;
        }
        oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
        localReqBody.uint32_channel.set(1);
        localReqBody.uint64_subscribe_code.set(l);
        mzy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new njc(this), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, 0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = -1L;
        }
      }
    }
  }
  
  public void h()
  {
    if ((!a()) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    Object localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject1 != null) {}
    for (localObject1 = ((TicketManager)localObject1).getSkey(str);; localObject1 = null)
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
      Object localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (((String)localObject3).endsWith(alpo.a(2131700117))) {
          localObject2 = ((String)localObject3).substring(0, ((String)localObject3).length() - 3);
        }
      }
      localObject3 = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("bid", "0");
      localBundle.putString("keyword", (String)localObject2);
      localBundle.putString("ver", "1");
      localBundle.putString("from", "1");
      localBundle.putString("link", "0");
      localBundle.putString("puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject1);
      localBundle.putString("Referer", "https://buluo.qq.com/");
      ((HashMap)localObject3).put("BUNDLE", localBundle);
      ((HashMap)localObject3).put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bcgp("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new nje(this), 1000, null).a((HashMap)localObject3);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nin
 * JD-Core Version:    0.7.0.1
 */