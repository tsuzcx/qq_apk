package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;

public class TPDiskReadWrite
{
  public static final String TAG = "TPDiskReadWrite";
  private ArrayList<String> mKey = new ArrayList();
  private LocalCache mKeyCache = null;
  private String mKeyCacheName = null;
  private LocalCache mMessageCache = null;
  
  public TPDiskReadWrite(Context paramContext, String paramString)
  {
    this.mMessageCache = LocalCache.get(paramContext, paramString);
    this.mKeyCacheName = (paramString + "_key");
    this.mKeyCache = LocalCache.get(paramContext, this.mKeyCacheName);
  }
  
  public Object readAllFile()
  {
    Object localObject4 = null;
    Object localObject3 = null;
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = (ArrayList)this.mKeyCache.getAsObject(this.mKeyCacheName);
        Object localObject1 = localObject3;
        if (localArrayList != null)
        {
          i = localArrayList.size();
          if (i <= 0) {
            localObject1 = localObject3;
          }
        }
        else
        {
          return localObject1;
        }
        i = 0;
        localObject1 = localObject4;
        if (i < localArrayList.size())
        {
          localObject3 = (String)localArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label149;
          }
          localObject3 = this.mMessageCache.getAsObject((String)localObject3);
          if (localObject3 == null) {
            break label149;
          }
          if (localObject1 != null) {
            break label146;
          }
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      finally {}
      this.mMessageCache.clear();
      this.mKeyCache.clear();
      this.mKey.clear();
      continue;
      label146:
      continue;
      label149:
      i += 1;
    }
  }
  
  /* Error */
  public void rmFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 22	com/tencent/thumbplayer/utils/TPDiskReadWrite:mMessageCache	Lcom/tencent/thumbplayer/utils/LocalCache;
    //   18: aload_1
    //   19: invokevirtual 86	com/tencent/thumbplayer/utils/LocalCache:remove	(Ljava/lang/String;)Z
    //   22: pop
    //   23: aload_0
    //   24: getfield 29	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKey	Ljava/util/ArrayList;
    //   27: aload_1
    //   28: invokevirtual 88	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 24	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCache	Lcom/tencent/thumbplayer/utils/LocalCache;
    //   36: aload_0
    //   37: getfield 31	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCacheName	Ljava/lang/String;
    //   40: invokevirtual 86	com/tencent/thumbplayer/utils/LocalCache:remove	(Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: getfield 24	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCache	Lcom/tencent/thumbplayer/utils/LocalCache;
    //   48: aload_0
    //   49: getfield 31	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCacheName	Ljava/lang/String;
    //   52: aload_0
    //   53: getfield 29	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKey	Ljava/util/ArrayList;
    //   56: invokevirtual 92	com/tencent/thumbplayer/utils/LocalCache:put	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   59: goto -48 -> 11
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	TPDiskReadWrite
    //   0	67	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	62	finally
    //   14	59	62	finally
  }
  
  /* Error */
  public void writeFile(String paramString, java.io.Serializable paramSerializable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +12 -> 15
    //   6: aload_1
    //   7: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 22	com/tencent/thumbplayer/utils/TPDiskReadWrite:mMessageCache	Lcom/tencent/thumbplayer/utils/LocalCache;
    //   22: aload_1
    //   23: invokevirtual 86	com/tencent/thumbplayer/utils/LocalCache:remove	(Ljava/lang/String;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 22	com/tencent/thumbplayer/utils/TPDiskReadWrite:mMessageCache	Lcom/tencent/thumbplayer/utils/LocalCache;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 92	com/tencent/thumbplayer/utils/LocalCache:put	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   36: aload_0
    //   37: getfield 29	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKey	Ljava/util/ArrayList;
    //   40: aload_1
    //   41: invokevirtual 88	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: aload_0
    //   46: getfield 29	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKey	Ljava/util/ArrayList;
    //   49: aload_1
    //   50: invokevirtual 76	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 24	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCache	Lcom/tencent/thumbplayer/utils/LocalCache;
    //   58: aload_0
    //   59: getfield 31	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCacheName	Ljava/lang/String;
    //   62: invokevirtual 86	com/tencent/thumbplayer/utils/LocalCache:remove	(Ljava/lang/String;)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 24	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCache	Lcom/tencent/thumbplayer/utils/LocalCache;
    //   70: aload_0
    //   71: getfield 31	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKeyCacheName	Ljava/lang/String;
    //   74: aload_0
    //   75: getfield 29	com/tencent/thumbplayer/utils/TPDiskReadWrite:mKey	Ljava/util/ArrayList;
    //   78: invokevirtual 92	com/tencent/thumbplayer/utils/LocalCache:put	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   81: goto -66 -> 15
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	TPDiskReadWrite
    //   0	89	1	paramString	String
    //   0	89	2	paramSerializable	java.io.Serializable
    //   10	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	84	finally
    //   18	81	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPDiskReadWrite
 * JD-Core Version:    0.7.0.1
 */