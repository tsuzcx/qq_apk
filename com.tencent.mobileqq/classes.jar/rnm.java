import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import mqq.os.MqqHandler;

public class rnm
  implements XEditTextEx.OnPrivateIMECommandListener
{
  public rnm(BaseChatPie paramBaseChatPie) {}
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onPrivateIMECommand(), action:" + paramString);
    }
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null) && (InputMethodUtil.a(this.a.jdField_a_of_type_AndroidContentContext)))
    {
      if ((!"com.sogou.inputmethod.expression".equals(paramString)) && (!"com.tencent.qqpinyin.expression".equals(paramString))) {
        break label182;
      }
      if (!"com.sogou.inputmethod.expression".equals(paramString)) {
        break label168;
      }
      paramString = paramBundle.getString("SOGOU_EXP_PATH");
      i = 1034;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onPrivateIMECommand(), path:" + paramString + ", busiType = " + i);
      }
      if (!TextUtils.isEmpty(paramString)) {
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, i);
      }
    }
    label168:
    label182:
    do
    {
      do
      {
        return true;
        paramString = paramBundle.getString("QQINPUT_EXP_PATH");
        i = 1038;
        break;
        if ("com.sogou.inputmethod.appid".equals(paramString))
        {
          localObject1 = paramBundle.getString("SOGOU_APP_ID");
          Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          paramString = AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), (String)localObject2, (String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "onPrivateIMECommand(), appId:" + (String)localObject1 + "selfUin:" + (String)localObject2 + "openId:" + paramString);
          }
          localObject1 = (InputMethodManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("SOGOU_OPENID", paramString);
          ((InputMethodManager)localObject1).sendAppPrivateCommand(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, "com.tencent.mobileqq.sogou.openid", (Bundle)localObject2);
          paramString = paramBundle.getStringArrayList("EXP_ALL_PACKID");
          if (BaseChatPie.a(this.a) == null) {
            BaseChatPie.a(this.a, new SogouEmoji(this.a));
          }
          BaseChatPie.a(this.a).a(paramString);
          return true;
        }
        if (("com.sogou.inputmethod.qqexp".equals(paramString)) || ("com.tencent.qqpinyin.qqexp".equals(paramString)))
        {
          i = paramBundle.getInt("PACKAGE_ID");
          paramString = paramBundle.getString("EXP_ID");
          paramBundle = paramBundle.getString("EXP_PATH");
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "onPrivateIMECommand(), packId:" + i + ",exprId:" + paramString + ",ePath:" + paramBundle);
          }
          if (BaseChatPie.a(this.a) == null) {
            BaseChatPie.a(this.a, new SogouEmoji(this.a));
          }
          BaseChatPie.a(this.a).a(i, paramString);
          return true;
        }
      } while (!"com.tencent.mobileqq_audioArgs".equals(paramString));
      paramString = paramBundle.getString("PCMFilePath");
      i = paramBundle.getInt("SampleRate");
      int j = paramBundle.getInt("Channels");
      Object localObject1 = (QQRecorder.RecorderParam)this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.a;
      paramBundle = paramBundle.getString("InputMethodName");
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "recv args from sogou, pcmPath = " + paramString + " sampleRate = " + i + " channels = " + j + " inputName = " + paramBundle + " my sampleRate = " + ((QQRecorder.RecorderParam)localObject1).a);
      }
      if ((i == ((QQRecorder.RecorderParam)localObject1).a) && (!StringUtil.a(paramString))) {
        break label667;
      }
    } while (!QLog.isColorLevel());
    QLog.d("sougouptt", 2, "invalid datas from sougou ");
    return true;
    label667:
    ThreadManager.getSubThreadHandler().post(new rnn(this, paramString, i, paramBundle));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnm
 * JD-Core Version:    0.7.0.1
 */