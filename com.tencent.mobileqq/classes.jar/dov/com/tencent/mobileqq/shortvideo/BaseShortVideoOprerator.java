package dov.com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aocy;
import azjj;
import azjk;
import azjq;
import azkb;
import azla;
import azlb;
import bpql;
import bpqx;
import bpqz;
import bpra;
import bprf;
import bprg;
import bprh;
import bprl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements azjj, azla, bpqx
{
  static int a;
  protected Handler a;
  public bprf a;
  protected bprl a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public String b;
  
  static
  {
    jdField_a_of_type_Int = 3;
  }
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new bpql(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bprf parambprf)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, azkb paramazkb)
  {
    bprg localbprg = new bprg();
    localbprg.jdField_a_of_type_Bprf = this.jdField_a_of_type_Bprf;
    localbprg.jdField_a_of_type_Azkb = paramazkb;
    localbprg.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbprg);
    if (paramazkb != null)
    {
      azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramazkb.jdField_a_of_type_JavaLangString, paramazkb.jdField_b_of_type_JavaLangString);
      return;
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bprg parambprg)
  {
    bprg localbprg = parambprg;
    if (parambprg == null) {
      localbprg = new bprg();
    }
    localbprg.jdField_a_of_type_Int = 0;
    localbprg.jdField_a_of_type_Bprf = this.jdField_a_of_type_Bprf;
    a(paramInt, 0, localbprg);
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bprg localbprg = new bprg();
    localbprg.jdField_a_of_type_Int = 0;
    localbprg.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbprg);
  }
  
  public void a(Message paramMessage)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bprl == null) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      case 4: 
      default: 
        return;
      case 0: 
        paramMessage = (bprg)paramMessage.obj;
        this.jdField_a_of_type_Bprl.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bprg)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bprl.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bprg)paramMessage.obj;
    this.jdField_a_of_type_Bprl.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bprl.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (bprg)paramMessage.obj;
      this.jdField_a_of_type_Bprl.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
      paramMessage = null;
    }
  }
  
  public void a(azjk paramazjk)
  {
    if (paramazjk == null)
    {
      paramazjk = new azkb();
      paramazjk.jdField_b_of_type_JavaLangString = "result == null";
      paramazjk.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramazjk);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bprf);
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramazjk.jdField_a_of_type_Int);
    Object localObject = new bprg();
    ((bprg)localObject).jdField_a_of_type_Int = paramazjk.jdField_a_of_type_Int;
    ((bprg)localObject).jdField_a_of_type_JavaLangObject = paramazjk;
    if (paramazjk.jdField_a_of_type_Int == 0)
    {
      a(0, (bprg)localObject);
      return;
    }
    if (paramazjk.jdField_a_of_type_Azkb == null)
    {
      localObject = new azkb();
      ((azkb)localObject).jdField_b_of_type_JavaLangString = (paramazjk.jdField_b_of_type_Int + "_" + paramazjk.jdField_a_of_type_JavaLangString);
      ((azkb)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (azkb)localObject);
      return;
    }
    a(0, paramazjk.jdField_a_of_type_Azkb);
  }
  
  public void a(bpqz parambpqz)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambpqz))
    {
      b(parambpqz);
      return;
    }
    azjk localazjk = new azjk();
    localazjk.jdField_a_of_type_Int = -1;
    localazjk.jdField_a_of_type_Azkb = parambpqz.jdField_a_of_type_Azkb;
    a(localazjk);
  }
  
  public void a(bpra parambpra)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambpra)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambpra));
    }
    while (parambpra == null) {
      return;
    }
    a(3, parambpra.jdField_a_of_type_Azkb);
  }
  
  public void a(bprh parambprh)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambprh)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambprh));
    }
    while (parambprh == null) {
      return;
    }
    a(2, parambprh.jdField_a_of_type_Azkb);
  }
  
  public void a(bprl parambprl)
  {
    this.jdField_a_of_type_Bprl = parambprl;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((aocy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<bpra> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseShortVideoOprerator", 2, "multiForwardShortVideo start:" + Thread.currentThread().getId());
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(3, -1, null);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.MultiForwardShortVideoTask(this, paramArrayList));
  }
  
  boolean a(bpqz parambpqz)
  {
    if (parambpqz != null)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambpqz);
      return parambpqz.a();
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bpra parambpra)
  {
    if (parambpra != null)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambpra);
      return parambpra.a();
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bprh parambprh)
  {
    if (parambprh != null)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambprh);
      return parambprh.a();
    }
    azjq.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  void b(bpqz parambpqz)
  {
    long l = System.currentTimeMillis();
    parambpqz.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = parambpqz.jdField_b_of_type_JavaLangString;
    localTransferRequest.mPeerUin = parambpqz.jdField_c_of_type_JavaLangString;
    localTransferRequest.mSecondId = parambpqz.d;
    localTransferRequest.mUinType = parambpqz.jdField_b_of_type_Int;
    localTransferRequest.mUniseq = parambpqz.jdField_a_of_type_Long;
    localTransferRequest.mIsUp = false;
    localTransferRequest.mBusiType = parambpqz.jdField_a_of_type_Int;
    localTransferRequest.mDownMode = parambpqz.f;
    localTransferRequest.mExtraObj = Integer.valueOf(parambpqz.g);
    localTransferRequest.mIsOnlyGetUrl = parambpqz.jdField_a_of_type_Boolean;
    if ((parambpqz.jdField_e_of_type_Int == 1001) || (parambpqz.jdField_e_of_type_Int == 1003) || (parambpqz.jdField_e_of_type_Int == 1005) || (parambpqz.jdField_e_of_type_Int == 1002) || (parambpqz.jdField_e_of_type_Int == 1004) || (parambpqz.jdField_e_of_type_Int == 1006)) {
      localTransferRequest.mMd5 = parambpqz.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bprl != null) {
      localTransferRequest.mDownCallBack = this;
    }
    switch (parambpqz.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bprf != null) && (this.jdField_a_of_type_Bprf.a != null)) {
        localTransferRequest.mRec = this.jdField_a_of_type_Bprf.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambpqz.jdField_e_of_type_Int + "downloadvideo MD5==" + parambpqz.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
      return;
      localTransferRequest.mFileType = 7;
      localTransferRequest.mLocalPath = (parambpqz.i + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 16;
      localTransferRequest.mLocalPath = (parambpqz.i + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 18;
      localTransferRequest.mLocalPath = (parambpqz.i + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 6;
      localTransferRequest.mLocalPath = (parambpqz.h + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 9;
      localTransferRequest.mLocalPath = (parambpqz.h + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 17;
      localTransferRequest.mLocalPath = (parambpqz.h + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambpqz.jdField_c_of_type_Int);
    }
  }
  
  public void onSend(azlb paramazlb)
  {
    if (paramazlb == null)
    {
      a(2, null);
      return;
    }
    if (paramazlb.jdField_a_of_type_Int == 0)
    {
      updateMsg(paramazlb);
      localObject = new bprg();
      ((bprg)localObject).jdField_a_of_type_Int = 0;
      ((bprg)localObject).jdField_a_of_type_JavaLangObject = paramazlb;
      a(2, (bprg)localObject);
      return;
    }
    Object localObject = new azkb();
    ((azkb)localObject).jdField_b_of_type_JavaLangString = paramazlb.jdField_a_of_type_JavaLangString;
    a(2, (azkb)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */