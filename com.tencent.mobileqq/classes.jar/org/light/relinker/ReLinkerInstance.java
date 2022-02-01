package org.light.relinker;

import android.content.Context;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ReLinkerInstance
{
  private static final String LIB_DIR = "lib";
  protected boolean force;
  protected final ReLinker.LibraryInstaller libraryInstaller;
  protected final ReLinker.LibraryLoader libraryLoader;
  protected final Set<String> loadedLibraries = new HashSet();
  protected ReLinker.Logger logger;
  protected boolean recursive;
  
  protected ReLinkerInstance()
  {
    this(new SystemLibraryLoader(), new ApkLibraryInstaller());
  }
  
  protected ReLinkerInstance(ReLinker.LibraryLoader paramLibraryLoader, ReLinker.LibraryInstaller paramLibraryInstaller)
  {
    if (paramLibraryLoader == null) {
      throw new IllegalArgumentException("Cannot pass null library loader");
    }
    if (paramLibraryInstaller == null) {
      throw new IllegalArgumentException("Cannot pass null library installer");
    }
    this.libraryLoader = paramLibraryLoader;
    this.libraryInstaller = paramLibraryInstaller;
  }
  
  /* Error */
  private void loadLibraryInternal(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	org/light/relinker/ReLinkerInstance:loadedLibraries	Ljava/util/Set;
    //   4: aload_2
    //   5: invokeinterface 68 2 0
    //   10: ifeq +25 -> 35
    //   13: aload_0
    //   14: getfield 70	org/light/relinker/ReLinkerInstance:force	Z
    //   17: ifne +18 -> 35
    //   20: aload_0
    //   21: ldc 72
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_2
    //   30: aastore
    //   31: invokevirtual 76	org/light/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: return
    //   35: aload_0
    //   36: getfield 50	org/light/relinker/ReLinkerInstance:libraryLoader	Lorg/light/relinker/ReLinker$LibraryLoader;
    //   39: aload_2
    //   40: invokeinterface 81 2 0
    //   45: aload_0
    //   46: getfield 39	org/light/relinker/ReLinkerInstance:loadedLibraries	Ljava/util/Set;
    //   49: aload_2
    //   50: invokeinterface 84 2 0
    //   55: pop
    //   56: aload_0
    //   57: ldc 86
    //   59: iconst_2
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_2
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_3
    //   70: aastore
    //   71: invokevirtual 76	org/light/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: return
    //   75: astore 5
    //   77: aload_0
    //   78: ldc 88
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload 5
    //   88: invokestatic 94	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   91: aastore
    //   92: invokevirtual 76	org/light/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_0
    //   96: ldc 96
    //   98: iconst_2
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_2
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_3
    //   109: aastore
    //   110: invokevirtual 76	org/light/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload_0
    //   114: aload_1
    //   115: aload_2
    //   116: aload_3
    //   117: invokevirtual 100	org/light/relinker/ReLinkerInstance:getWorkaroundLibFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   120: astore 6
    //   122: aload 6
    //   124: invokevirtual 106	java/io/File:exists	()Z
    //   127: ifeq +10 -> 137
    //   130: aload_0
    //   131: getfield 70	org/light/relinker/ReLinkerInstance:force	Z
    //   134: ifeq +67 -> 201
    //   137: aload_0
    //   138: getfield 70	org/light/relinker/ReLinkerInstance:force	Z
    //   141: ifeq +21 -> 162
    //   144: aload_0
    //   145: ldc 108
    //   147: iconst_2
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_2
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload_3
    //   158: aastore
    //   159: invokevirtual 76	org/light/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload_0
    //   163: aload_1
    //   164: aload_2
    //   165: aload_3
    //   166: invokevirtual 111	org/light/relinker/ReLinkerInstance:cleanupOldLibFiles	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: getfield 52	org/light/relinker/ReLinkerInstance:libraryInstaller	Lorg/light/relinker/ReLinker$LibraryInstaller;
    //   173: aload_1
    //   174: aload_0
    //   175: getfield 50	org/light/relinker/ReLinkerInstance:libraryLoader	Lorg/light/relinker/ReLinker$LibraryLoader;
    //   178: invokeinterface 115 1 0
    //   183: aload_0
    //   184: getfield 50	org/light/relinker/ReLinkerInstance:libraryLoader	Lorg/light/relinker/ReLinker$LibraryLoader;
    //   187: aload_2
    //   188: invokeinterface 119 2 0
    //   193: aload 6
    //   195: aload_0
    //   196: invokeinterface 125 6 0
    //   201: aload_0
    //   202: getfield 127	org/light/relinker/ReLinkerInstance:recursive	Z
    //   205: istore 4
    //   207: iload 4
    //   209: ifeq +77 -> 286
    //   212: new 129	org/light/relinker/elf/ElfParser
    //   215: dup
    //   216: aload 6
    //   218: invokespecial 132	org/light/relinker/elf/ElfParser:<init>	(Ljava/io/File;)V
    //   221: astore 5
    //   223: aload 5
    //   225: invokevirtual 136	org/light/relinker/elf/ElfParser:parseNeededDependencies	()Ljava/util/List;
    //   228: astore 7
    //   230: aload 5
    //   232: invokevirtual 139	org/light/relinker/elf/ElfParser:close	()V
    //   235: aload 7
    //   237: invokeinterface 145 1 0
    //   242: astore 5
    //   244: aload 5
    //   246: invokeinterface 150 1 0
    //   251: ifeq +35 -> 286
    //   254: aload 5
    //   256: invokeinterface 154 1 0
    //   261: checkcast 156	java/lang/String
    //   264: astore 7
    //   266: aload_0
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 50	org/light/relinker/ReLinkerInstance:libraryLoader	Lorg/light/relinker/ReLinker$LibraryLoader;
    //   272: aload 7
    //   274: invokeinterface 159 2 0
    //   279: invokevirtual 162	org/light/relinker/ReLinkerInstance:loadLibrary	(Landroid/content/Context;Ljava/lang/String;)V
    //   282: goto -38 -> 244
    //   285: astore_1
    //   286: aload_0
    //   287: getfield 50	org/light/relinker/ReLinkerInstance:libraryLoader	Lorg/light/relinker/ReLinker$LibraryLoader;
    //   290: aload 6
    //   292: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   295: invokeinterface 169 2 0
    //   300: aload_0
    //   301: getfield 39	org/light/relinker/ReLinkerInstance:loadedLibraries	Ljava/util/Set;
    //   304: aload_2
    //   305: invokeinterface 84 2 0
    //   310: pop
    //   311: aload_0
    //   312: ldc 171
    //   314: iconst_2
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: aload_2
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: aload_3
    //   325: aastore
    //   326: invokevirtual 76	org/light/relinker/ReLinkerInstance:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: return
    //   330: astore_1
    //   331: aconst_null
    //   332: astore 5
    //   334: aload 5
    //   336: invokevirtual 139	org/light/relinker/elf/ElfParser:close	()V
    //   339: aload_1
    //   340: athrow
    //   341: astore_1
    //   342: goto -8 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	ReLinkerInstance
    //   0	345	1	paramContext	Context
    //   0	345	2	paramString1	String
    //   0	345	3	paramString2	String
    //   205	3	4	bool	boolean
    //   75	12	5	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   221	114	5	localObject1	Object
    //   120	171	6	localFile	File
    //   228	45	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	74	75	java/lang/UnsatisfiedLinkError
    //   201	207	285	java/io/IOException
    //   230	244	285	java/io/IOException
    //   244	282	285	java/io/IOException
    //   334	341	285	java/io/IOException
    //   212	223	330	finally
    //   223	230	341	finally
  }
  
  protected void cleanupOldLibFiles(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = getWorkaroundLibDir(paramContext);
    paramContext = getWorkaroundLibFile(paramContext, paramString1, paramString2);
    paramString1 = localFile.listFiles(new ReLinkerInstance.2(this, this.libraryLoader.mapLibraryName(paramString1)));
    if (paramString1 == null) {
      return;
    }
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      paramString2 = paramString1[i];
      if ((this.force) || (!paramString2.getAbsolutePath().equals(paramContext.getAbsolutePath()))) {}
      try
      {
        paramString2.delete();
        i += 1;
      }
      catch (SecurityException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  public ReLinkerInstance force()
  {
    this.force = true;
    return this;
  }
  
  protected File getWorkaroundLibDir(Context paramContext)
  {
    return paramContext.getDir("lib", 0);
  }
  
  protected File getWorkaroundLibFile(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = this.libraryLoader.mapLibraryName(paramString1);
    if (TextUtils.isEmpty(paramString2)) {
      return new File(getWorkaroundLibDir(paramContext), paramString1);
    }
    return new File(getWorkaroundLibDir(paramContext), paramString1 + "." + paramString2);
  }
  
  public void loadLibrary(Context paramContext, String paramString)
  {
    loadLibrary(paramContext, paramString, null, null);
  }
  
  public void loadLibrary(Context paramContext, String paramString1, String paramString2)
  {
    loadLibrary(paramContext, paramString1, paramString2, null);
  }
  
  public void loadLibrary(Context paramContext, String paramString1, String paramString2, ReLinker.LoadListener paramLoadListener)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Given context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("Given library is either null or empty");
    }
    log("Beginning load of %s...", new Object[] { paramString1 });
    if (paramLoadListener == null)
    {
      loadLibraryInternal(paramContext, paramString1, paramString2);
      return;
    }
    new Thread(new ReLinkerInstance.1(this, paramContext, paramString1, paramString2, paramLoadListener)).start();
  }
  
  public void loadLibrary(Context paramContext, String paramString, ReLinker.LoadListener paramLoadListener)
  {
    loadLibrary(paramContext, paramString, null, paramLoadListener);
  }
  
  public ReLinkerInstance log(ReLinker.Logger paramLogger)
  {
    this.logger = paramLogger;
    return this;
  }
  
  public void log(String paramString)
  {
    if (this.logger != null) {
      this.logger.log(paramString);
    }
  }
  
  public void log(String paramString, Object... paramVarArgs)
  {
    log(String.format(Locale.US, paramString, paramVarArgs));
  }
  
  public ReLinkerInstance recursively()
  {
    this.recursive = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.relinker.ReLinkerInstance
 * JD-Core Version:    0.7.0.1
 */