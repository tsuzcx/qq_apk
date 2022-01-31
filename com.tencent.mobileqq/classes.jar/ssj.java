import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ssj
{
  public int a;
  public long a;
  public MessageRecord a;
  public CharSequence a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  @awhp
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  @awhp
  public int e;
  public String e;
  
  public ssj()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131167008);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static ssj a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    ssj localssj = new ssj();
    localssj.jdField_a_of_type_Boolean = true;
    localssj.jdField_a_of_type_JavaLangString = paramRecentUser.a();
    localssj.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localssj.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localssj.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localssj.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localssj.jdField_b_of_type_Long = paramRecentUser.a();
    localssj.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localssj.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(localssj.jdField_a_of_type_JavaLangString, 1008);
    localssj.jdField_d_of_type_JavaLangString = ssp.a(paramQQAppInterface, localssj.jdField_a_of_type_JavaLangString);
    localssj.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localssj);
    b(paramQQAppInterface, localssj);
    c(paramQQAppInterface, localssj);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localssj.toString());
    }
    return localssj;
  }
  
  public static ssj a(QQAppInterface paramQQAppInterface, sut paramsut)
  {
    ssj localssj = new ssj();
    localssj.jdField_a_of_type_Boolean = false;
    localssj.jdField_a_of_type_JavaLangString = paramsut.jdField_a_of_type_JavaLangString;
    localssj.jdField_b_of_type_Int = paramsut.jdField_b_of_type_Int;
    localssj.jdField_c_of_type_Int = 0;
    localssj.jdField_a_of_type_Long = paramsut.jdField_a_of_type_Long;
    localssj.jdField_b_of_type_JavaLangString = ajlh.a().a(paramsut.jdField_a_of_type_JavaLangString, paramsut.jdField_a_of_type_Long);
    String str2 = suv.a().a(paramsut.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramsut.jdField_a_of_type_JavaLangString;
    }
    localssj.jdField_c_of_type_JavaLangString = str1;
    if (paramsut.jdField_a_of_type_JavaUtilList.size() > 0) {
      localssj.jdField_a_of_type_JavaLangCharSequence = ((suu)paramsut.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(paramsut.jdField_a_of_type_JavaLangString, 1008);
    localssj.jdField_d_of_type_JavaLangString = ssp.a(paramQQAppInterface, paramsut.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localssj);
    b(paramQQAppInterface, localssj);
    c(paramQQAppInterface, localssj);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localssj.toString());
    }
    return localssj;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ssj paramssj)
  {
    paramQQAppInterface = (alzl)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramssj.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramssj.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramssj.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramssj.jdField_c_of_type_Int = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramssj.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramssj.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramssj.jdField_b_of_type_Boolean = bool;
      paramssj.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ssj paramssj)
  {
    int i = paramQQAppInterface.a().g(paramssj.jdField_a_of_type_JavaLangString, 1008);
    if (paramssj.jdField_b_of_type_Int > 0)
    {
      if ((paramssj.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramssj.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramssj.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramssj.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, ssj paramssj)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramssj.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.a(paramssj.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramssj.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramssj.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramssj.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramssj.jdField_e_of_type_Int = 4;
    paramssj.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramssj.jdField_b_of_type_JavaLangString = ajlh.a().a(paramssj.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramssj.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ssj
 * JD-Core Version:    0.7.0.1
 */