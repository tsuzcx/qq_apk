package cooperation.comic.emoticon;

import altn;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionCommPicTryUp;

public class VipComicEmoticonUploadManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private UpCallBack jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new altn(this);
  public RemoteCommand.OnInvokeFinishLinstener a;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private String jdField_a_of_type_JavaLangString;
  
  public VipComicEmoticonUploadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.a();
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
  }
  
  public void a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = paramOnInvokeFinishLinstener;
      paramOnInvokeFinishLinstener = new TransferRequest();
      paramOnInvokeFinishLinstener.jdField_b_of_type_Int = 24;
      paramOnInvokeFinishLinstener.jdField_c_of_type_Int = 20;
      paramOnInvokeFinishLinstener.jdField_a_of_type_JavaLangString = "actQqComicPicUpload";
      paramOnInvokeFinishLinstener.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.jdField_a_of_type_Boolean = true;
      paramOnInvokeFinishLinstener.i = paramBundle.getString("localPath");
      paramOnInvokeFinishLinstener.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack;
      Object localObject = paramBundle.getString("comicId");
      String str1 = paramBundle.getString("picMd5");
      String str2 = paramBundle.getString("actionData");
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("comicId", localObject);
        paramBundle.put("picMd5", str1);
        paramBundle.put("actionData", str2);
        localObject = new cmd0x388.ExtensionCommPicTryUp();
        ((cmd0x388.ExtensionCommPicTryUp)localObject).rpt_bytes_extinfo.add(ByteStringMicro.copyFrom(paramBundle.toString().getBytes()));
        paramOnInvokeFinishLinstener.jdField_a_of_type_ArrayOfByte = ((cmd0x388.ExtensionCommPicTryUp)localObject).toByteArray();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramOnInvokeFinishLinstener);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.emoticon.VipComicEmoticonUploadManager
 * JD-Core Version:    0.7.0.1
 */