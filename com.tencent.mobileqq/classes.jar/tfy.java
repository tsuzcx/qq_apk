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

public class tfy
  implements Manager
{
  public int a;
  public ArrayList<tff> a;
  tfk jdField_a_of_type_Tfk = new tfk(QQStoryContext.a(), this);
  tgp jdField_a_of_type_Tgp;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public tfy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static tfy a(QQAppInterface paramQQAppInterface)
  {
    return (tfy)paramQQAppInterface.getManager(251);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 57	com/tencent/biz/qqstory/app/QQStoryContext:a	()Laukq;
    //   6: invokevirtual 63	aukq:createEntityManager	()Laukp;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 68	aukp:a	()Laukr;
    //   14: invokevirtual 72	aukr:a	()V
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
    //   40: invokevirtual 82	aukp:a	(Lauko;Ljava/lang/String;[Ljava/lang/String;)Z
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
    //   86: invokevirtual 102	aukp:b	(Lauko;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 104
    //   95: aload_0
    //   96: invokestatic 109	vzg:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 114	axpu:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 68	aukp:a	()Laukr;
    //   106: invokevirtual 116	aukr:b	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 68	aukp:a	()Laukr;
    //   114: invokevirtual 118	aukr:c	()V
    //   117: aload_2
    //   118: invokevirtual 68	aukp:a	()Laukr;
    //   121: invokevirtual 116	aukr:b	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 68	aukp:a	()Laukr;
    //   130: invokevirtual 116	aukr:b	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	135	1	paramBoolean	boolean
    //   9	118	2	localaukp	aukp
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
  
  public static void a(tff paramtff, byte[] paramArrayOfByte)
  {
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramtff.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramtff.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramtff.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramtff.f;
    localaukp.b(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(tff paramtff)
  {
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramtff.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramtff.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localaukp.a(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramtff));
  }
  
  public static byte[] a(tff paramtff)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramtff), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramtff.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramtff.jdField_a_of_type_Int + ", unionId=" + paramtff.jdField_a_of_type_JavaLangString);
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
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramtff.jdField_a_of_type_Int + ", unionId=" + paramtff.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramtff.jdField_a_of_type_Int + ", unionId=" + paramtff.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(tff paramtff)
  {
    boolean bool2 = false;
    paramtff = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramtff), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramtff != null)
    {
      bool1 = bool2;
      if (paramtff.size() > 0)
      {
        paramtff = (MsgTabNodeRecommendActivityReadEntity)paramtff.get(0);
        bool1 = bool2;
        if (paramtff != null)
        {
          bool1 = bool2;
          if (paramtff.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(tff paramtff)
  {
    QQStoryContext.a().a().createEntityManager().b(new MsgTabNodeRecommendActivityReadEntity(paramtff, 1));
  }
  
  public ArrayList<tff> a()
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
      tff localtff = new tff();
      if (localtff.jdField_a_of_type_Int != 12) {
        localtff.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localtff);
    }
    Collections.sort(localArrayList, new tfg());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public tff a()
  {
    List localList = ((tcw)tcz.a(5)).a(false);
    tff localtff = new tff();
    localtff.jdField_a_of_type_Int = 5;
    localtff.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localtff.jdField_b_of_type_Long = QQStoryContext.a().a();
    localtff.jdField_d_of_type_Int = localList.size();
    localtff.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localtff.jdField_b_of_type_Boolean = false;
    localtff.jdField_b_of_type_Int = localList.size();
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
        str1 = vea.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = vea.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = vea.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        ved.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = vea.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localtff.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localtff.h = str1;
        ved.b("VASH", "getUnUploadInfo %s", String.valueOf(localtff));
        return localtff;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public tff a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Tfk.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        tff localtff = (tff)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localtff.jdField_a_of_type_JavaLangString)) {
          return localtff;
        }
      }
    }
    return null;
  }
  
  public tfk a()
  {
    return this.jdField_a_of_type_Tfk;
  }
  
  public tgp a()
  {
    if (this.jdField_a_of_type_Tgp == null) {}
    try
    {
      if (this.jdField_a_of_type_Tgp == null) {
        this.jdField_a_of_type_Tgp = new tgp();
      }
      return this.jdField_a_of_type_Tgp;
    }
    finally {}
  }
  
  public void a()
  {
    String str = vxy.a();
    ved.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((tcs)tcz.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().b(paramMsgTabNodeEntity);
  }
  
  public void a(List<tff> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      tff localtff = (tff)((Iterator)localObject).next();
      if ((localtff.jdField_a_of_type_Int != 1) && (localtff.jdField_a_of_type_Int != 2)) {
        paramList.add(localtff.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(tff paramtff)
  {
    paramtff = paramtff.a();
    if ((paramtff.nodeType == 1) || (paramtff.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramtff));
  }
  
  public boolean a()
  {
    tfk localtfk = a();
    ved.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localtfk.g), Boolean.valueOf(localtfk.e), Boolean.valueOf(localtfk.f));
    return localtfk.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Tfk.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        tff localtff = (tff)((Iterator)localObject).next();
        if ((localtff.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localtff.jdField_a_of_type_JavaLangString))) {
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
      vxp.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localaukp.a(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localaukp.b(paramMsgTabNodeEntity);
  }
  
  public void b(tff paramtff)
  {
    paramtff = paramtff.a();
    if ((paramtff.nodeType == 1) || (paramtff.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramtff));
  }
  
  public boolean b()
  {
    tfk localtfk = a();
    ved.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localtfk.g), Boolean.valueOf(localtfk.e), Boolean.valueOf(localtfk.f));
    return localtfk.e;
  }
  
  public void c(tff paramtff)
  {
    this.jdField_a_of_type_Tfk.a(paramtff);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(vxy.a(), (String)((tcs)tcz.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      tfk localtfk = a();
      ved.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localtfk.h));
      return localtfk.h;
    }
    ved.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Tfk != null) {
      this.jdField_a_of_type_Tfk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfy
 * JD-Core Version:    0.7.0.1
 */