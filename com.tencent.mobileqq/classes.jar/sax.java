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

public class sax
  extends BaseAdapter
  implements View.OnClickListener, baxl
{
  private float jdField_a_of_type_Float;
  private ahnt jdField_a_of_type_Ahnt;
  private ServiceAccountFolderActivity jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "ServiceAccountFolderFeedAdapter";
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<saw> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private float b;
  private float c;
  
  public sax(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity = paramServiceAccountFolderActivity;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ahnt = new ahnt(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = paramServiceAccountFolderActivity.getResources().getDimension(2131297819);
    this.b = paramServiceAccountFolderActivity.getResources().getDimension(2131297817);
    this.c = (this.jdField_a_of_type_Float + this.b);
  }
  
  private void a(saw paramsaw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow->uin:" + paramsaw.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.b(true);
    Object localObject = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((akdi)localObject).a(paramsaw.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject != null) && (sgj.a(((AccountDetail)localObject).accountFlag) == -4))
      {
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, nou.class);
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramsaw.jdField_a_of_type_JavaLangString));
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        ((NewIntent)localObject).putExtra("source", 25);
        ((NewIntent)localObject).setObserver(new saz(this, paramsaw));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        sgj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramsaw.jdField_a_of_type_JavaLangString);
        return;
        localObject = new akws(new sba(this, paramsaw), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((ajtg)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((ajtg)localObject);
        akwx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramsaw.jdField_a_of_type_JavaLangString, 0);
      }
    }
  }
  
  private void a(saw paramsaw, int paramInt)
  {
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    localbfol.a(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131696796), new Object[] { paramsaw.jdField_c_of_type_JavaLangString }));
    localbfol.a(2131696741, 3);
    localbfol.c(2131690596);
    localbfol.a(new say(this, paramsaw, paramInt, localbfol));
    localbfol.show();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showActionSheet->uin:" + paramsaw.jdField_a_of_type_JavaLangString + ", name:" + paramsaw.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(sbb paramsbb, int paramInt, View paramView)
  {
    saw localsaw = (saw)getItem(paramInt);
    if (localsaw == null) {}
    for (;;)
    {
      return;
      boolean bool = a(localsaw.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateItemContent->uin:" + localsaw.jdField_a_of_type_JavaLangString + ", isFollow:" + bool);
      }
      int i;
      if (bool)
      {
        paramsbb.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.setTag(-3, Integer.valueOf((int)this.c));
        paramsbb.jdField_a_of_type_JavaLangString = localsaw.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Ahnt != null) {
          a(paramsbb, localsaw.jdField_a_of_type_JavaLangString);
        }
        paramsbb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, localsaw.jdField_c_of_type_Int);
        paramsbb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localsaw.jdField_c_of_type_JavaLangString);
        paramsbb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localsaw.jdField_b_of_type_JavaLangString, 0);
        i = 0;
        if (localsaw.e == 4) {
          i = 2130839263;
        }
        paramsbb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
        i = localsaw.jdField_d_of_type_Int;
        Object localObject2 = localsaw.jdField_d_of_type_JavaLangString;
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
          paramsbb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        paramsbb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject2, 1);
      }
      try
      {
        paramsbb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(new ayki(localsaw.jdField_a_of_type_JavaLangCharSequence, 3, 16));
        m = localsaw.jdField_b_of_type_Int;
        i = localsaw.jdField_a_of_type_Int;
        if (m > 0) {
          if (i == 0)
          {
            paramsbb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramsbb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 0;
            if ((b(localsaw.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))))
            {
              this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
              xhe.b(localsaw.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_exp", 0, 0, new String[0]);
            }
            bfqb.a(paramsbb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, i, j, 99, null);
            if (!AppSetting.d) {
              continue;
            }
            paramView = new StringBuilder();
            paramView.append(paramsbb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a()).append(",");
            if (i != 0) {
              break label724;
            }
            paramView.append(paramsbb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.a()).append(",").append(localsaw.jdField_b_of_type_JavaLangString);
            paramsbb.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramView);
            return;
            paramsbb.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
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
          paramsbb.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(localsaw.jdField_a_of_type_JavaLangCharSequence + " ");
          continue;
          if (i == 2)
          {
            paramsbb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramsbb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 1;
          }
          else
          {
            int n = 3;
            int i1 = 2130849292;
            paramsbb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramsbb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            i = m;
            j = i1;
            k = n;
            if (b(localsaw.jdField_a_of_type_JavaLangString))
            {
              xhe.a(localsaw.jdField_a_of_type_JavaLangString, "auth_page", "new_exp", 0, 0, new String[0]);
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
  
  private void a(sbb paramsbb, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "setHolderIcon->uin:" + paramString);
    }
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramsbb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Ahnt.a(1008, paramString));
      return;
    }
    paramsbb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      akdi localakdi;
      do
      {
        do
        {
          return false;
          localakdi = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        } while (localakdi == null);
        localAccountDetail = localakdi.b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
      if (localakdi.c(paramString) != null) {
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
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131695568, 0).show();
  }
  
  private void b(saw paramsaw)
  {
    String str = paramsaw.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramsaw);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramsaw));
      if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramsaw), 10L);
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    akdi localakdi = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdi != null)
    {
      paramString = localakdi.b(paramString);
      if ((paramString != null) && (sgj.a(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahnt.a();
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
  
  public void a(List<saw> paramList)
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
      if ((paramView.getTag() instanceof sbb)) {
        paramViewGroup = (sbb)paramView.getTag();
      }
    }
    localObject1 = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject1 = new sbb(this);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2131559453, null);
      ((sbb)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365964));
      ((sbb)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377350));
      ((sbb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365043));
      ((sbb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131378650));
      ((sbb)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131369937));
      ((sbb)localObject1).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131369916));
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = bbct.a();
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131166931);
      localObject2 = ((Resources)localObject2).getColorStateList(2131166861);
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject2);
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 0);
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramViewGroup, 2);
      ((sbb)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      ((sbb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
      ((sbb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
      ((sbb)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)((sbb)localObject1).jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      ((sbb)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      ((sbb)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((sbb)localObject1).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject1);
    }
    ((sbb)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    ((sbb)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((sbb)localObject1).jdField_b_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((sbb)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    a((sbb)localObject1, paramInt, paramView);
    return paramView;
  }
  
  public void onClick(View arg1)
  {
    int k = ((Integer)???.getTag()).intValue();
    saw localsaw = (saw)getItem(k);
    if (localsaw == null) {
      return;
    }
    int i = localsaw.jdField_b_of_type_Int;
    int j = localsaw.jdField_a_of_type_Int;
    if (j != 1) {
      i = 0;
    }
    for (;;)
    {
      long l = sbc.a().a(localsaw);
      switch (???.getId())
      {
      default: 
        return;
      case 2131365964: 
        ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
        ???.putExtra("uintype", 1008);
        ???.putExtra("uin", localsaw.jdField_a_of_type_JavaLangString);
        ???.putExtra("uinname", localsaw.jdField_c_of_type_JavaLangString);
        ???.putExtra("start_time", System.currentTimeMillis());
        ???.putExtra("red_hot_count", localsaw.jdField_b_of_type_Int);
        ???.putExtra("INTENT_KEY_FROM", 2);
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity(???);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickFeedItem->uin:" + localsaw.jdField_a_of_type_JavaLangString + ", name:" + localsaw.jdField_c_of_type_JavaLangString);
        }
        ??? = "0X80067F1";
        QQAppInterface localQQAppInterface;
        String str2;
        if (j == 1)
        {
          ??? = "0X80067EF";
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localsaw.jdField_a_of_type_JavaLangString, ???, ???, 0, 0, "" + j, "" + l, "" + (k + 1), "" + i);
          ahoq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localsaw.jdField_a_of_type_JavaLangString, localsaw.jdField_a_of_type_Int, localsaw.jdField_b_of_type_Int, 2, localsaw.jdField_c_of_type_JavaLangString);
          str1 = "";
          ??? = str1;
          if (localsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
          {
            ??? = str1;
            if (localsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
              ??? = localsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
            }
          }
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str2 = localsaw.jdField_a_of_type_JavaLangString;
          i = localsaw.jdField_a_of_type_Int;
          j = localsaw.jdField_b_of_type_Int;
          if (localsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
            break label651;
          }
        }
        for (String str1 = "";; str1 = localsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
        {
          akwv.b(localQQAppInterface, str2, i, j, str1, ???);
          if (advq.a(localsaw.jdField_a_of_type_JavaLangString)) {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.2.8", "");
          }
          if (b(localsaw.jdField_a_of_type_JavaLangString))
          {
            xhe.a(localsaw.jdField_a_of_type_JavaLangString, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localsaw.jdField_c_of_type_JavaLangString, localsaw.jdField_d_of_type_JavaLangString });
            xhe.b(localsaw.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_clk", 0, 0, new String[0]);
          }
          sgx.a(null, "SUBSCRIPT_AIO_COST");
          return;
          if (j != 2) {
            break;
          }
          ??? = "0X80067F0";
          break;
        }
      case 2131369937: 
        label651:
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuUnfollow->uin:" + localsaw.jdField_a_of_type_JavaLangString + ", name:" + localsaw.jdField_c_of_type_JavaLangString);
        }
        a(localsaw, k);
        ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localsaw));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuDelete->uin:" + localsaw.jdField_a_of_type_JavaLangString + ", name:" + localsaw.jdField_c_of_type_JavaLangString);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.remove(localsaw);
          notifyDataSetChanged();
          ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localsaw));
          if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
            this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
          }
          if (j == 2)
          {
            j = 1;
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localsaw.jdField_a_of_type_JavaLangString, "0X80067F3", "0X80067F3", 0, 0, "" + j, "" + i, "" + (k + 1), "" + l);
            ahoq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localsaw.jdField_a_of_type_JavaLangString, localsaw.jdField_a_of_type_Int, localsaw.jdField_b_of_type_Int, 2, localsaw.jdField_c_of_type_JavaLangString);
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localsaw));
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
        if ((paramBitmap != null) && ((paramBitmap instanceof sbb)))
        {
          paramBitmap = (sbb)paramBitmap;
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
 * Qualified Name:     sax
 * JD-Core Version:    0.7.0.1
 */