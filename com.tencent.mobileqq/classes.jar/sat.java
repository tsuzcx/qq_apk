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

public class sat
{
  public int a;
  public long a;
  public MessageRecord a;
  public CharSequence a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  @aulz
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  @aulz
  public int e;
  public String e;
  
  public sat()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131166955);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static sat a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    sat localsat = new sat();
    localsat.jdField_a_of_type_Boolean = true;
    localsat.jdField_a_of_type_JavaLangString = paramRecentUser.a();
    localsat.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localsat.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localsat.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localsat.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localsat.jdField_b_of_type_Long = paramRecentUser.a();
    localsat.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localsat.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(localsat.jdField_a_of_type_JavaLangString, 1008);
    localsat.jdField_d_of_type_JavaLangString = saz.a(paramQQAppInterface, localsat.jdField_a_of_type_JavaLangString);
    localsat.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localsat);
    b(paramQQAppInterface, localsat);
    c(paramQQAppInterface, localsat);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localsat.toString());
    }
    return localsat;
  }
  
  public static sat a(QQAppInterface paramQQAppInterface, sda paramsda)
  {
    sat localsat = new sat();
    localsat.jdField_a_of_type_Boolean = false;
    localsat.jdField_a_of_type_JavaLangString = paramsda.jdField_a_of_type_JavaLangString;
    localsat.jdField_b_of_type_Int = paramsda.jdField_b_of_type_Int;
    localsat.jdField_c_of_type_Int = 0;
    localsat.jdField_a_of_type_Long = paramsda.jdField_a_of_type_Long;
    localsat.jdField_b_of_type_JavaLangString = ahpj.a().a(paramsda.jdField_a_of_type_JavaLangString, paramsda.jdField_a_of_type_Long);
    String str2 = sdc.a().a(paramsda.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramsda.jdField_a_of_type_JavaLangString;
    }
    localsat.jdField_c_of_type_JavaLangString = str1;
    if (paramsda.jdField_a_of_type_JavaUtilList.size() > 0) {
      localsat.jdField_a_of_type_JavaLangCharSequence = ((sdb)paramsda.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(paramsda.jdField_a_of_type_JavaLangString, 1008);
    localsat.jdField_d_of_type_JavaLangString = saz.a(paramQQAppInterface, paramsda.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localsat);
    b(paramQQAppInterface, localsat);
    c(paramQQAppInterface, localsat);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localsat.toString());
    }
    return localsat;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, sat paramsat)
  {
    paramQQAppInterface = (akdh)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramsat.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramsat.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramsat.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramsat.jdField_c_of_type_Int = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramsat.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramsat.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramsat.jdField_b_of_type_Boolean = bool;
      paramsat.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, sat paramsat)
  {
    int i = paramQQAppInterface.a().f(paramsat.jdField_a_of_type_JavaLangString, 1008);
    if (paramsat.jdField_b_of_type_Int > 0)
    {
      if ((paramsat.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramsat.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramsat.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramsat.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, sat paramsat)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramsat.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.a(paramsat.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramsat.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramsat.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramsat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramsat.jdField_e_of_type_Int = 4;
    paramsat.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramsat.jdField_b_of_type_JavaLangString = ahpj.a().a(paramsat.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramsat.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
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
 * Qualified Name:     sat
 * JD-Core Version:    0.7.0.1
 */