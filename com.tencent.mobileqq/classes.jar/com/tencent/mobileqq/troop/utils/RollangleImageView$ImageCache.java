package com.tencent.mobileqq.troop.utils;

import ajnu;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedList;

public class RollangleImageView$ImageCache
{
  private static ImageCache jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache;
  private Handler jdField_a_of_type_AndroidOsHandler = new ajnu(this, BaseApplication.getContext().getMainLooper());
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  public boolean a;
  
  public static ImageCache a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache == null) {
      jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache = new ImageCache();
    }
    return jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView$ImageCache;
  }
  
  public Bitmap a(String paramString, RollangleImageView paramRollangleImageView)
  {
    try
    {
      paramString = (Bitmap)RollangleImageView.a.get("troopfileimage://" + paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 39	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   18: invokevirtual 71	java/util/LinkedList:clear	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 39	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	ImageCache
    //   6	2	1	localLinkedList	LinkedList
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	26	29	finally
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally {}
  }
  
  /* Error */
  public Bitmap b(String paramString, RollangleImageView paramRollangleImageView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 45	com/tencent/mobileqq/troop/utils/RollangleImageView:a	Landroid/support/v4/util/MQLruCache;
    //   5: new 47	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   12: ldc 50
    //   14: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 64	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 66	android/graphics/Bitmap
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: getfield 39	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   45: ifnonnull +14 -> 59
    //   48: aload_0
    //   49: new 68	java/util/LinkedList
    //   52: dup
    //   53: invokespecial 76	java/util/LinkedList:<init>	()V
    //   56: putfield 39	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   59: aload_0
    //   60: getfield 39	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   63: invokevirtual 80	java/util/LinkedList:isEmpty	()Z
    //   66: ifeq +17 -> 83
    //   69: new 82	ajnt
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 85	ajnt:<init>	(Lcom/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache;)V
    //   77: iconst_5
    //   78: aconst_null
    //   79: iconst_1
    //   80: invokestatic 91	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   83: new 93	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem
    //   86: dup
    //   87: invokespecial 94	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:<init>	()V
    //   90: astore_3
    //   91: aload_3
    //   92: aload_2
    //   93: putfield 97	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView	Lcom/tencent/mobileqq/troop/utils/RollangleImageView;
    //   96: aload_3
    //   97: aload_1
    //   98: putfield 100	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache$QueueItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: aload_0
    //   102: getfield 39	com/tencent/mobileqq/troop/utils/RollangleImageView$ImageCache:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   105: aload_3
    //   106: invokevirtual 104	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: aconst_null
    //   111: astore_1
    //   112: goto -75 -> 37
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	ImageCache
    //   0	120	1	paramString	String
    //   0	120	2	paramRollangleImageView	RollangleImageView
    //   30	76	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	115	finally
    //   41	59	115	finally
    //   59	83	115	finally
    //   83	110	115	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache
 * JD-Core Version:    0.7.0.1
 */