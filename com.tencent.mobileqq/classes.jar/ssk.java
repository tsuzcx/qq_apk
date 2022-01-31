import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.1;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.2;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.3;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.7;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ssk
  extends BaseAdapter
  implements View.OnClickListener, bcwt
{
  private float jdField_a_of_type_Float;
  private ajfa jdField_a_of_type_Ajfa;
  private ServiceAccountFolderActivity jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "ServiceAccountFolderFeedAdapter";
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<ssj> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private float b;
  private float c;
  
  public ssk(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity = paramServiceAccountFolderActivity;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ajfa = new ajfa(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = paramServiceAccountFolderActivity.getResources().getDimension(2131297840);
    this.b = paramServiceAccountFolderActivity.getResources().getDimension(2131297838);
    this.c = (this.jdField_a_of_type_Float + this.b);
  }
  
  private void a(ssj paramssj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow->uin:" + paramssj.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.b(true);
    Object localObject = (aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((aluw)localObject).a(paramssj.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject != null) && (syb.a(((AccountDetail)localObject).accountFlag) == -4))
      {
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, nrz.class);
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramssj.jdField_a_of_type_JavaLangString));
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        ((NewIntent)localObject).putExtra("source", 25);
        ((NewIntent)localObject).setObserver(new ssm(this, paramssj));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramssj.jdField_a_of_type_JavaLangString);
        return;
        localObject = new amnh(new ssn(this, paramssj), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((alkr)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((alkr)localObject);
        amnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramssj.jdField_a_of_type_JavaLangString, 0);
      }
    }
  }
  
  private void a(ssj paramssj, int paramInt)
  {
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    localbhpy.a(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131696972), new Object[] { paramssj.jdField_c_of_type_JavaLangString }));
    localbhpy.a(2131696917, 3);
    localbhpy.c(2131690648);
    localbhpy.a(new ssl(this, paramssj, paramInt, localbhpy));
    localbhpy.show();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showActionSheet->uin:" + paramssj.jdField_a_of_type_JavaLangString + ", name:" + paramssj.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(sso paramsso, int paramInt, View paramView)
  {
    ssj localssj = (ssj)getItem(paramInt);
    if (localssj == null) {}
    for (;;)
    {
      return;
      boolean bool = a(localssj.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateItemContent->uin:" + localssj.jdField_a_of_type_JavaLangString + ", isFollow:" + bool);
      }
      int i;
      if (bool)
      {
        paramsso.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.setTag(-3, Integer.valueOf((int)this.c));
        paramsso.jdField_a_of_type_JavaLangString = localssj.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Ajfa != null) {
          a(paramsso, localssj.jdField_a_of_type_JavaLangString);
        }
        paramsso.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, localssj.jdField_c_of_type_Int);
        paramsso.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localssj.jdField_c_of_type_JavaLangString);
        paramsso.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localssj.jdField_b_of_type_JavaLangString, 0);
        i = 0;
        if (localssj.e == 4) {
          i = 2130839352;
        }
        paramsso.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
        i = localssj.jdField_d_of_type_Int;
        Object localObject2 = localssj.jdField_d_of_type_JavaLangString;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0)
        {
          localObject2 = localObject1;
          if (!((String)localObject1).endsWith(" ")) {
            localObject2 = (String)localObject1 + " ";
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i != 0)) {
          paramsso.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        paramsso.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject2, 1);
      }
      try
      {
        paramsso.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(new baig(localssj.jdField_a_of_type_JavaLangCharSequence, 3, 16));
        m = localssj.jdField_b_of_type_Int;
        i = localssj.jdField_a_of_type_Int;
        if (m > 0) {
          if (i == 0)
          {
            paramsso.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramsso.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 0;
            if ((b(localssj.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))))
            {
              this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
              yvu.b(localssj.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_exp", 0, 0, new String[0]);
            }
            bhro.a(paramsso.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, i, j, 99, null);
            if (!AppSetting.c) {
              continue;
            }
            paramView = new StringBuilder();
            paramView.append(paramsso.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a()).append(",");
            if (i != 0) {
              break label724;
            }
            paramView.append(paramsso.jdField_b_of_type_ComTencentWidgetSingleLineTextView.a()).append(",").append(localssj.jdField_b_of_type_JavaLangString);
            paramsso.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramView);
            return;
            paramsso.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramView.setTag(-3, Integer.valueOf((int)this.b));
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int m;
          int j;
          int k;
          localException.printStackTrace();
          paramsso.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(localssj.jdField_a_of_type_JavaLangCharSequence + " ");
          continue;
          if (i == 2)
          {
            paramsso.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramsso.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 1;
          }
          else
          {
            int n = 3;
            int i1 = 2130849732;
            paramsso.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramsso.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            i = m;
            j = i1;
            k = n;
            if (b(localssj.jdField_a_of_type_JavaLangString))
            {
              yvu.a(localssj.jdField_a_of_type_JavaLangString, "auth_page", "new_exp", 0, 0, new String[0]);
              i = m;
              j = i1;
              k = n;
              continue;
              label724:
              if (i == 1)
              {
                paramView.append("有一条未读,");
              }
              else if (i == 2)
              {
                paramView.append("有两条未读,");
              }
              else if (i > 0)
              {
                paramView.append("有").append(i).append("条未读,");
                continue;
                i = 0;
                j = 0;
                k = 0;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(sso paramsso, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "setHolderIcon->uin:" + paramString);
    }
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramsso.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Ajfa.a(1008, paramString));
      return;
    }
    paramsso.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      aluw localaluw;
      do
      {
        do
        {
          return false;
          localaluw = (aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        } while (localaluw == null);
        localAccountDetail = localaluw.b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
      if (localaluw.c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131695727, 0).show();
  }
  
  private void b(ssj paramssj)
  {
    String str = paramssj.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramssj);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramssj));
      if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramssj), 10L);
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    aluw localaluw = (aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localaluw != null)
    {
      paramString = localaluw.b(paramString);
      if ((paramString != null) && (syb.a(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ajfa.a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<ssj> paramList)
  {
    if (paramList != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "setDataList->DataSetChanged size:" + paramList.size());
      }
      return;
    }
  }
  
  public int getCount()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
  
  public Object getItem(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramInt >= getCount()) {
        return null;
      }
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return localObject2;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    paramViewGroup = (ViewGroup)localObject1;
    if (paramView != null)
    {
      paramViewGroup = (ViewGroup)localObject1;
      if ((paramView.getTag() instanceof sso)) {
        paramViewGroup = (sso)paramView.getTag();
      }
    }
    localObject1 = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject1 = new sso(this);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2131559505, null);
      ((sso)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366051));
      ((sso)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377884));
      ((sso)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365127));
      ((sso)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379273));
      ((sso)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370201));
      ((sso)localObject1).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370180));
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = bdcb.a();
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131166979);
      localObject2 = ((Resources)localObject2).getColorStateList(2131166908);
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject2);
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 0);
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 2);
      ((sso)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      ((sso)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
      ((sso)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
      ((sso)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)((sso)localObject1).jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      ((sso)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      ((sso)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((sso)localObject1).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
    }
    ((sso)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    ((sso)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((sso)localObject1).jdField_b_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((sso)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    a((sso)localObject1, paramInt, paramView);
    return paramView;
  }
  
  public void onClick(View arg1)
  {
    int k = ((Integer)???.getTag()).intValue();
    ssj localssj = (ssj)getItem(k);
    if (localssj == null) {
      return;
    }
    int i = localssj.jdField_b_of_type_Int;
    int j = localssj.jdField_a_of_type_Int;
    if (j != 1) {
      i = 0;
    }
    for (;;)
    {
      long l = ssp.a().a(localssj);
      switch (???.getId())
      {
      default: 
        return;
      case 2131366051: 
        ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
        ???.putExtra("uintype", 1008);
        ???.putExtra("uin", localssj.jdField_a_of_type_JavaLangString);
        ???.putExtra("uinname", localssj.jdField_c_of_type_JavaLangString);
        ???.putExtra("start_time", System.currentTimeMillis());
        ???.putExtra("red_hot_count", localssj.jdField_b_of_type_Int);
        ???.putExtra("INTENT_KEY_FROM", 2);
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity(???);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickFeedItem->uin:" + localssj.jdField_a_of_type_JavaLangString + ", name:" + localssj.jdField_c_of_type_JavaLangString);
        }
        ??? = "0X80067F1";
        QQAppInterface localQQAppInterface;
        String str2;
        if (j == 1)
        {
          ??? = "0X80067EF";
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localssj.jdField_a_of_type_JavaLangString, ???, ???, 0, 0, "" + j, "" + l, "" + (k + 1), "" + i);
          ajfx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localssj.jdField_a_of_type_JavaLangString, localssj.jdField_a_of_type_Int, localssj.jdField_b_of_type_Int, 2, localssj.jdField_c_of_type_JavaLangString);
          str1 = "";
          ??? = str1;
          if (localssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
          {
            ??? = str1;
            if (localssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
              ??? = localssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
            }
          }
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str2 = localssj.jdField_a_of_type_JavaLangString;
          i = localssj.jdField_a_of_type_Int;
          j = localssj.jdField_b_of_type_Int;
          if (localssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            break label651;
          }
        }
        for (String str1 = "";; str1 = localssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
        {
          amnk.b(localQQAppInterface, str2, i, j, str1, ???);
          if (afsb.a(localssj.jdField_a_of_type_JavaLangString)) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.3.3", "");
          }
          if (b(localssj.jdField_a_of_type_JavaLangString))
          {
            yvu.a(localssj.jdField_a_of_type_JavaLangString, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localssj.jdField_c_of_type_JavaLangString, localssj.jdField_d_of_type_JavaLangString });
            yvu.b(localssj.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_clk", 0, 0, new String[0]);
          }
          syp.a(null, "SUBSCRIPT_AIO_COST");
          return;
          if (j != 2) {
            break;
          }
          ??? = "0X80067F0";
          break;
        }
      case 2131370201: 
        label651:
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuUnfollow->uin:" + localssj.jdField_a_of_type_JavaLangString + ", name:" + localssj.jdField_c_of_type_JavaLangString);
        }
        a(localssj, k);
        ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localssj));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuDelete->uin:" + localssj.jdField_a_of_type_JavaLangString + ", name:" + localssj.jdField_c_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.remove(localssj);
          notifyDataSetChanged();
          ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localssj));
          if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
            this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
          }
          if (j == 2)
          {
            j = 1;
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localssj.jdField_a_of_type_JavaLangString, "0X80067F3", "0X80067F3", 0, 0, "" + j, "" + i, "" + (k + 1), "" + l);
            ajfx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localssj.jdField_a_of_type_JavaLangString, localssj.jdField_a_of_type_Int, localssj.jdField_b_of_type_Int, 2, localssj.jdField_c_of_type_JavaLangString);
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localssj));
            return;
          }
        }
        j = 0;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof sso)))
        {
          paramBitmap = (sso)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderFeedAdapter", 2, "onDecodeTaskCompleted->uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ssk
 * JD-Core Version:    0.7.0.1
 */