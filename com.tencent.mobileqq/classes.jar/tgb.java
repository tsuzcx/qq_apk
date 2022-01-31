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

public class tgb
  implements Manager
{
  public int a;
  public ArrayList<tfi> a;
  tfn jdField_a_of_type_Tfn = new tfn(QQStoryContext.a(), this);
  tgs jdField_a_of_type_Tgs;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public tgb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static tgb a(QQAppInterface paramQQAppInterface)
  {
    return (tgb)paramQQAppInterface.getManager(251);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 54	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 57	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lauko;
    //   6: invokevirtual 63	auko:createEntityManager	()Laukn;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 68	aukn:a	()Laukp;
    //   14: invokevirtual 72	aukp:a	()V
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
    //   40: invokevirtual 82	aukn:a	(Laukm;Ljava/lang/String;[Ljava/lang/String;)Z
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
    //   86: invokevirtual 102	aukn:b	(Laukm;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 104
    //   95: aload_0
    //   96: invokestatic 109	vzj:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 114	axps:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 68	aukn:a	()Laukp;
    //   106: invokevirtual 116	aukp:b	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 68	aukn:a	()Laukp;
    //   114: invokevirtual 118	aukp:c	()V
    //   117: aload_2
    //   118: invokevirtual 68	aukn:a	()Laukp;
    //   121: invokevirtual 116	aukp:b	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 68	aukn:a	()Laukp;
    //   130: invokevirtual 116	aukp:b	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	135	1	paramBoolean	boolean
    //   9	118	2	localaukn	aukn
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
  
  public static void a(tfi paramtfi, byte[] paramArrayOfByte)
  {
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramtfi.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramtfi.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramtfi.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramtfi.f;
    localaukn.b(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(tfi paramtfi)
  {
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramtfi.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramtfi.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localaukn.a(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramtfi));
  }
  
  public static byte[] a(tfi paramtfi)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramtfi), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramtfi.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramtfi.jdField_a_of_type_Int + ", unionId=" + paramtfi.jdField_a_of_type_JavaLangString);
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
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramtfi.jdField_a_of_type_Int + ", unionId=" + paramtfi.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramtfi.jdField_a_of_type_Int + ", unionId=" + paramtfi.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(tfi paramtfi)
  {
    boolean bool2 = false;
    paramtfi = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramtfi), null, null, null, null, null);
    boolean bool1 = bool2;
    if (paramtfi != null)
    {
      bool1 = bool2;
      if (paramtfi.size() > 0)
      {
        paramtfi = (MsgTabNodeRecommendActivityReadEntity)paramtfi.get(0);
        bool1 = bool2;
        if (paramtfi != null)
        {
          bool1 = bool2;
          if (paramtfi.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void d(tfi paramtfi)
  {
    QQStoryContext.a().a().createEntityManager().b(new MsgTabNodeRecommendActivityReadEntity(paramtfi, 1));
  }
  
  public ArrayList<tfi> a()
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
      tfi localtfi = new tfi();
      if (localtfi.jdField_a_of_type_Int != 12) {
        localtfi.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localtfi);
    }
    Collections.sort(localArrayList, new tfj());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public tfi a()
  {
    List localList = ((tcz)tdc.a(5)).a(false);
    tfi localtfi = new tfi();
    localtfi.jdField_a_of_type_Int = 5;
    localtfi.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localtfi.jdField_b_of_type_Long = QQStoryContext.a().a();
    localtfi.jdField_d_of_type_Int = localList.size();
    localtfi.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localtfi.jdField_b_of_type_Boolean = false;
    localtfi.jdField_b_of_type_Int = localList.size();
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
        str1 = ved.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = ved.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = ved.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        veg.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = ved.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localtfi.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localtfi.h = str1;
        veg.b("VASH", "getUnUploadInfo %s", String.valueOf(localtfi));
        return localtfi;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public tfi a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Tfn.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        tfi localtfi = (tfi)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localtfi.jdField_a_of_type_JavaLangString)) {
          return localtfi;
        }
      }
    }
    return null;
  }
  
  public tfn a()
  {
    return this.jdField_a_of_type_Tfn;
  }
  
  public tgs a()
  {
    if (this.jdField_a_of_type_Tgs == null) {}
    try
    {
      if (this.jdField_a_of_type_Tgs == null) {
        this.jdField_a_of_type_Tgs = new tgs();
      }
      return this.jdField_a_of_type_Tgs;
    }
    finally {}
  }
  
  public void a()
  {
    String str = vyb.a();
    veg.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((tcv)tdc.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      vxs.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().b(paramMsgTabNodeEntity);
  }
  
  public void a(List<tfi> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      tfi localtfi = (tfi)((Iterator)localObject).next();
      if ((localtfi.jdField_a_of_type_Int != 1) && (localtfi.jdField_a_of_type_Int != 2)) {
        paramList.add(localtfi.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public void a(tfi paramtfi)
  {
    paramtfi = paramtfi.a();
    if ((paramtfi.nodeType == 1) || (paramtfi.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramtfi));
  }
  
  public boolean a()
  {
    tfn localtfn = a();
    veg.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localtfn.g), Boolean.valueOf(localtfn.e), Boolean.valueOf(localtfn.f));
    return localtfn.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Tfn.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        tfi localtfi = (tfi)((Iterator)localObject).next();
        if ((localtfi.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localtfi.jdField_a_of_type_JavaLangString))) {
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
      vxs.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localaukn.a(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localaukn.b(paramMsgTabNodeEntity);
  }
  
  public void b(tfi paramtfi)
  {
    paramtfi = paramtfi.a();
    if ((paramtfi.nodeType == 1) || (paramtfi.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramtfi));
  }
  
  public boolean b()
  {
    tfn localtfn = a();
    veg.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localtfn.g), Boolean.valueOf(localtfn.e), Boolean.valueOf(localtfn.f));
    return localtfn.e;
  }
  
  public void c(tfi paramtfi)
  {
    this.jdField_a_of_type_Tfn.a(paramtfi);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(vyb.a(), (String)((tcv)tdc.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      tfn localtfn = a();
      veg.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localtfn.h));
      return localtfn.h;
    }
    veg.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Tfn != null) {
      this.jdField_a_of_type_Tfn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgb
 * JD-Core Version:    0.7.0.1
 */