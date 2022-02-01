import com.tencent.biz.addContactTroopView.AddContactTroopManage.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class nlh
  implements Manager
{
  protected AppInterface a;
  protected final String a;
  public troopviewInfo.RspBody a;
  
  public nlh(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "AddContactTroopManage";
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(troopviewInfo.RspBody paramRspBody)
  {
    ThreadManager.post(new AddContactTroopManage.1(this, paramRspBody), 8, null, false);
  }
  
  private boolean a(troopviewInfo.RspBody paramRspBody)
  {
    if ((paramRspBody == null) || (!paramRspBody.has())) {
      return false;
    }
    return bhmi.a(new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir(), "AddContactTroopManage" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getAbsolutePath(), paramRspBody.toByteArray(), false);
  }
  
  /* Error */
  private troopviewInfo.RspBody b()
  {
    // Byte code:
    //   0: new 46	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 21	nlh:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   8: invokevirtual 52	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11: invokevirtual 58	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   14: new 60	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   21: ldc 17
    //   23: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 21	nlh:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   30: invokevirtual 69	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   33: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: invokestatic 96	bhmi:a	(Ljava/io/File;)[B
    //   45: astore_2
    //   46: new 40	tencent/im/troop_view/troopviewInfo$RspBody
    //   49: dup
    //   50: invokespecial 97	tencent/im/troop_view/troopviewInfo$RspBody:<init>	()V
    //   53: astore_1
    //   54: aload_2
    //   55: ifnull +9 -> 64
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 101	tencent/im/troop_view/troopviewInfo$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   63: pop
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_2
    //   70: invokevirtual 104	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   73: aload_1
    //   74: areturn
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 105	java/lang/NullPointerException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_2
    //   85: goto -7 -> 78
    //   88: astore_2
    //   89: goto -20 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	nlh
    //   53	30	1	localRspBody	troopviewInfo.RspBody
    //   45	15	2	arrayOfByte	byte[]
    //   66	4	2	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   75	4	2	localNullPointerException1	java.lang.NullPointerException
    //   84	1	2	localNullPointerException2	java.lang.NullPointerException
    //   88	1	2	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   0	54	66	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   0	54	75	java/lang/NullPointerException
    //   58	64	84	java/lang/NullPointerException
    //   58	64	88	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public popclassifc.PopHotWordCard a()
  {
    troopviewInfo.RspBody localRspBody = a();
    popclassifc.PopHotWordCard localPopHotWordCard = null;
    if (localRspBody != null) {
      localPopHotWordCard = (popclassifc.PopHotWordCard)((popclassifc.RspBody)((popclassifc.RspBody)localRspBody.popRsb.get()).get()).pop_hotword.get();
    }
    return localPopHotWordCard;
  }
  
  public troopviewInfo.RspBody a()
  {
    try
    {
      if (this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody == null) {
        this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody = b();
      }
      if (this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody == null) {
        this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody = new troopviewInfo.RspBody();
      }
      troopviewInfo.RspBody localRspBody = this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody;
      return localRspBody;
    }
    finally {}
  }
  
  public void a(popclassifc.RspBody paramRspBody)
  {
    try
    {
      troopviewInfo.RspBody localRspBody = a();
      localRspBody.popRsb = new popclassifc.RspBody();
      localRspBody.popRsb.set(paramRspBody);
      a(localRspBody);
      return;
    }
    finally
    {
      paramRspBody = finally;
      throw paramRspBody;
    }
  }
  
  public void a(searchtab.RspBody paramRspBody)
  {
    try
    {
      troopviewInfo.RspBody localRspBody = a();
      localRspBody.searchRsb = new searchtab.RspBody();
      localRspBody.searchRsb.set(paramRspBody);
      a(localRspBody);
      return;
    }
    finally
    {
      paramRspBody = finally;
      throw paramRspBody;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlh
 * JD-Core Version:    0.7.0.1
 */