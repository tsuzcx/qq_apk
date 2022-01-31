import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rof
{
  public int a;
  public long a;
  public MessageRecord a;
  public CharSequence a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  @atnz
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  @atnz
  public int e;
  public String e;
  
  public rof()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131101360);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static rof a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    rof localrof = new rof();
    localrof.jdField_a_of_type_Boolean = true;
    localrof.jdField_a_of_type_JavaLangString = paramRecentUser.a();
    localrof.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localrof.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localrof.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localrof.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localrof.jdField_b_of_type_Long = paramRecentUser.a();
    localrof.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localrof.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(localrof.jdField_a_of_type_JavaLangString, 1008);
    localrof.jdField_d_of_type_JavaLangString = rol.a(paramQQAppInterface, localrof.jdField_a_of_type_JavaLangString);
    localrof.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localrof);
    b(paramQQAppInterface, localrof);
    c(paramQQAppInterface, localrof);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localrof.toString());
    }
    return localrof;
  }
  
  public static rof a(QQAppInterface paramQQAppInterface, rql paramrql)
  {
    rof localrof = new rof();
    localrof.jdField_a_of_type_Boolean = false;
    localrof.jdField_a_of_type_JavaLangString = paramrql.jdField_a_of_type_JavaLangString;
    localrof.jdField_b_of_type_Int = paramrql.jdField_b_of_type_Int;
    localrof.jdField_c_of_type_Int = 0;
    localrof.jdField_a_of_type_Long = paramrql.jdField_a_of_type_Long;
    localrof.jdField_b_of_type_JavaLangString = ahcw.a().a(paramrql.jdField_a_of_type_JavaLangString, paramrql.jdField_a_of_type_Long);
    String str2 = rqn.a().a(paramrql.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramrql.jdField_a_of_type_JavaLangString;
    }
    localrof.jdField_c_of_type_JavaLangString = str1;
    if (paramrql.jdField_a_of_type_JavaUtilList.size() > 0) {
      localrof.jdField_a_of_type_JavaLangCharSequence = ((rqm)paramrql.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(paramrql.jdField_a_of_type_JavaLangString, 1008);
    localrof.jdField_d_of_type_JavaLangString = rol.a(paramQQAppInterface, paramrql.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localrof);
    b(paramQQAppInterface, localrof);
    c(paramQQAppInterface, localrof);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localrof.toString());
    }
    return localrof;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, rof paramrof)
  {
    paramQQAppInterface = (ajoy)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramrof.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramrof.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramrof.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramrof.jdField_c_of_type_Int = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramrof.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramrof.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramrof.jdField_b_of_type_Boolean = bool;
      paramrof.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, rof paramrof)
  {
    int i = paramQQAppInterface.a().f(paramrof.jdField_a_of_type_JavaLangString, 1008);
    if (paramrof.jdField_b_of_type_Int > 0)
    {
      if ((paramrof.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramrof.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramrof.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramrof.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, rof paramrof)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramrof.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.a(paramrof.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramrof.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramrof.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramrof.jdField_e_of_type_Int = 4;
    paramrof.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramrof.jdField_b_of_type_JavaLangString = ahcw.a().a(paramrof.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramrof.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
  }
  
  public final boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServiceAccountFolderFeed content->");
    localStringBuilder.append("mIsCreateFromMessageTab:" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mUin:" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mUnreadFlag:" + this.jdField_a_of_type_Int);
    localStringBuilder.append(", mUnreadNum:" + this.jdField_b_of_type_Int);
    localStringBuilder.append(", mAuthenIconId:" + this.jdField_c_of_type_Int);
    localStringBuilder.append(", mShowTime:" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mTitleName:" + this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", mMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder.append(", mMsgExtraInfo:" + this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", mDraft:" + this.jdField_b_of_type_JavaLangCharSequence);
    localStringBuilder.append(", mStatus:" + this.jdField_e_of_type_Int);
    localStringBuilder.append(", mDisplayTime:" + this.jdField_a_of_type_Long);
    localStringBuilder.append(", mOperationTime:" + this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rof
 * JD-Core Version:    0.7.0.1
 */