import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.10;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.11;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.12;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.13;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.14;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.15;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.16;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.5;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.6;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.7;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.8;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public class tfk
{
  protected static Comparator<tff> a;
  protected static Comparator<tff> b;
  protected Handler a;
  protected HandlerThread a;
  protected final Object a;
  protected String a;
  protected volatile ArrayList<tff> a;
  protected HashMap<String, Boolean> a;
  protected Set<String> a;
  protected ConcurrentHashMap<String, QQUserUIItem> a;
  protected AtomicBoolean a;
  protected syq<tgj, tgk> a;
  protected tfy a;
  private tkj a;
  protected boolean a;
  protected Handler b;
  protected String b;
  protected volatile ArrayList<tff> b;
  boolean b;
  protected ArrayList<qqstory_service.MsgTabNodePushNotify> c;
  boolean c;
  public final ArrayList<tfr> d;
  boolean d;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new tfg();
    jdField_b_of_type_JavaUtilComparator = new tfh();
  }
  
  tfk(QQAppInterface paramQQAppInterface, tfy paramtfy)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new ArraySet());
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandlerThread = ((HandlerThread)ThreadManagerV2.getRecentThread());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Tkj = new tfl(this);
    this.jdField_a_of_type_Syq = new tfn(this);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListLoader ctor()");
    if (paramQQAppInterface == null) {
      ved.c("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.jdField_a_of_type_Tfy = paramtfy;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Tfy.a();
    a(this.jdField_a_of_type_JavaUtilArrayList, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_AndroidOsHandler = new tfq(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "create new loader");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramQQAppInterface = (tff)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = 0;
      while (j < paramQQAppInterface.jdField_a_of_type_JavaUtilList.size())
      {
        paramtfy = (tfx)paramQQAppInterface.jdField_a_of_type_JavaUtilList.get(j);
        String str = paramQQAppInterface.jdField_a_of_type_JavaLangString + "-" + paramtfy.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(paramtfy.jdField_a_of_type_Boolean));
        j += 1;
      }
      i += 1;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.5(this));
  }
  
  private void a(ArrayList<tff> paramArrayList) {}
  
  private static void a(ArrayList<tff> paramArrayList, boolean paramBoolean)
  {
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() listSize=%d, sortOriginList=%b", Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean));
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      tff localtff = (tff)((Iterator)localObject).next();
      if (localtff.jdField_c_of_type_Int > 0)
      {
        localArrayList.add(localtff);
        ((Iterator)localObject).remove();
      }
    }
    if (paramBoolean) {
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
    }
    int i;
    if (localArrayList.size() > 0)
    {
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, jdField_b_of_type_JavaUtilComparator);
      i = 0;
      if (i >= paramArrayList.size()) {
        break label297;
      }
      localObject = (tff)paramArrayList.get(i);
      if ((((tff)localObject).jdField_a_of_type_Int != 1) && (((tff)localObject).jdField_a_of_type_Int != 4) && (((tff)localObject).jdField_a_of_type_Int != 3)) {
        ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i));
      }
    }
    for (;;)
    {
      if (i == -1) {
        i = paramArrayList.size();
      }
      for (;;)
      {
        int j = 0;
        label196:
        if (j < localArrayList.size())
        {
          localObject = (tff)localArrayList.get(j);
          if (((tff)localObject).jdField_c_of_type_Int > 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            vxp.a(paramBoolean, "position must be greater than 0");
            int k = Math.min(((tff)localObject).jdField_c_of_type_Int + i - 1, paramArrayList.size());
            paramArrayList.add(k, localObject);
            ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(k));
            j += 1;
            break label196;
            i += 1;
            break;
          }
        }
        return;
      }
      label297:
      i = -1;
    }
  }
  
  private boolean a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify, boolean paramBoolean)
  {
    if (paramMsgTabNodePushNotify == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "realHandlePushMsg, msg is null!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", vyp.a(paramMsgTabNodePushNotify) });
    }
    tff localtff = new tff();
    localtff.a((qqstory_service.MsgTabNodeInfo)paramMsgTabNodePushNotify.msg_notify_node_info.get());
    String str = paramMsgTabNodePushNotify.bytes_current_seq.get().toStringUtf8();
    int i = paramMsgTabNodePushNotify.uint32_notify_type.get();
    boolean bool1;
    label168:
    int j;
    if (paramMsgTabNodePushNotify.uint32_animate.get() == 1)
    {
      bool1 = true;
      if (i != 1) {
        break label476;
      }
      if (localtff.jdField_a_of_type_Int == 5)
      {
        paramMsgTabNodePushNotify = this.jdField_a_of_type_Tfy.a();
        if (paramMsgTabNodePushNotify.jdField_d_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localtff);
          if (i == -1) {
            break label329;
          }
          localtff.a((tff)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if ((localtff.jdField_a_of_type_Int != 7) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localtff) != -1)) {
        break label345;
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label345;
      }
      paramMsgTabNodePushNotify = (tff)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((paramMsgTabNodePushNotify.jdField_a_of_type_Int == 9) && (TextUtils.equals(localtff.jdField_a_of_type_JavaLangString, paramMsgTabNodePushNotify.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, localtff);
        this.jdField_a_of_type_Tfy.b(paramMsgTabNodePushNotify);
        this.jdField_a_of_type_Tfy.a(localtff);
        if (paramBoolean)
        {
          a(paramMsgTabNodePushNotify, true, 3, bool1);
          a(localtff, true, 1, bool1);
        }
        vei.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localtff.jdField_a_of_type_Int) });
        return true;
        bool1 = false;
        break;
        label329:
        localtff.a(paramMsgTabNodePushNotify);
        break label168;
      }
      i += 1;
    }
    label345:
    c(localtff);
    boolean bool2 = b(localtff);
    c(Collections.singletonList(localtff));
    b(Collections.singletonList(localtff));
    if (bool2)
    {
      this.jdField_a_of_type_Tfy.a(localtff);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaLangString = str;
      if (paramBoolean) {
        a(localtff, true, 1, bool1);
      }
      vei.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localtff.jdField_a_of_type_Int) });
    }
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localtff);
    paramBoolean = bool2;
    for (;;)
    {
      return paramBoolean;
      label476:
      if (i == 2)
      {
        bool2 = c(localtff);
        if (bool2)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_Tfy.b(localtff);
          this.jdField_b_of_type_JavaLangString = str;
          if (paramBoolean) {
            a(localtff, true, 3, bool1);
          }
        }
        ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localtff);
        paramBoolean = bool2;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public static boolean a(List<tff> paramList1, List<tff> paramList2)
  {
    boolean bool2 = false;
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    if (i < paramList1.size())
    {
      localObject1 = ((tff)paramList1.get(i)).jdField_a_of_type_JavaLangString;
      if (((tff)paramList1.get(i)).jdField_a_of_type_Int == 12) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((tff)paramList1.get(i)).jdField_a_of_type_JavaUtilList;
        j = 0;
        while (j < ((List)localObject2).size())
        {
          tfx localtfx = (tfx)((List)localObject2).get(j);
          if (!localtfx.jdField_a_of_type_Boolean) {
            localHashSet.add((String)localObject1 + "-" + localtfx.jdField_a_of_type_Long);
          }
          j += 1;
        }
      }
    }
    i = 0;
    boolean bool1 = bool2;
    if (i < paramList2.size())
    {
      paramList1 = ((tff)paramList2.get(i)).jdField_a_of_type_JavaLangString;
      if (((tff)paramList2.get(i)).jdField_a_of_type_Int != 12) {}
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = ((tff)paramList2.get(i)).jdField_a_of_type_JavaUtilList;
      j = 0;
      while (j < ((List)localObject1).size())
      {
        localObject2 = (tfx)((List)localObject1).get(j);
        if ((!((tfx)localObject2).jdField_a_of_type_Boolean) && (!localHashSet.contains(paramList1 + "-" + ((tfx)localObject2).jdField_a_of_type_Long)))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
    }
  }
  
  private boolean a(List<String> paramList, boolean paramBoolean)
  {
    if (paramList.isEmpty())
    {
      ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    tdl localtdl = (tdl)tcz.a(2);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = localtdl.b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList.add(new teg("", str));
      }
      for (;;)
      {
        i += 1;
        break;
        a(localQQUserUIItem);
        bool = true;
      }
    }
    if (!localArrayList.isEmpty()) {
      if (paramBoolean)
      {
        new tki(this.jdField_a_of_type_Tkj).a(1, localArrayList);
        ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() Will fetch %s users", localArrayList);
      }
    }
    for (;;)
    {
      return bool;
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() miss %s users, did not find in db, won't request", localArrayList);
      continue;
      ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() All nodes has local cache, no need request");
    }
  }
  
  @WorkerThread
  private void b(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    if (ved.a()) {
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "onHandlePushMsg %s", vyp.a(paramMsgTabNodePushNotify));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramMsgTabNodePushNotify);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "refreshing, add to waiting queue");
      }
      return;
    }
    a(paramMsgTabNodePushNotify, true);
  }
  
  private void b(List<tff> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int k;
    tff localtff;
    for (int j = 0;; j = k)
    {
      if ((j < paramList.size()) && (i < 8))
      {
        k = j + 1;
        localtff = (tff)paramList.get(j);
        if (localtff.jdField_b_of_type_Int == 0) {
          ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(j));
        }
      }
      else
      {
        label75:
        a(localArrayList2);
        if (!localArrayList1.isEmpty()) {
          break label287;
        }
        ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest is empty");
        return;
      }
      if ((localtff.jdField_a_of_type_Int == 6) || (localtff.jdField_a_of_type_Int == 9) || (localtff.jdField_a_of_type_Int == 7) || (localtff.jdField_a_of_type_Int == 5)) {
        break;
      }
    }
    Iterator localIterator = localtff.jdField_a_of_type_JavaUtilList.iterator();
    label155:
    tfx localtfx;
    if (localIterator.hasNext())
    {
      localtfx = (tfx)localIterator.next();
      if (TextUtils.isEmpty(localtfx.jdField_a_of_type_JavaLangString))
      {
        localArrayList1.add(localtff);
        i += 1;
        ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(k));
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(k));
        break label75;
        if (localtfx.jdField_a_of_type_Boolean) {
          break label155;
        }
        localArrayList2.add(localtfx.jdField_a_of_type_JavaLangString);
        i += 1;
        ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(k), localtfx.jdField_a_of_type_JavaLangString);
        j = 1;
        continue;
      }
      j = k;
      break;
      label287:
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest load vidlist size=%d", Integer.valueOf(localArrayList1.size()));
      Stream.fromIterator(localArrayList1.iterator()).map(new tfp(this)).map(new tfv("MsgTabPreloader")).subscribe(new tfo(this));
      return;
      j = 0;
    }
  }
  
  private boolean b(tff paramtff)
  {
    boolean bool;
    int i;
    int j;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread)
    {
      bool = true;
      vxp.a(bool);
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramtff);
      if (i != -1)
      {
        tff localtff = (tff)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramtff.jdField_c_of_type_Long < localtff.jdField_c_of_type_Long) {
          break label127;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramtff);
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label136;
      }
      if (jdField_a_of_type_JavaUtilComparator.compare(paramtff, this.jdField_a_of_type_JavaUtilArrayList.get(i)) <= 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(i, paramtff);
        a(this.jdField_a_of_type_JavaUtilArrayList, false);
        return true;
        bool = false;
        break;
        label127:
        return false;
      }
      i += 1;
    }
    label136:
    this.jdField_a_of_type_JavaUtilArrayList.add(paramtff);
    a(this.jdField_a_of_type_JavaUtilArrayList, false);
    return true;
  }
  
  @WorkerThread
  private void c()
  {
    ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    Object localObject = this.jdField_a_of_type_Tfy.a();
    if (((tff)localObject).jdField_d_of_type_Int > 0)
    {
      tff localtff = a(((tff)localObject).jdField_a_of_type_Int, ((tff)localObject).jdField_a_of_type_JavaLangString);
      if (localtff == null) {
        break label54;
      }
      localtff.a((tff)localObject);
      localObject = localtff;
    }
    label54:
    for (;;)
    {
      a((tff)localObject, false);
      return;
    }
  }
  
  private void c(List<tff> paramList)
  {
    tdl localtdl = (tdl)tcz.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (tff)paramList.get(i);
      if ((((tff)localObject).jdField_a_of_type_Int == 12) || (((tff)localObject).jdField_a_of_type_Int == 10) || (((tff)localObject).jdField_a_of_type_Int == 11) || (((tff)localObject).jdField_a_of_type_Int == 13)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((tff)localObject).jdField_a_of_type_JavaLangString;
        QQUserUIItem localQQUserUIItem = localtdl.b((String)localObject);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          localArrayList.add(new teg("", (String)localObject));
        } else {
          a(localQQUserUIItem);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      new tki(this.jdField_a_of_type_Tkj).a(1, localArrayList);
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private void c(tff paramtff)
  {
    int i = paramtff.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < paramtff.jdField_a_of_type_JavaUtilList.size())
    {
      tfx localtfx = (tfx)paramtff.jdField_a_of_type_JavaUtilList.get(j);
      Object localObject = paramtff.jdField_a_of_type_JavaLangString + "-" + localtfx.jdField_a_of_type_Long;
      localObject = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localtfx.jdField_a_of_type_Boolean = true;
      }
      if (!localtfx.jdField_a_of_type_Boolean) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      j += 1;
      break;
      paramtff.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  private boolean c(tff paramtff)
  {
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool);
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramtff);
      if (i == -1) {
        break;
      }
      tff localtff = (tff)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramtff.jdField_c_of_type_Long >= localtff.jdField_c_of_type_Long) {
        break;
      }
      return false;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.remove(paramtff);
  }
  
  public ArrayList<tff> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public tff a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    if (paramInt == -1)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      tff localtff;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localtff = (tff)localIterator.next();
      } while (!TextUtils.equals(localtff.jdField_a_of_type_JavaLangString, paramString));
      return localtff;
    }
    paramString = new tff(paramInt, paramString);
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    if (paramInt != -1) {
      return (tff)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public tff a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      tff localtff = (tff)localIterator.next();
      if (TextUtils.equals(paramString, localtff.jdField_a_of_type_JavaLangString)) {
        return localtff;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestLatestPage() is loading, ignore this request...");
      }
    }
    tgj localtgj;
    do
    {
      return;
      localtgj = new tgj();
      localtgj.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localtgj.jdField_c_of_type_Int = paramInt;
      tcs localtcs = (tcs)tcz.a(10);
      boolean bool = ((Boolean)localtcs.b("key_force_refresh_msg_node_list", Boolean.valueOf(false))).booleanValue();
      if (bool) {
        localtcs.b("key_force_refresh_msg_node_list", Boolean.valueOf(false));
      }
      localtgj.jdField_a_of_type_Boolean = bool;
      syo.a().a(localtgj, this.jdField_a_of_type_Syq);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", localtgj.toString() });
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null)
    {
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal is null!", new Object[0]);
      return;
    }
    if ((TextUtils.isEmpty(paramQQUserUIItem.uid)) || (!paramQQUserUIItem.isAvailable()))
    {
      ved.d("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQUserUIItem.uid, paramQQUserUIItem);
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    boolean bool = uyp.a();
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 1) && (!bool))
    {
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is not in testEnv", vyp.a(paramMsgTabNodePushNotify));
      return;
    }
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 0) && (bool))
    {
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is in testEnv", vyp.a(paramMsgTabNodePushNotify));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.6(this, paramMsgTabNodePushNotify));
  }
  
  public void a(String paramString)
  {
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "scheduleRequireUserItem() %s", paramString);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, paramString).sendToTarget();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.12(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new tha(paramString1, paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide request = " + paramString1.toString());
    }
    syo.a().a(paramString1, new tfm(this));
  }
  
  protected void a(ArrayList<tff> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() dataList=%s, isFirstPage=%b, isEnd=%b, push=%b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3));
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.10(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
    }
    for (;;)
    {
      return;
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      tcw localtcw = (tcw)tcz.a(5);
      int i = 0;
      while (i < paramList.size())
      {
        localtcw.b((String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public void a(svv paramsvv)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramsvv.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramsvv) });
      }
      Object localObject3 = this.jdField_a_of_type_Tfy.a();
      localObject2 = a(((tff)localObject3).jdField_a_of_type_Int, ((tff)localObject3).jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new tff(((tff)localObject3).jdField_a_of_type_Int, ((tff)localObject3).jdField_a_of_type_JavaLangString);
        ((tff)localObject1).jdField_b_of_type_Long = QQStoryContext.a().a();
        a((tff)localObject1, false);
      }
      int j = ((tff)localObject1).a();
      int k = ((tff)localObject3).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(j), "\tnewUploadStatus: ", Integer.valueOf(k) });
      }
      ((tff)localObject1).a((tff)localObject3);
      if (paramsvv.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
        break label544;
      }
      paramsvv = paramsvv.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      if (!paramsvv.isUploadSuc()) {
        break label584;
      }
      localObject2 = new tfx();
      ((tfx)localObject2).jdField_a_of_type_Boolean = false;
      ((tfx)localObject2).jdField_a_of_type_Long = paramsvv.mVideoIndex;
      if (((tfx)localObject2).jdField_a_of_type_Long == 0L) {
        ((tfx)localObject2).jdField_a_of_type_Long = paramsvv.mCreateTime;
      }
      if (((tff)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localObject2) == -1) {
        break label552;
      }
      i = 1;
      label339:
      if (i != 0) {
        break label557;
      }
      ((tff)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
      ((tff)localObject1).jdField_b_of_type_Int += 1;
      ((tff)localObject1).g = paramsvv.getThumbUrl();
      ((tff)localObject1).jdField_d_of_type_Long = (paramsvv.mCreateTime / 1000L);
      if (((tff)localObject1).jdField_b_of_type_JavaUtilList == null) {
        ((tff)localObject1).jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      localObject3 = new tso();
      ((tso)localObject3).jdField_a_of_type_JavaLangString = paramsvv.mAttachedFeedId;
      ((tso)localObject3).jdField_b_of_type_JavaLangString = paramsvv.mVid;
      ((tso)localObject3).jdField_a_of_type_Long = paramsvv.mVideoIndex;
      ((tso)localObject3).jdField_a_of_type_Boolean = false;
      ((tso)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramsvv;
      ((tff)localObject1).jdField_b_of_type_JavaUtilList.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((tff)localObject1).jdField_a_of_type_JavaUtilList });
      }
      i = 1;
      label526:
      if (j != k) {
        break label589;
      }
    }
    for (;;)
    {
      if (i != 0) {
        a((tff)localObject1, true);
      }
      return;
      label544:
      paramsvv = paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      break;
      label552:
      i = 0;
      break label339;
      label557:
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , but exist!!! videoInfo=", localObject2 });
      }
      label584:
      i = 0;
      break label526;
      label589:
      i = 1;
    }
  }
  
  public void a(tce paramtce)
  {
    if (!paramtce.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "delete video event, event=", paramtce });
    }
    if (paramtce.jdField_a_of_type_Boolean)
    {
      paramtce = this.jdField_a_of_type_Tfy.a();
      localObject = a(paramtce.jdField_a_of_type_Int, paramtce.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        ((tff)localObject).a(paramtce);
        paramtce = (tce)localObject;
      }
      for (;;)
      {
        a(paramtce, true);
        return;
      }
    }
    int i;
    if (!TextUtils.isEmpty(paramtce.c))
    {
      i = 8;
      if (TextUtils.isEmpty(paramtce.c)) {
        break label145;
      }
    }
    label145:
    for (Object localObject = paramtce.c;; localObject = paramtce.jdField_b_of_type_JavaLangString)
    {
      a(i, (String)localObject, paramtce.jdField_a_of_type_Long);
      a(i, paramtce.jdField_b_of_type_JavaLangString, paramtce.c);
      return;
      i = 5;
      break;
    }
  }
  
  public void a(tff paramtff)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      tff localtff = (tff)localIterator.next();
      if ((localtff.jdField_a_of_type_Int == 13) && (TextUtils.equals(localtff.jdField_a_of_type_JavaLangString, paramtff.jdField_a_of_type_JavaLangString))) {
        paramtff.jdField_d_of_type_Boolean = localtff.jdField_d_of_type_Boolean;
      }
    }
  }
  
  public void a(tff paramtff, boolean paramBoolean)
  {
    int i = 1;
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramtff), Boolean.valueOf(paramBoolean));
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramtff);
    boolean bool;
    if (b(paramtff))
    {
      this.jdField_a_of_type_Tfy.a(paramtff);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramtff);
      if (j == k) {
        break label156;
      }
      bool = true;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "insertNode: hasChangePos=", Boolean.valueOf(bool), ", oldIndex=", Integer.valueOf(j), ", newIndex=", Integer.valueOf(k) });
      }
      if (paramBoolean) {
        if (!bool) {
          break label162;
        }
      }
    }
    for (;;)
    {
      a(paramtff, false, i, false);
      return;
      label156:
      bool = false;
      break;
      label162:
      i = 2;
    }
  }
  
  protected void a(tff paramtff, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(paramtff), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i;
    if (paramInt == 1)
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramtff);
      i = j;
      if (j == -1) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 1, "insert position not found:" + paramtff);
      }
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.11(this, paramtff, paramBoolean1, paramInt, i, paramBoolean2));
  }
  
  public void a(tfr paramtfr)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (this.jdField_d_of_type_JavaUtilArrayList.contains(paramtfr))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramtfr.getClass().getSimpleName() });
      }
      this.jdField_d_of_type_JavaUtilArrayList.add(paramtfr);
      return;
    }
  }
  
  @WorkerThread
  public void a(@NonNull tgj paramtgj, @Nullable tgk paramtgk, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool;
    if (((paramErrorMessage.errorCode != 0) && (paramErrorMessage.errorCode != 15000) && (paramErrorMessage.errorCode != 15001)) || (paramtgk == null))
    {
      ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() get latest failed: %s", paramErrorMessage.getErrorMessage());
      a(false);
      bool = a();
      a(this.jdField_a_of_type_JavaUtilArrayList, true);
      if (bool)
      {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, true);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    a(true);
    this.h = paramtgk.jdField_a_of_type_Boolean;
    if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramtgk.jdField_a_of_type_JavaLangString))
    {
      ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      if (paramErrorMessage.errorCode == 15001)
      {
        paramErrorMessage = null;
        paramtgj = paramErrorMessage;
        if (paramtgk.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          paramtgj = paramErrorMessage;
          if (i < paramtgk.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramtgj = (tff)paramtgk.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (paramtgj.jdField_a_of_type_Int != 12) {
              break label372;
            }
          }
        }
        if (paramtgj != null)
        {
          ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i = 0;
          label232:
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label680;
          }
          if (((tff)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != 12) {
            break label381;
          }
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramtgj);
        }
      }
    }
    label680:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramtgj);
      }
      a(this.jdField_a_of_type_JavaUtilArrayList, true);
      a();
      c(this.jdField_a_of_type_JavaUtilArrayList);
      b(this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      b(false);
      return;
      label372:
      i += 1;
      break;
      label381:
      i += 1;
      break label232;
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramtgk.jdField_a_of_type_JavaUtilArrayList.size()));
      i = 0;
      while (i < paramtgk.jdField_a_of_type_JavaUtilArrayList.size())
      {
        c((tff)paramtgk.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      if (paramtgj.jdField_c_of_type_Int == 1) {}
      for (bool = a(this.jdField_a_of_type_JavaUtilArrayList, paramtgk.jdField_a_of_type_JavaUtilArrayList);; bool = false)
      {
        ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
        ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
        this.jdField_b_of_type_JavaLangString = paramtgk.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_JavaLangString = paramtgk.c;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramtgk.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList, true);
        this.jdField_a_of_type_Boolean = paramtgk.jdField_b_of_type_Boolean;
        ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
        a();
        c();
        a(false, false);
        ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
        this.jdField_a_of_type_Tfy.a(this.jdField_a_of_type_JavaUtilArrayList, true);
        ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
        c(this.jdField_a_of_type_JavaUtilArrayList);
        b(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        b(bool);
        ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
        return;
      }
    }
  }
  
  @WorkerThread
  public void a(tkk paramtkk)
  {
    if ((paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkk.jdField_a_of_type_JavaUtilList != null) && (!paramtkk.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent isSuccess userUIItems: " + paramtkk.jdField_a_of_type_JavaUtilList);
      }
      int j = paramtkk.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      if (i >= j) {
        break label183;
      }
      if (a(((QQUserUIItem)paramtkk.jdField_a_of_type_JavaUtilList.get(i)).uid) == null) {}
    }
    label183:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.13(this));
      }
      do
      {
        return;
        i += 1;
        break;
      } while (!QLog.isColorLevel());
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent errorInfo: " + paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramtkk.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  protected boolean a()
  {
    ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label126;
      }
      ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (bool = false; localIterator.hasNext(); bool = a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false) | bool) {}
    }
    if (bool) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    for (;;)
    {
      ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
      return bool;
      label126:
      bool = false;
    }
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    label52:
    tfx localtfx;
    if (i >= 0)
    {
      localtfx = (tfx)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if (localtfx.jdField_a_of_type_Long == paramLong)
      {
        paramString.jdField_a_of_type_JavaUtilList.remove(i);
        bool1 = true;
      }
    }
    for (;;)
    {
      i -= 1;
      break label52;
      if (!localtfx.jdField_a_of_type_Boolean)
      {
        paramInt += 1;
        continue;
        paramString.jdField_b_of_type_Int = paramInt;
        if ((!bool1) && (QLog.isDevelopLevel())) {
          QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "deleteNodeVideoFromNodeInfoFromWorkThread, nothing to delete", " info.unreadCount =", Integer.valueOf(paramString.jdField_b_of_type_Int), ", info.videoInfoList=", paramString.jdField_a_of_type_JavaUtilList });
        }
        if (paramString.jdField_a_of_type_JavaUtilList.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_Tfy.b(paramString);
          a(paramString, false, 3, false);
          return bool1;
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_Tfy.a(paramString);
        a(paramString, false, 2, false);
        return bool1;
      }
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidListFromWorkThread(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return tfy.a(new tff(paramInt, paramString1));
      paramString1 = paramString2;
    }
  }
  
  @WorkerThread
  public boolean a(String paramString, long paramLong)
  {
    ved.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (tfx)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if ((((tfx)localObject).jdField_a_of_type_Long == paramLong) && (!((tfx)localObject).jdField_a_of_type_Boolean))
      {
        ((tfx)localObject).jdField_a_of_type_Boolean = true;
        paramString.jdField_b_of_type_Int -= 1;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramString.jdField_b_of_type_Int <= 0) && (!paramString.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = new tgn();
        ((tgn)localObject).jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        ((tgn)localObject).jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
        ((tgn)localObject).jdField_d_of_type_Int = 5;
        ((tgn)localObject).jdField_b_of_type_Long = paramString.e;
        syo.a().a((sys)localObject, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.jdField_a_of_type_JavaUtilList });
      }
      if (bool)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
        if (i >= 0)
        {
          localObject = (tff)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((tff)localObject).copy(paramString);
          this.jdField_a_of_type_Tfy.a((tff)localObject);
        }
        a(paramString, false, 2, false);
      }
      return bool;
      i -= 1;
      break;
    }
  }
  
  public boolean a(tff paramtff)
  {
    boolean bool = c(paramtff);
    if (bool)
    {
      this.jdField_a_of_type_Tfy.b(paramtff);
      a(paramtff, false, 3, false);
    }
    return bool;
  }
  
  protected boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QQStoryContext.a() != null) {}
    return false;
  }
  
  @UiThread
  public ArrayList<tff> b()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool);
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
  }
  
  @GuardedBy("mNotifyLock")
  public void b()
  {
    if (vzd.a(52) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          i = 1;
          if (i == 0) {
            break;
          }
          ((sss)QQStoryContext.a().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void b(svv paramsvv)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.15(this, paramsvv));
  }
  
  public void b(tce paramtce)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.16(this, paramtce));
  }
  
  public void b(tff paramtff)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.7(this, paramtff));
  }
  
  public void b(tfr paramtfr)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(paramtfr);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramtfr.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(tkk paramtkk)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.14(this, paramtkk));
  }
  
  @GuardedBy("mNotifyLock")
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Boolean = true;
      this.f = paramBoolean;
      if (this.jdField_b_of_type_Boolean)
      {
        i = 1;
        if (i != 0)
        {
          ??? = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
          while (((Iterator)???).hasNext())
          {
            tff localtff = (tff)((Iterator)???).next();
            if ((localtff.jdField_b_of_type_Int > 0) && (localtff.jdField_a_of_type_Int == 6)) {
              this.e = true;
            }
          }
          ((sss)QQStoryContext.a().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
        }
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfk
 * JD-Core Version:    0.7.0.1
 */