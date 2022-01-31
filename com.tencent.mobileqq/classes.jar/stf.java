import android.os.Looper;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager.1;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager.2;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class stf
  implements Manager
{
  public int a;
  public ArrayList<ssm> a;
  ssr jdField_a_of_type_Ssr = new ssr(QQStoryContext.a(), this);
  stw jdField_a_of_type_Stw;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public stf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static stf a(QQAppInterface paramQQAppInterface)
  {
    return (stf)paramQQAppInterface.getManager(251);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 57	com/tencent/biz/qqstory/app/QQStoryContext:a	()Latmq;
    //   6: invokevirtual 63	atmq:createEntityManager	()Latmp;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 68	atmp:a	()Latmr;
    //   14: invokevirtual 72	atmr:a	()V
    //   17: iload_1
    //   18: ifeq +26 -> 44
    //   21: new 74	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 75	com/tencent/biz/qqstory/database/MsgTabNodeEntity:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: sipush 1001
    //   33: invokevirtual 79	com/tencent/biz/qqstory/database/MsgTabNodeEntity:setStatus	(I)V
    //   36: aload_2
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 82	atmp:a	(Latmo;Ljava/lang/String;[Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 86	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 92 1 0
    //   55: ifeq +55 -> 110
    //   58: aload_0
    //   59: invokeinterface 96 1 0
    //   64: checkcast 74	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 99	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   72: iconst_1
    //   73: if_icmpeq -24 -> 49
    //   76: aload_3
    //   77: getfield 99	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   80: iconst_2
    //   81: if_icmpeq -32 -> 49
    //   84: aload_2
    //   85: aload_3
    //   86: invokevirtual 102	atmp:b	(Latmo;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 104
    //   95: aload_0
    //   96: invokestatic 109	vmn:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 114	awpu:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 68	atmp:a	()Latmr;
    //   106: invokevirtual 116	atmr:b	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 68	atmp:a	()Latmr;
    //   114: invokevirtual 118	atmr:c	()V
    //   117: aload_2
    //   118: invokevirtual 68	atmp:a	()Latmr;
    //   121: invokevirtual 116	atmr:b	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 68	atmp:a	()Latmr;
    //   130: invokevirtual 116	atmr:b	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	135	1	paramBoolean	boolean
    //   9	118	2	localatmp	atmp
    //   28	58	3	localMsgTabNodeEntity	MsgTabNodeEntity
    // Exception table:
    //   from	to	target	type
    //   21	44	92	java/lang/NullPointerException
    //   44	49	92	java/lang/NullPointerException
    //   49	89	92	java/lang/NullPointerException
    //   110	117	92	java/lang/NullPointerException
    //   21	44	125	finally
    //   44	49	125	finally
    //   49	89	125	finally
    //   93	102	125	finally
    //   110	117	125	finally
  }
  
  public static void a(ssm paramssm, byte[] paramArrayOfByte)
  {
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramssm.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramssm.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramssm.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramssm.f;
    localatmp.b(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(ssm paramssm)
  {
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramssm.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramssm.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localatmp.a(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramssm));
  }
  
  public static byte[] a(ssm paramssm)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramssm), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramssm.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramssm.jdField_a_of_type_Int + ", unionId=" + paramssm.jdField_a_of_type_JavaLangString);
        }
        arrayOfByte = ((MsgTabNodeVidListEntity)localObject).rspData;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return arrayOfByte;
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramssm.jdField_a_of_type_Int + ", unionId=" + paramssm.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramssm.jdField_a_of_type_Int + ", unionId=" + paramssm.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(ssm paramssm)
  {
    boolean bool2 = false;
    paramssm = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramssm), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramssm != null)
    {
      bool1 = bool2;
      if (paramssm.size() > 0)
      {
        paramssm = (MsgTabNodeRecommendActivityReadEntity)paramssm.get(0);
        bool1 = bool2;
        if (paramssm != null)
        {
          bool1 = bool2;
          if (paramssm.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(ssm paramssm)
  {
    QQStoryContext.a().a().createEntityManager().b(new MsgTabNodeRecommendActivityReadEntity(paramssm, 1));
  }
  
  public ArrayList<ssm> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeEntity.class);
    if (localObject == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeEntity localMsgTabNodeEntity = (MsgTabNodeEntity)((Iterator)localObject).next();
      ssm localssm = new ssm();
      if (localssm.jdField_a_of_type_Int != 12) {
        localssm.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localssm);
    }
    Collections.sort(localArrayList, new ssn());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public ssm a()
  {
    List localList = ((sqd)sqg.a(5)).a(false);
    ssm localssm = new ssm();
    localssm.jdField_a_of_type_Int = 5;
    localssm.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localssm.jdField_b_of_type_Long = QQStoryContext.a().a();
    localssm.jdField_d_of_type_Int = localList.size();
    localssm.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localssm.jdField_b_of_type_Boolean = false;
    localssm.jdField_b_of_type_Int = localList.size();
    int i = 0;
    String str2 = "";
    boolean bool = false;
    String str1 = "";
    StoryVideoItem localStoryVideoItem;
    if (i < localList.size())
    {
      localStoryVideoItem = (StoryVideoItem)localList.get(i);
      if (!localStoryVideoItem.isUploading()) {
        break label288;
      }
      bool = true;
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        str1 = urh.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = urh.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = urh.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        urk.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = urh.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localssm.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localssm.h = str1;
        urk.b("VASH", "getUnUploadInfo %s", String.valueOf(localssm));
        return localssm;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public ssm a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Ssr.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ssm localssm = (ssm)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localssm.jdField_a_of_type_JavaLangString)) {
          return localssm;
        }
      }
    }
    return null;
  }
  
  public ssr a()
  {
    return this.jdField_a_of_type_Ssr;
  }
  
  public stw a()
  {
    if (this.jdField_a_of_type_Stw == null) {}
    try
    {
      if (this.jdField_a_of_type_Stw == null) {
        this.jdField_a_of_type_Stw = new stw();
      }
      return this.jdField_a_of_type_Stw;
    }
    finally {}
  }
  
  public void a()
  {
    String str = vlf.a();
    urk.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((spz)sqg.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      vkw.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().b(paramMsgTabNodeEntity);
  }
  
  public void a(List<ssm> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ssm localssm = (ssm)((Iterator)localObject).next();
      if ((localssm.jdField_a_of_type_Int != 1) && (localssm.jdField_a_of_type_Int != 2)) {
        paramList.add(localssm.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(ssm paramssm)
  {
    paramssm = paramssm.a();
    if ((paramssm.nodeType == 1) || (paramssm.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramssm));
  }
  
  public boolean a()
  {
    ssr localssr = a();
    urk.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localssr.g), Boolean.valueOf(localssr.e), Boolean.valueOf(localssr.f));
    return localssr.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Ssr.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ssm localssm = (ssm)((Iterator)localObject).next();
        if ((localssm.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localssm.jdField_a_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      vkw.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localatmp.a(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localatmp.b(paramMsgTabNodeEntity);
  }
  
  public void b(ssm paramssm)
  {
    paramssm = paramssm.a();
    if ((paramssm.nodeType == 1) || (paramssm.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramssm));
  }
  
  public boolean b()
  {
    ssr localssr = a();
    urk.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localssr.g), Boolean.valueOf(localssr.e), Boolean.valueOf(localssr.f));
    return localssr.e;
  }
  
  public void c(ssm paramssm)
  {
    this.jdField_a_of_type_Ssr.a(paramssm);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(vlf.a(), (String)((spz)sqg.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      ssr localssr = a();
      urk.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localssr.h));
      return localssr.h;
    }
    urk.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Ssr != null) {
      this.jdField_a_of_type_Ssr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stf
 * JD-Core Version:    0.7.0.1
 */