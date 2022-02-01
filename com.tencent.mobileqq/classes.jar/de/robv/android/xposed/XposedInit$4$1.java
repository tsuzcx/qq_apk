package de.robv.android.xposed;

class XposedInit$4$1
  extends XC_MethodHook
{
  XposedInit$4$1(XposedInit.4 param4, ClassLoader paramClassLoader) {}
  
  /* Error */
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	de/robv/android/xposed/SELinuxHelper:initForProcess	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: getfield 12	de/robv/android/xposed/XposedInit$4$1:this$0	Lde/robv/android/xposed/XposedInit$4;
    //   9: getfield 38	de/robv/android/xposed/XposedInit$4:val$loadedPackagesInProcess	Ljava/util/HashSet;
    //   12: ldc 26
    //   14: invokevirtual 44	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   17: pop
    //   18: new 46	de/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam
    //   21: dup
    //   22: getstatic 52	de/robv/android/xposed/XposedBridge:sLoadedPackageCallbacks	Lde/robv/android/xposed/XposedBridge$CopyOnWriteSortedSet;
    //   25: invokespecial 55	de/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam:<init>	(Lde/robv/android/xposed/XposedBridge$CopyOnWriteSortedSet;)V
    //   28: astore_1
    //   29: aload_1
    //   30: ldc 26
    //   32: putfield 59	de/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam:packageName	Ljava/lang/String;
    //   35: aload_1
    //   36: ldc 26
    //   38: putfield 62	de/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam:processName	Ljava/lang/String;
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 14	de/robv/android/xposed/XposedInit$4$1:val$cl	Ljava/lang/ClassLoader;
    //   46: putfield 65	de/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam:classLoader	Ljava/lang/ClassLoader;
    //   49: aload_1
    //   50: aconst_null
    //   51: putfield 69	de/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam:appInfo	Landroid/content/pm/ApplicationInfo;
    //   54: aload_1
    //   55: iconst_1
    //   56: putfield 73	de/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam:isFirstApplication	Z
    //   59: aload_1
    //   60: invokestatic 79	de/robv/android/xposed/callbacks/XC_LoadPackage:callAll	(Lde/robv/android/xposed/callbacks/XCallback$Param;)V
    //   63: ldc 81
    //   65: aload_0
    //   66: getfield 14	de/robv/android/xposed/XposedInit$4$1:val$cl	Ljava/lang/ClassLoader;
    //   69: ldc 83
    //   71: iconst_1
    //   72: anewarray 85	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: iconst_0
    //   78: invokestatic 91	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: invokestatic 97	de/robv/android/xposed/XC_MethodReplacement:returnConstant	(Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodReplacement;
    //   84: aastore
    //   85: invokestatic 103	de/robv/android/xposed/XposedHelpers:findAndHookMethod	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;
    //   88: pop
    //   89: new 105	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   96: ldc 108
    //   98: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: astore_2
    //   102: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   105: bipush 23
    //   107: if_icmplt +44 -> 151
    //   110: ldc 120
    //   112: astore_1
    //   113: aload_2
    //   114: aload_1
    //   115: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload_0
    //   122: getfield 14	de/robv/android/xposed/XposedInit$4$1:val$cl	Ljava/lang/ClassLoader;
    //   125: ldc 126
    //   127: iconst_2
    //   128: anewarray 85	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: ldc 128
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: iconst_1
    //   139: invokestatic 91	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   142: invokestatic 97	de/robv/android/xposed/XC_MethodReplacement:returnConstant	(Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodReplacement;
    //   145: aastore
    //   146: invokestatic 103	de/robv/android/xposed/XposedHelpers:findAndHookMethod	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;
    //   149: pop
    //   150: return
    //   151: ldc 130
    //   153: astore_1
    //   154: goto -41 -> 113
    //   157: astore_1
    //   158: return
    //   159: astore_1
    //   160: return
    //   161: astore_1
    //   162: goto -73 -> 89
    //   165: astore_1
    //   166: goto -77 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	1
    //   0	169	1	paramMethodHookParam	XC_MethodHook.MethodHookParam
    //   101	13	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   89	110	157	de/robv/android/xposed/XposedHelpers$ClassNotFoundError
    //   113	150	157	de/robv/android/xposed/XposedHelpers$ClassNotFoundError
    //   89	110	159	java/lang/NoSuchMethodError
    //   113	150	159	java/lang/NoSuchMethodError
    //   63	89	161	de/robv/android/xposed/XposedHelpers$ClassNotFoundError
    //   63	89	165	java/lang/NoSuchMethodError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.4.1
 * JD-Core Version:    0.7.0.1
 */