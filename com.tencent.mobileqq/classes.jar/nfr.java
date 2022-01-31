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

public class nfr
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  protected ajxj a;
  protected akwr a;
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
  protected ngw a;
  nms jdField_a_of_type_Nms = null;
  nmw jdField_a_of_type_Nmw = new nft(this);
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = true;
  boolean c = true;
  protected boolean d;
  protected boolean e;
  boolean f = false;
  
  public nfr(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Ajxj = new ngh(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new ngn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((BaseActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
    this.jdField_a_of_type_Ngw = new ngw(this, this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ngw);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin)) && (!TextUtils.isEmpty(paramQQAppInterface.c()))) {
      a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin), Long.parseLong(paramQQAppInterface.c()));
    }
    a();
    this.jdField_a_of_type_MqqOsMqqHandler = new bbdc(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
  }
  
  private View a(nms paramnms)
  {
    if ((TextUtils.isEmpty(paramnms.g)) || (TextUtils.isEmpty(paramnms.f))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    TextView localTextView = (TextView)localView.findViewById(2131377350);
    String str1 = paramnms.jdField_a_of_type_JavaLangString;
    String str2 = paramnms.jdField_b_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1))
    {
      localTextView.setText(str1);
      localView.setOnClickListener(new nfs(this, paramnms, str2));
      return localView;
    }
    return null;
  }
  
  private View a(nms paramnms, int paramInt)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ngu(this, paramInt, paramnms));
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
    int i = sgg.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_JavaLangString;
  }
  
  private xbk a()
  {
    xbk localxbk = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localxbk = new xbk(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localxbk;
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
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), nor.class);
    ((NewIntent)localObject).putExtra("cmd", "ConfigSvc.getRecvMsgState");
    ((NewIntent)localObject).putExtra("uin", paramLong1);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getName(), localToServiceMsg);
    nor.a((Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = (ImageView)paramView.findViewById(2131368335);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  private void a(ViewGroup paramViewGroup, List<nms> paramList)
  {
    PhotoWallViewForAccountDetail localPhotoWallViewForAccountDetail = new PhotoWallViewForAccountDetail((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localPhotoWallViewForAccountDetail.setPhotoWallCallback(this.jdField_a_of_type_Nmw);
    localPhotoWallViewForAccountDetail.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramList);
    localPhotoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.addView(localPhotoWallViewForAccountDetail);
  }
  
  private void a(String paramString)
  {
    Dialog localDialog = new Dialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131755791);
    localDialog.setContentView(2131560712);
    ((TextView)localDialog.findViewById(2131365184)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365173);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365171);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365177);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690596);
    localTextView3.setText(2131691644);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ngj(this, localDialog));
    localTextView3.setOnClickListener(new ngk(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(nms paramnms)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      int i = paramnms.jdField_d_of_type_Int;
      if ((i == 1) || (i == 2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693782);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693783);
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
    localObject = (bajo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("mIsAbleBindTroop", this.d);
    localBundle.putStringArrayList("mBindedTroopUins", paramJSONObject);
    ((bajo)localObject).a(this.jdField_a_of_type_JavaLangString, localBundle);
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
          localImageView.setImageResource(2130839282);
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
  
  private boolean a(nmr paramnmr, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup start");
    }
    Object localObject = paramnmr.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      return false;
      localViewGroup = a();
      if (paramnmr.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = paramnmr.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        nms localnms = (nms)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localnms.jdField_e_of_type_JavaLangString)) {
          ((Iterator)localObject).remove();
        } else if ((localnms.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
          ((Iterator)localObject).remove();
        }
      }
    } while (paramnmr.jdField_a_of_type_JavaUtilList.size() < 3);
    a(localViewGroup, paramnmr.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    return false;
    int i = ((List)localObject).size();
    if (i <= 0) {
      return true;
    }
    if ((paramInt1 > 0) && (i > 0) && (paramBoolean))
    {
      paramnmr = new View((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      paramnmr.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.jdField_a_of_type_Float)));
      paramnmr.setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView(paramnmr);
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
        a(localViewGroup, (nms)((List)localObject).get(paramInt2), paramInt1);
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
  
  private boolean a(nms paramnms)
  {
    if ((paramnms.jdField_a_of_type_Int == 3) && ((paramnms.jdField_c_of_type_Int == 3) || (paramnms.jdField_c_of_type_Int == 16) || (paramnms.jdField_c_of_type_Int == 21) || (paramnms.jdField_c_of_type_Int == 13))) {}
    while ((paramnms.jdField_e_of_type_Int == 5) || ((paramnms.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1))) {
      return true;
    }
    return false;
  }
  
  private View b()
  {
    return ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131558967, null);
  }
  
  private View b(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    String str = paramnms.h;
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
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    localView.setOnClickListener(new ngf(this, str, paramnms));
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
    localIntent.putExtra("big_brother_source_key", sgg.b(this.jdField_a_of_type_JavaLangString));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
  }
  
  private View c(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131558967, null);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      if (paramInt != 0) {
        break label38;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693782);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label38:
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693784);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693785);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693781);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693786);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  private View d(nms paramnms)
  {
    boolean bool = false;
    if ((paramnms.jdField_a_of_type_JavaLangString.contains(ajya.a(2131699744))) && (this.jdField_a_of_type_Boolean)) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559393, null);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    String str = paramnms.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      localView.findViewById(2131368779).setVisibility(0);
      localView.setOnClickListener(new ngp(this, str, paramnms));
      bool = true;
    }
    try
    {
      for (;;)
      {
        paramnms = new JSONArray(paramnms.jdField_e_of_type_JavaLangString);
        a(bool, (LinearLayout)localView.findViewById(2131368025), paramnms);
        return localView;
        localView.findViewById(2131368779).setVisibility(8);
      }
    }
    catch (JSONException paramnms)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetailGroupListContainer", 2, "RICH_PIC_TEXT:pic json error!");
        }
        paramnms.printStackTrace();
      }
    }
  }
  
  private View e(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ngq(this, paramnms));
    return localView;
  }
  
  private View f(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ngr(this, paramnms));
    return localView;
  }
  
  private View g(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ngs(this, paramnms));
    return localView;
  }
  
  private View h(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ngt(this, paramnms));
    return localView;
  }
  
  private View i(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    String str = paramnms.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ngv(this, str, paramnms));
    return localView;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise))) {
      return;
    }
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559417, null);
    String str = "";
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin)) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin + "\n";
    }
    str = str + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise;
    ((TextView)localView.findViewById(2131364024)).setText(str);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View j(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562586, null);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary))) {
      return;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559417, null);
    ((TextView)localView.findViewById(2131364024)).setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    ((ImageView)localView.findViewById(2131368335)).setVisibility(8);
    ((TextView)localView.findViewById(2131377350)).setText(2131695614);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View k(nms paramnms)
  {
    this.jdField_a_of_type_Nms = paramnms;
    if (paramnms.jdField_e_of_type_Int != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailGroupListContainer", 2, "Unhandled ConfigInfo(" + paramnms.jdField_a_of_type_Int + ", " + paramnms.jdField_c_of_type_Int + ", " + paramnms.jdField_e_of_type_Int + ")");
      }
      return null;
    }
    paramnms = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562442, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramnms.findViewById(2131376454));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramnms.findViewById(2131376465));
    ((TextView)paramnms.findViewById(2131377350)).setText(this.jdField_a_of_type_Nms.jdField_a_of_type_JavaLangString);
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
        paramnms.setOnClickListener(new nfu(this));
      }
      for (;;)
      {
        return paramnms;
        a(this.jdField_a_of_type_Nms);
        paramnms.setOnClickListener(new nfv(this));
      }
      i = -10000;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new xbi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), a(), 1, a()).a();
  }
  
  private View l(nms paramnms)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562478, null);
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    Switch localSwitch = (Switch)localView.findViewById(2131376447);
    if (paramnms.jdField_d_of_type_Int == 1) {
      localSwitch.setChecked(true);
    }
    for (;;)
    {
      localSwitch.setOnCheckedChangeListener(new ngc(this, paramnms, localSwitch));
      return localView;
      localSwitch.setChecked(false);
    }
  }
  
  private View m(nms paramnms)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramnms.jdField_a_of_type_JavaLangString.contains(ajya.a(2131699746)))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559163, null);
    a(localView, paramnms.i);
    String str = paramnms.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131377350)).setText(paramnms.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131364691)).setText(paramnms.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ngd(this, str, paramnms));
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
    Object localObject = ((bajo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_JavaLangString);
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
    bfpc localbfpc = (bfpc)bfpp.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localbfpc.a(2131693782, 5, false);
    localbfpc.a(2131693781, 5, false);
    localbfpc.a(2131693784, 5, false);
    if (paramInt == 0) {
      localbfpc.d(0);
    }
    for (;;)
    {
      localbfpc.c(2131690596);
      localbfpc.setOnDismissListener(new nfz(this));
      localbfpc.a(new nga(this, localbfpc));
      if (!localbfpc.isShowing())
      {
        this.f = false;
        localbfpc.show();
      }
      return;
      if (paramInt == 1) {
        localbfpc.d(2);
      } else if (paramInt == 2) {
        localbfpc.d(1);
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
    View localView = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2131559765, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131368025);
    Object localObject = localView.findViewById(2131364691);
    this.jdField_a_of_type_AndroidViewViewGroup = localLinearLayout;
    if (j == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_num", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      localLinearLayout.setVisibility(0);
      ((View)localObject).setVisibility(8);
    }
    localView.setOnClickListener(new nge(this, j));
    paramViewGroup.addView(localView);
    b(paramViewGroup);
  }
  
  void a(ViewGroup paramViewGroup, nms paramnms, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountDetailItem");
    }
    if (a(paramnms)) {
      return;
    }
    label58:
    int i;
    if (paramnms.jdField_a_of_type_Int == 3) {
      if (paramnms.jdField_c_of_type_Int == 10)
      {
        this.jdField_a_of_type_AndroidViewView = k(paramnms);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        if (this.jdField_a_of_type_AndroidViewView == null) {
          break label490;
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837519);
        paramInt = (int)(16.0F * this.jdField_a_of_type_Float);
        i = (int)(12.0F * this.jdField_a_of_type_Float);
        if (paramnms.jdField_a_of_type_Int != 4) {
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
      if (paramnms.jdField_c_of_type_Int == 7)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramnms);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 8)
      {
        this.jdField_a_of_type_AndroidViewView = b(paramnms);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 11)
      {
        this.jdField_a_of_type_AndroidViewView = e(paramnms);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 20)
      {
        this.jdField_a_of_type_AndroidViewView = f(paramnms);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = g(paramnms);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 17)
      {
        this.jdField_a_of_type_AndroidViewView = h(paramnms);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramnms, 9);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 18)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramnms, 10);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 22)
      {
        this.jdField_a_of_type_AndroidViewView = i(paramnms);
        break label58;
      }
      if (paramnms.jdField_c_of_type_Int == 24)
      {
        this.jdField_a_of_type_AndroidViewView = j(paramnms);
        break label58;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramnms.jdField_c_of_type_Int);
      return;
      if (paramnms.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView = m(paramnms);
        break label58;
      }
      if (paramnms.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = l(paramnms);
        break label58;
      }
      if (paramnms.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_AndroidViewView = c(paramnms);
        break label58;
      }
      if (paramnms.jdField_a_of_type_Int == 5)
      {
        this.jdField_a_of_type_AndroidViewView = d(paramnms);
        break label58;
      }
      this.jdField_a_of_type_AndroidViewView = b();
      break label58;
      label490:
      break;
      label492:
      if ((paramnms.jdField_a_of_type_Int == 2) || ((paramnms.jdField_a_of_type_Int == 5) && (!paramnms.jdField_e_of_type_JavaLangString.equals("[]")))) {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, 0, paramInt, 0);
      } else {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
      }
    }
  }
  
  void a(nms paramnms, int paramInt)
  {
    bfpc localbfpc = (bfpc)bfpp.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localbfpc.a(2131693782, 5, false);
    localbfpc.a(2131693783, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localbfpc.d(0);
    }
    for (;;)
    {
      if ((paramInt != 1) && (paramInt == 2)) {}
      localbfpc.c(2131690596);
      localbfpc.setOnDismissListener(new nfw(this));
      localbfpc.a(new nfx(this, paramnms, localbfpc));
      if (!localbfpc.isShowing())
      {
        this.f = false;
        localbfpc.show();
      }
      return;
      localbfpc.d(1);
    }
  }
  
  void a(nms paramnms, Switch paramSwitch)
  {
    boolean bool = true;
    if (paramnms.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      this.c = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  void a(nms paramnms, Switch paramSwitch, boolean paramBoolean)
  {
    bbgu localbbgu = bbdj.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0);
    localbbgu.setCanceledOnTouchOutside(false);
    String str2 = ajya.a(2131699742);
    String str1 = paramnms.jdField_d_of_type_JavaLangString;
    if (3 == paramnms.jdField_e_of_type_Int) {
      str1 = String.format(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131692182), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name });
    }
    localbbgu.setTitle(str2);
    localbbgu.setMessage(str1);
    localbbgu.setOnCancelListener(new ngl(this, paramnms, paramSwitch));
    paramnms = new ngm(this, paramnms, paramBoolean, paramSwitch);
    localbbgu.setNegativeButton(ajya.a(2131699741), paramnms);
    localbbgu.setPositiveButton(ajya.a(2131699747), paramnms);
    try
    {
      localbbgu.show();
      return;
    }
    catch (Exception paramnms) {}
  }
  
  void a(nms paramnms, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      nfb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramnms, i);
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
      if (sgg.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) != -2) {
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
    if (this.jdField_a_of_type_Ngw != null)
    {
      this.jdField_a_of_type_Ngw.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ngw);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akwr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
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
        localList = nmr.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList);
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
          if ((((nmr)localList.get(i)).jdField_a_of_type_Int != 0) && (((nmr)localList.get(i)).jdField_a_of_type_Int != 1)) {
            break label128;
          }
          bool = a((nmr)localList.get(i), i, j, bool);
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
      Object localObject = ((bajo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_JavaLangString);
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
        mxf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ngg(this), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, 0);
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
        if (((String)localObject3).endsWith(ajya.a(2131699748))) {
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
      new baid("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new ngi(this), 1000, null).a((HashMap)localObject3);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfr
 * JD-Core Version:    0.7.0.1
 */