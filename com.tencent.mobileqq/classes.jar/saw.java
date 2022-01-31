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

public class saw
{
  public int a;
  public long a;
  public MessageRecord a;
  public CharSequence a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  @aulx
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  @aulx
  public int e;
  public String e;
  
  public saw()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131166955);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static saw a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    saw localsaw = new saw();
    localsaw.jdField_a_of_type_Boolean = true;
    localsaw.jdField_a_of_type_JavaLangString = paramRecentUser.a();
    localsaw.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localsaw.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localsaw.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localsaw.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localsaw.jdField_b_of_type_Long = paramRecentUser.a();
    localsaw.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localsaw.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(localsaw.jdField_a_of_type_JavaLangString, 1008);
    localsaw.jdField_d_of_type_JavaLangString = sbc.a(paramQQAppInterface, localsaw.jdField_a_of_type_JavaLangString);
    localsaw.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localsaw);
    b(paramQQAppInterface, localsaw);
    c(paramQQAppInterface, localsaw);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localsaw.toString());
    }
    return localsaw;
  }
  
  public static saw a(QQAppInterface paramQQAppInterface, sdd paramsdd)
  {
    saw localsaw = new saw();
    localsaw.jdField_a_of_type_Boolean = false;
    localsaw.jdField_a_of_type_JavaLangString = paramsdd.jdField_a_of_type_JavaLangString;
    localsaw.jdField_b_of_type_Int = paramsdd.jdField_b_of_type_Int;
    localsaw.jdField_c_of_type_Int = 0;
    localsaw.jdField_a_of_type_Long = paramsdd.jdField_a_of_type_Long;
    localsaw.jdField_b_of_type_JavaLangString = ahpl.a().a(paramsdd.jdField_a_of_type_JavaLangString, paramsdd.jdField_a_of_type_Long);
    String str2 = sdf.a().a(paramsdd.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramsdd.jdField_a_of_type_JavaLangString;
    }
    localsaw.jdField_c_of_type_JavaLangString = str1;
    if (paramsdd.jdField_a_of_type_JavaUtilList.size() > 0) {
      localsaw.jdField_a_of_type_JavaLangCharSequence = ((sde)paramsdd.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(paramsdd.jdField_a_of_type_JavaLangString, 1008);
    localsaw.jdField_d_of_type_JavaLangString = sbc.a(paramQQAppInterface, paramsdd.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localsaw);
    b(paramQQAppInterface, localsaw);
    c(paramQQAppInterface, localsaw);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localsaw.toString());
    }
    return localsaw;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, saw paramsaw)
  {
    paramQQAppInterface = (akdi)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramsaw.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramsaw.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramsaw.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramsaw.jdField_c_of_type_Int = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramsaw.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramsaw.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramsaw.jdField_b_of_type_Boolean = bool;
      paramsaw.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, saw paramsaw)
  {
    int i = paramQQAppInterface.a().f(paramsaw.jdField_a_of_type_JavaLangString, 1008);
    if (paramsaw.jdField_b_of_type_Int > 0)
    {
      if ((paramsaw.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramsaw.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramsaw.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramsaw.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, saw paramsaw)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramsaw.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.a(paramsaw.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramsaw.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramsaw.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramsaw.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramsaw.jdField_e_of_type_Int = 4;
    paramsaw.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramsaw.jdField_b_of_type_JavaLangString = ahpl.a().a(paramsaw.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramsaw.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
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
 * Qualified Name:     saw
 * JD-Core Version:    0.7.0.1
 */