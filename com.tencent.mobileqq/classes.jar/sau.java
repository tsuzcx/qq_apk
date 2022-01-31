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

public class sau
  extends BaseAdapter
  implements View.OnClickListener, baxz
{
  private float jdField_a_of_type_Float;
  private ahnr jdField_a_of_type_Ahnr;
  private ServiceAccountFolderActivity jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "ServiceAccountFolderFeedAdapter";
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<sat> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private float b;
  private float c;
  
  public sau(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity = paramServiceAccountFolderActivity;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ahnr = new ahnr(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = paramServiceAccountFolderActivity.getResources().getDimension(2131297819);
    this.b = paramServiceAccountFolderActivity.getResources().getDimension(2131297817);
    this.c = (this.jdField_a_of_type_Float + this.b);
  }
  
  private void a(sat paramsat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow->uin:" + paramsat.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.b(true);
    Object localObject = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((akdh)localObject).a(paramsat.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject != null) && (sgg.a(((AccountDetail)localObject).accountFlag) == -4))
      {
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, nor.class);
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramsat.jdField_a_of_type_JavaLangString));
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        ((NewIntent)localObject).putExtra("source", 25);
        ((NewIntent)localObject).setObserver(new saw(this, paramsat));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        sgg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramsat.jdField_a_of_type_JavaLangString);
        return;
        localObject = new akwr(new sax(this, paramsat), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((ajte)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((ajte)localObject);
        akww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramsat.jdField_a_of_type_JavaLangString, 0);
      }
    }
  }
  
  private void a(sat paramsat, int paramInt)
  {
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    localbfpc.a(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131696797), new Object[] { paramsat.jdField_c_of_type_JavaLangString }));
    localbfpc.a(2131696742, 3);
    localbfpc.c(2131690596);
    localbfpc.a(new sav(this, paramsat, paramInt, localbfpc));
    localbfpc.show();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showActionSheet->uin:" + paramsat.jdField_a_of_type_JavaLangString + ", name:" + paramsat.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(say paramsay, int paramInt, View paramView)
  {
    sat localsat = (sat)getItem(paramInt);
    if (localsat == null) {}
    for (;;)
    {
      return;
      boolean bool = a(localsat.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateItemContent->uin:" + localsat.jdField_a_of_type_JavaLangString + ", isFollow:" + bool);
      }
      int i;
      if (bool)
      {
        paramsay.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.setTag(-3, Integer.valueOf((int)this.c));
        paramsay.jdField_a_of_type_JavaLangString = localsat.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Ahnr != null) {
          a(paramsay, localsat.jdField_a_of_type_JavaLangString);
        }
        paramsay.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, localsat.jdField_c_of_type_Int);
        paramsay.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localsat.jdField_c_of_type_JavaLangString);
        paramsay.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localsat.jdField_b_of_type_JavaLangString, 0);
        i = 0;
        if (localsat.e == 4) {
          i = 2130839263;
        }
        paramsay.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
        i = localsat.jdField_d_of_type_Int;
        Object localObject2 = localsat.jdField_d_of_type_JavaLangString;
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
          paramsay.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        paramsay.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject2, 1);
      }
      try
      {
        paramsay.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(new aykk(localsat.jdField_a_of_type_JavaLangCharSequence, 3, 16));
        m = localsat.jdField_b_of_type_Int;
        i = localsat.jdField_a_of_type_Int;
        if (m > 0) {
          if (i == 0)
          {
            paramsay.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramsay.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 0;
            if ((b(localsat.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))))
            {
              this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
              xhb.b(localsat.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_exp", 0, 0, new String[0]);
            }
            bfqs.a(paramsay.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, i, j, 99, null);
            if (!AppSetting.d) {
              continue;
            }
            paramView = new StringBuilder();
            paramView.append(paramsay.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a()).append(",");
            if (i != 0) {
              break label724;
            }
            paramView.append(paramsay.jdField_b_of_type_ComTencentWidgetSingleLineTextView.a()).append(",").append(localsat.jdField_b_of_type_JavaLangString);
            paramsay.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramView);
            return;
            paramsay.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
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
          paramsay.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(localsat.jdField_a_of_type_JavaLangCharSequence + " ");
          continue;
          if (i == 2)
          {
            paramsay.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramsay.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 1;
          }
          else
          {
            int n = 3;
            int i1 = 2130849301;
            paramsay.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramsay.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            i = m;
            j = i1;
            k = n;
            if (b(localsat.jdField_a_of_type_JavaLangString))
            {
              xhb.a(localsat.jdField_a_of_type_JavaLangString, "auth_page", "new_exp", 0, 0, new String[0]);
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
  
  private void a(say paramsay, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "setHolderIcon->uin:" + paramString);
    }
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramsay.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Ahnr.a(1008, paramString));
      return;
    }
    paramsay.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      akdh localakdh;
      do
      {
        do
        {
          return false;
          localakdh = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        } while (localakdh == null);
        localAccountDetail = localakdh.b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
      if (localakdh.c(paramString) != null) {
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
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131695569, 0).show();
  }
  
  private void b(sat paramsat)
  {
    String str = paramsat.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramsat);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramsat));
      if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramsat), 10L);
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    akdh localakdh = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdh != null)
    {
      paramString = localakdh.b(paramString);
      if ((paramString != null) && (sgg.a(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahnr.a();
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
  
  public void a(List<sat> paramList)
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
      if ((paramView.getTag() instanceof say)) {
        paramViewGroup = (say)paramView.getTag();
      }
    }
    localObject1 = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject1 = new say(this);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2131559453, null);
      ((say)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365964));
      ((say)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377350));
      ((say)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365042));
      ((say)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131378655));
      ((say)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131369936));
      ((say)localObject1).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131369915));
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = bbdh.a();
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131166931);
      localObject2 = ((Resources)localObject2).getColorStateList(2131166861);
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject2);
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 0);
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 2);
      ((say)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      ((say)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
      ((say)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
      ((say)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)((say)localObject1).jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      ((say)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      ((say)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((say)localObject1).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
    }
    ((say)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    ((say)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((say)localObject1).jdField_b_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((say)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    a((say)localObject1, paramInt, paramView);
    return paramView;
  }
  
  public void onClick(View arg1)
  {
    int k = ((Integer)???.getTag()).intValue();
    sat localsat = (sat)getItem(k);
    if (localsat == null) {
      return;
    }
    int i = localsat.jdField_b_of_type_Int;
    int j = localsat.jdField_a_of_type_Int;
    if (j != 1) {
      i = 0;
    }
    for (;;)
    {
      long l = saz.a().a(localsat);
      switch (???.getId())
      {
      default: 
        return;
      case 2131365964: 
        ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
        ???.putExtra("uintype", 1008);
        ???.putExtra("uin", localsat.jdField_a_of_type_JavaLangString);
        ???.putExtra("uinname", localsat.jdField_c_of_type_JavaLangString);
        ???.putExtra("start_time", System.currentTimeMillis());
        ???.putExtra("red_hot_count", localsat.jdField_b_of_type_Int);
        ???.putExtra("INTENT_KEY_FROM", 2);
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity(???);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickFeedItem->uin:" + localsat.jdField_a_of_type_JavaLangString + ", name:" + localsat.jdField_c_of_type_JavaLangString);
        }
        ??? = "0X80067F1";
        QQAppInterface localQQAppInterface;
        String str2;
        if (j == 1)
        {
          ??? = "0X80067EF";
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localsat.jdField_a_of_type_JavaLangString, ???, ???, 0, 0, "" + j, "" + l, "" + (k + 1), "" + i);
          ahoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localsat.jdField_a_of_type_JavaLangString, localsat.jdField_a_of_type_Int, localsat.jdField_b_of_type_Int, 2, localsat.jdField_c_of_type_JavaLangString);
          str1 = "";
          ??? = str1;
          if (localsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
          {
            ??? = str1;
            if (localsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
              ??? = localsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
            }
          }
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str2 = localsat.jdField_a_of_type_JavaLangString;
          i = localsat.jdField_a_of_type_Int;
          j = localsat.jdField_b_of_type_Int;
          if (localsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            break label651;
          }
        }
        for (String str1 = "";; str1 = localsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
        {
          akwu.b(localQQAppInterface, str2, i, j, str1, ???);
          if (advo.a(localsat.jdField_a_of_type_JavaLangString)) {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.3.0", "");
          }
          if (b(localsat.jdField_a_of_type_JavaLangString))
          {
            xhb.a(localsat.jdField_a_of_type_JavaLangString, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localsat.jdField_c_of_type_JavaLangString, localsat.jdField_d_of_type_JavaLangString });
            xhb.b(localsat.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_clk", 0, 0, new String[0]);
          }
          sgu.a(null, "SUBSCRIPT_AIO_COST");
          return;
          if (j != 2) {
            break;
          }
          ??? = "0X80067F0";
          break;
        }
      case 2131369936: 
        label651:
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuUnfollow->uin:" + localsat.jdField_a_of_type_JavaLangString + ", name:" + localsat.jdField_c_of_type_JavaLangString);
        }
        a(localsat, k);
        ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localsat));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuDelete->uin:" + localsat.jdField_a_of_type_JavaLangString + ", name:" + localsat.jdField_c_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.remove(localsat);
          notifyDataSetChanged();
          ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localsat));
          if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
            this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
          }
          if (j == 2)
          {
            j = 1;
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localsat.jdField_a_of_type_JavaLangString, "0X80067F3", "0X80067F3", 0, 0, "" + j, "" + i, "" + (k + 1), "" + l);
            ahoo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localsat.jdField_a_of_type_JavaLangString, localsat.jdField_a_of_type_Int, localsat.jdField_b_of_type_Int, 2, localsat.jdField_c_of_type_JavaLangString);
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localsat));
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
        if ((paramBitmap != null) && ((paramBitmap instanceof say)))
        {
          paramBitmap = (say)paramBitmap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sau
 * JD-Core Version:    0.7.0.1
 */