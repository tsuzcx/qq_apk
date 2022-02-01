import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.SelectMemberBuddyListAdapter.2;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class sbf
  extends amga
  implements View.OnClickListener, View.OnLongClickListener, awza, rxx<ObservableArrayList<ResultRecord>>
{
  private static final sbl jdField_a_of_type_Sbl = new sbl(null);
  private final int jdField_a_of_type_Int;
  protected final Context a;
  private final SparseArray<List<Entity>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected ObservableArrayList<ResultRecord> a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private final ArrayList<Groups> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new sbg(this);
  private ExpandableListView jdField_b_of_type_ComTencentWidgetExpandableListView;
  private final boolean jdField_b_of_type_Boolean;
  private final View.OnClickListener c = new sbi(this);
  
  public sbf(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    paramExpandableListView.post(new SelectMemberBuddyListAdapter.2(this));
    this.jdField_a_of_type_Int = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.jdField_b_of_type_Int = ((int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    return 0;
  }
  
  private void a(List<sbj> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Sbl);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "", paramList);
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560479, paramViewGroup, false);
      paramViewGroup = new sbn();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371803));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364612));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380136);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      paramView.setTag(paramViewGroup);
    }
    PhoneContact localPhoneContact;
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      localPhoneContact = (PhoneContact)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      a(paramViewGroup, null);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewGroup.d.setText(localPhoneContact.name);
      if ((AppSetting.c) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break;
        }
        paramView.setContentDescription(localPhoneContact.name + anvx.a(2131713195));
      }
      return paramView;
      paramViewGroup = (sbn)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    paramView.setContentDescription(localPhoneContact.name + anvx.a(2131713209));
    return paramView;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof sbn)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559663, paramViewGroup, false);
      paramViewGroup = new sbm();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366925));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131378659));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373322));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373305));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131373332));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131378661));
      paramView.setTag(paramViewGroup);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {
        break label483;
      }
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    label483:
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localPublicAccountInfo.uin);
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167026));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        if (AppSetting.c) {
          paramView.setContentDescription(paramViewGroup.d.getText());
        }
        return paramView;
        paramViewGroup = (sbm)paramView.getTag();
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.d.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841803);
        }
        for (;;)
        {
          paramViewGroup.e.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.b.setVisibility(8);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (localObject1 != null)
    {
      Object localObject3 = ((aoxz)localObject1).getRecentList(true);
      if (localObject3 != null)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            try
            {
              if ((((RecentUser)localObject4).getType() == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!bhbx.b(((RecentUser)localObject4).uin)))
              {
                localObject4 = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!bjxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject4).uin))) {
                  ((List)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131717980);
          ((Groups)localObject2).group_friend_count = ((List)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject2).group_id, localObject1);
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    c();
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (localanvk != null)
    {
      localObject1 = localanvk.b();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label561;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("group list is ");
        if (localObject1 != null) {
          break label272;
        }
        localObject2 = "null";
        label90:
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, (String)localObject2);
      }
      if (localObject1 != null) {
        break label561;
      }
      localObject1 = new ArrayList();
    }
    label272:
    label558:
    label561:
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      Groups localGroups;
      Object localObject4;
      Object localObject5;
      int i;
      if (((Iterator)localObject3).hasNext())
      {
        localGroups = (Groups)((Iterator)localObject3).next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
        localObject2 = localanvk.a(String.valueOf(localGroups.group_id));
        if (localObject2 == null) {}
        for (localObject2 = new ArrayList();; localObject2 = new ArrayList((Collection)localObject2))
        {
          localObject4 = new ArrayList();
          localObject5 = ((List)localObject2).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((ArrayList)localObject4).add(new sbj((Friends)((Iterator)localObject5).next(), -1));
          }
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break;
          localObject2 = "empty";
          break label90;
        }
        a((List)localObject4);
        ((List)localObject2).clear();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((sbj)((Iterator)localObject4).next()).a);
        }
        localObject4 = ((List)localObject2).iterator();
        i = 0;
        label359:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int j = ContactUtils.getFriendStatus(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((j == 0) || (j == 6)) {
            break label558;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break label359;
        localObject4 = new ArrayList();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject5 = (Friends)((List)localObject2).get(i);
          if ((!((Friends)localObject5).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!bhbx.b(((Friends)localObject5).uin)) && (!bjxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin))) {
            ((ArrayList)localObject4).add(((List)localObject2).get(i));
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject4);
        break;
        if ((!((List)localObject1).isEmpty()) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_ComTencentWidgetExpandableListView.a(0);
        }
        return;
      }
    }
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    Friends localFriends;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560479, paramViewGroup, false);
      paramViewGroup = new sbn();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371803));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364612));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380136);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      paramView.findViewById(2131379987).setVisibility(8);
      paramView.setTag(paramViewGroup);
      localObject = getChild(paramInt1, paramInt2);
      localFriends = (Friends)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFriends.uin;
      a(paramViewGroup, null);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null)
      {
        if (!bghs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString)) {
          break label342;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = ContactUtils.getFriendName(localFriends);
      paramViewGroup.d.setText((CharSequence)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(ResultRecord.a(localFriends.uin, localFriends.name)));
      a(paramViewGroup, localFriends);
      if ((AppSetting.c) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label355;
        }
        paramView.setContentDescription((String)localObject + anvx.a(2131713180));
      }
      return paramView;
      paramViewGroup = (sbn)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label342:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label355:
    paramView.setContentDescription((String)localObject + anvx.a(2131713185));
    return paramView;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    notifyDataSetChanged();
  }
  
  public void a(long paramLong) {}
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt)
  {
    sbk localsbk = (sbk)paramView.getTag();
    if (localsbk == null)
    {
      localsbk = new sbk();
      paramView.findViewById(2131369395).setVisibility(0);
      localsbk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367894));
      paramView.setTag(localsbk);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      localsbk.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      ((CheckBox)paramView.findViewById(2131369395)).setChecked(this.jdField_b_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      return;
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    if (paramObservableArrayList != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(sbn paramsbn, Friends paramFriends) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onRecommendCountChanged count=" + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public int a_()
  {
    return 2131558982;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(int paramInt) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onUpdateContactList, " + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        l = Long.parseLong(((Friends)localObject).uin);
        return l;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable));
        }
      }
    }
    while (!(localThrowable instanceof PublicAccountInfo))
    {
      long l;
      return 0L;
    }
    return ((PublicAccountInfo)localThrowable).uin;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    blfz.a("getChildView");
    if (a(paramInt1, paramInt2) == 0) {
      paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    for (;;)
    {
      blfz.a();
      return paramView;
      if (a(paramInt1, paramInt2) == 1) {
        paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      } else {
        paramView = c(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localGroups == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id) == null)) {
      return 0;
    }
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (sbk)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
      if (AppSetting.c)
      {
        if (!paramBoolean) {
          break label153;
        }
        paramViewGroup.setContentDescription(((Groups)localObject).group_name + anvx.a(2131713212));
      }
    }
    for (;;)
    {
      paramViewGroup.setOnLongClickListener(this);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560478, paramViewGroup, false);
      paramView = new sbk();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367894));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
      break;
      label153:
      paramViewGroup.setContentDescription(((Groups)localObject).group_name + anvx.a(2131713174));
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    d();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    sbk localsbk = (sbk)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(localsbk.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(localsbk.jdField_a_of_type_Int);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(localsbk.jdField_a_of_type_Int);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    bhjq localbhjq = new bhjq();
    localbhjq.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692986));
    bhcw.a(paramView, localbhjq, this.c, new sbh(this));
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbf
 * JD-Core Version:    0.7.0.1
 */