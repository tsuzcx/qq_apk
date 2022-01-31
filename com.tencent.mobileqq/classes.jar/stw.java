import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class stw
{
  protected int a;
  private WeakReference<sub> jdField_a_of_type_JavaLangRefWeakReference;
  protected final Queue<ssm> a;
  protected final Set<String> a;
  protected AtomicBoolean a;
  public shs a;
  protected sua a;
  protected suc a;
  private sug jdField_a_of_type_Sug = new stz(this);
  protected boolean a;
  protected final Set<String> b = new CopyOnWriteArraySet();
  
  public stw()
  {
    this.jdField_a_of_type_Shs = new sih();
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Suc = new suc();
    this.jdField_a_of_type_Shs.a(2);
    Object localObject = (spz)sqg.a(10);
    this.jdField_a_of_type_Int = ((Integer)((spz)localObject).b("key_story_msg_tab_node_preload", Integer.valueOf(0))).intValue();
    this.jdField_a_of_type_Boolean = ((Boolean)((spz)localObject).b("key_story_msg_tab_node_preload_4g", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("消息TAB日迹预加载器wifi开关状态：");
      if (this.jdField_a_of_type_Int <= 0) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("MsgTabStoryVideoPreloader", 2, bool);
      QLog.i("MsgTabStoryVideoPreloader", 2, "消息TAB日迹预加载器4G开关状态：" + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private Queue<ssm> a(List<ssm> paramList)
  {
    LinkedList localLinkedList;
    for (;;)
    {
      try
      {
        localLinkedList = new LinkedList();
        if ((paramList == null) || (paramList.isEmpty())) {
          break;
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        ssm localssm = (ssm)paramList.next();
        if ((localssm != null) && (suk.a(localssm))) {
          if (localssm.b > 0) {
            localLinkedList.add(localssm);
          } else {
            this.jdField_a_of_type_JavaUtilSet.remove(localssm.a);
          }
        }
      }
      finally {}
    }
    return localLinkedList;
  }
  
  private void a(List<StoryVideoItem> paramList)
  {
    try
    {
      Bosses.get().postJob(new sty(this, "MsgTabStoryVideoPreloader", paramList));
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private void a(Queue<ssm> paramQueue)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "添加一波要预加载的节点队列=" + paramQueue.size() + "\n" + paramQueue);
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
      {
        ??? = a();
        if (??? != null) {
          ((sub)???).a();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "预加载正式开始");
      }
      synchronized (this.jdField_a_of_type_JavaUtilQueue)
      {
        paramQueue = paramQueue.iterator();
        while (paramQueue.hasNext())
        {
          ssm localssm = (ssm)paramQueue.next();
          if (!this.jdField_a_of_type_JavaUtilQueue.contains(localssm)) {
            this.jdField_a_of_type_JavaUtilQueue.add(localssm);
          }
        }
      }
    }
    finally {}
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool = true;
    switch (mpq.a(paramContext))
    {
    case 2: 
    case 3: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() 非4g非wifi，不进行预下载");
      }
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() wifi");
        }
        this.jdField_a_of_type_Suc.a(true);
        this.jdField_a_of_type_Suc.b(true);
      } while (this.jdField_a_of_type_Int != 0);
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() 4g");
      }
      this.jdField_a_of_type_Suc.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Suc.b(false);
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != 0));
    return false;
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Sua == null)
      {
        this.jdField_a_of_type_Sua = new sua(this);
        this.jdField_a_of_type_Shs.a(this.jdField_a_of_type_Sua);
      }
      sia localsia = (sia)sqg.a(6);
      if (!localsia.a()) {
        localsia.c();
      }
      return;
    }
    finally {}
  }
  
  public sub a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (sub)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	stw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_0
    //   7: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 259	stw:jdField_a_of_type_Sua	Lsua;
    //   15: aload_0
    //   16: getfield 28	stw:jdField_a_of_type_Shs	Lshs;
    //   19: ifnull +12 -> 31
    //   22: aload_0
    //   23: getfield 28	stw:jdField_a_of_type_Shs	Lshs;
    //   26: invokeinterface 280 1 0
    //   31: aload_0
    //   32: getfield 38	stw:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 40	stw:b	Ljava/util/Set;
    //   42: invokeinterface 283 1 0
    //   47: aload_0
    //   48: getfield 38	stw:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   51: invokeinterface 284 1 0
    //   56: aload_0
    //   57: getfield 33	stw:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   60: invokeinterface 283 1 0
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_2
    //   71: aload_1
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	stw
    //   75	4	1	localObject1	Object
    //   70	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	67	70	finally
    //   71	73	70	finally
    //   2	31	75	finally
    //   31	38	75	finally
    //   73	75	75	finally
  }
  
  public void a(Context paramContext, List<ssm> paramList)
  {
    if (paramContext == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new stx(this, "MsgTabStoryVideoPreloader", paramContext, paramList));
  }
  
  /* Error */
  public void a(String arg1, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	stw:b	Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface 173 2 0
    //   12: pop
    //   13: aload_0
    //   14: getfield 47	stw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: invokevirtual 299	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   20: ifeq +83 -> 103
    //   23: aload_0
    //   24: getfield 38	stw:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   27: astore_1
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 38	stw:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   34: invokeinterface 300 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_0
    //   43: getfield 40	stw:b	Ljava/util/Set;
    //   46: invokeinterface 301 1 0
    //   51: ifeq +55 -> 106
    //   54: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +12 -> 69
    //   60: ldc 117
    //   62: iconst_2
    //   63: ldc_w 303
    //   66: invokestatic 128	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_0
    //   70: getfield 47	stw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   73: iconst_0
    //   74: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   77: aload_0
    //   78: getfield 33	stw:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   81: invokeinterface 283 1 0
    //   86: aload_0
    //   87: invokevirtual 218	stw:a	()Lsub;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +9 -> 101
    //   95: aload_3
    //   96: invokeinterface 305 1 0
    //   101: aload_1
    //   102: monitorexit
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: iload_2
    //   107: ifeq -6 -> 101
    //   110: aload_0
    //   111: invokevirtual 306	stw:b	()V
    //   114: goto -13 -> 101
    //   117: astore_3
    //   118: aload_1
    //   119: monitorexit
    //   120: aload_3
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	stw
    //   0	127	2	paramBoolean	boolean
    //   90	6	3	localsub	sub
    //   117	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	69	117	finally
    //   69	91	117	finally
    //   95	101	117	finally
    //   101	103	117	finally
    //   110	114	117	finally
    //   118	120	117	finally
    //   2	30	122	finally
    //   120	122	122	finally
  }
  
  public void a(sub paramsub)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramsub);
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	stw:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   6: invokeinterface 311 1 0
    //   11: istore_1
    //   12: aload_0
    //   13: getfield 88	stw:jdField_a_of_type_Int	I
    //   16: istore_2
    //   17: iload_1
    //   18: iload_2
    //   19: if_icmpge +9 -> 28
    //   22: iconst_1
    //   23: istore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_3
    //   30: goto -6 -> 24
    //   33: astore 4
    //   35: aload_0
    //   36: monitorexit
    //   37: aload 4
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	stw
    //   11	9	1	i	int
    //   16	4	2	j	int
    //   23	7	3	bool	boolean
    //   33	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	33	finally
  }
  
  protected void b()
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilQueue)
        {
          if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
          {
            if (QLog.isColorLevel()) {
              QLog.i("MsgTabStoryVideoPreloader", 2, "节点信息都加载成功了");
            }
            return;
          }
          ssm localssm = (ssm)this.jdField_a_of_type_JavaUtilQueue.poll();
          if (localssm != null) {
            if (!TextUtils.isEmpty(localssm.a)) {
              break label83;
            }
          }
        }
        if (a()) {
          break label145;
        }
      }
      finally {}
      label83:
      if (QLog.isColorLevel()) {
        QLog.w("MsgTabStoryVideoPreloader", 2, "预加载节点数到了指定阈值:" + this.jdField_a_of_type_Int + "，不继续加载");
      }
      this.jdField_a_of_type_JavaUtilQueue.clear();
      continue;
      label145:
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "pull video info from node \n" + localObject2);
      }
      this.jdField_a_of_type_JavaUtilSet.add(localObject2.a);
      this.jdField_a_of_type_Suc.a(localObject2, this.jdField_a_of_type_Sug);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stw
 * JD-Core Version:    0.7.0.1
 */