package com.tencent.tbs.one.impl.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.c.a.c;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.e.a;
import com.tencent.tbs.one.impl.common.e.b;
import com.tencent.tbs.one.impl.e.h.1;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b
  implements com.tencent.tbs.one.impl.a.a.d.a
{
  public String a;
  public com.tencent.tbs.one.impl.e.h b;
  ArrayList<TBSOneCallback<File>> c = new ArrayList();
  public ArrayList<TBSOneCallback<TBSOneComponent>> d = new ArrayList();
  public boolean e;
  com.tencent.tbs.one.impl.common.d.a f;
  public int g;
  int h;
  int i;
  String j;
  public File k;
  public a l;
  private e m;
  private Map<String, ClassLoader> n;
  
  public b(com.tencent.tbs.one.impl.e.h paramh, String paramString)
  {
    this.a = paramString;
    this.b = paramh;
  }
  
  private File a(String paramString)
  {
    Object localObject = this.b.h;
    if (localObject != null)
    {
      localObject = ((TBSOneDelegate)localObject).shouldOverrideFilePath(this.b.b, this.a, this.f.c, paramString);
      if (localObject != null) {
        paramString = new File((String)localObject);
      }
    }
    do
    {
      return paramString;
      localObject = new File(this.k, paramString);
      paramString = (String)localObject;
    } while (((File)localObject).exists());
    f.b("Failed to find component file %s in installation directory", new Object[] { ((File)localObject).getAbsolutePath() });
    return localObject;
  }
  
  private ClassLoader a(Context paramContext, String paramString)
  {
    String str1 = this.b.b;
    String str2 = this.a;
    Object localObject1;
    if (this.n != null)
    {
      localObject1 = (ClassLoader)this.n.get(paramString);
      if (localObject1 != null)
      {
        f.a("[%s] {%s} Reusing class loader %s %s", new Object[] { str1, str2, paramString, localObject1 });
        return localObject1;
      }
    }
    File localFile = a(paramString);
    if (!localFile.exists()) {
      throw new TBSOneException(105, "Failed to find dex file " + localFile.getAbsolutePath());
    }
    f.a("[%s] {%s} Creating class loader %s from %s", new Object[] { str1, str2, paramString, localFile.getAbsolutePath() });
    if (this.m == null)
    {
      localObject1 = a("MANIFEST");
      if (((File)localObject1).exists()) {
        f.a("[%s] {%s} Initializing component according to MANIFEST file %s", new Object[] { str1, str2, ((File)localObject1).getAbsolutePath() });
      }
    }
    for (;;)
    {
      String str3;
      Object localObject3;
      try
      {
        this.m = e.a((File)localObject1);
        if (this.m == null)
        {
          localObject2 = null;
          localObject1 = this.b;
          str3 = this.a;
          str3 = str3 + "." + "parent_classloader";
          if (!((com.tencent.tbs.one.impl.e.h)localObject1).i.containsKey(str3)) {
            break label513;
          }
          localObject1 = ((com.tencent.tbs.one.impl.e.h)localObject1).i.get(str3);
          if (!(localObject1 instanceof ClassLoader)) {
            break label551;
          }
          localObject1 = (ClassLoader)localObject1;
          str3 = b(localFile.getAbsolutePath());
          boolean bool1 = this.b.a(str2, "disable_sealed_classloader");
          boolean bool2 = this.b.a(str2, "enable_async_dex_optimization");
          long l1 = System.currentTimeMillis();
          localObject3 = this.k.getAbsolutePath();
          if (localObject2 != null) {
            break label679;
          }
          localObject2 = null;
          paramContext = c.a(paramContext, localFile, (String)localObject3, str3, (ClassLoader)localObject1, bool1, (String[])localObject2, bool2);
          f.a("[%s] {%s} Created dex class loader %s %s cost %dms", new Object[] { str1, str2, paramString, paramContext, Long.valueOf(System.currentTimeMillis() - l1) });
          if (this.n == null) {
            this.n = new HashMap();
          }
          this.n.put(paramString, paramContext);
          paramString = this.b.h;
          if (paramString != null) {
            paramString.onDexLoaded(str1, str2, this.f.c, localFile.getAbsolutePath(), paramContext);
          }
          return paramContext;
        }
      }
      catch (TBSOneException paramContext)
      {
        b(paramContext.getErrorCode(), paramContext.getMessage(), paramContext.getCause());
        return null;
      }
      Object localObject2 = this.m.a(paramString);
      continue;
      label513:
      if (((com.tencent.tbs.one.impl.e.h)localObject1).i.containsKey("parent_classloader"))
      {
        localObject1 = ((com.tencent.tbs.one.impl.e.h)localObject1).i.get("parent_classloader");
      }
      else
      {
        localObject1 = null;
        continue;
        label551:
        if (localObject2 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            str3 = ((e.b)localObject1).a;
            if (TextUtils.isEmpty(str3))
            {
              localObject1 = a(paramContext, ((e.b)localObject1).b);
              break;
              localObject1 = ((e.a)localObject2).d;
              continue;
            }
            localObject3 = this.b.d(str3);
            if (localObject3 == null) {
              throw new TBSOneException(404, "Failed to get loaded dependency " + str3);
            }
            localObject1 = ((b)localObject3).a(paramContext, ((e.b)localObject1).b);
            break;
          }
        }
        localObject1 = this.b.a.getClassLoader();
        continue;
        label679:
        localObject2 = ((e.a)localObject2).c;
      }
    }
  }
  
  private void a(a parama)
  {
    int i1 = 0;
    f.a("[%s] {%s} Finished loading component %s", new Object[] { this.b.b, this.a, parama });
    this.l = parama;
    int i2 = this.g;
    this.g = 100;
    TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
    this.d.clear();
    int i3 = arrayOfTBSOneCallback.length;
    while (i1 < i3)
    {
      TBSOneCallback localTBSOneCallback = arrayOfTBSOneCallback[i1];
      localTBSOneCallback.onProgressChanged(i2, 100);
      localTBSOneCallback.onCompleted(parama);
      i1 += 1;
    }
  }
  
  private String b(String paramString)
  {
    String str2 = TextUtils.join(File.pathSeparator, c());
    f.a("[%s] {%s} Collected librarySearchPath %s", new Object[] { this.b.b, this.a, str2 });
    TBSOneDelegate localTBSOneDelegate = this.b.h;
    String str1 = str2;
    if (localTBSOneDelegate != null)
    {
      paramString = localTBSOneDelegate.shouldOverrideLibrarySearchPath(this.b.b, this.a, this.f.c, paramString, str2);
      str1 = str2;
      if (paramString != null) {
        str1 = paramString;
      }
    }
    return str1;
  }
  
  private Set<String> c()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.k.getAbsolutePath());
    String[] arrayOfString = this.f.f;
    if (arrayOfString != null)
    {
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        localHashSet.addAll(this.b.d(str).c());
        i1 += 1;
      }
    }
    return localHashSet;
  }
  
  public final void a()
  {
    String str = this.a;
    f.a("[%s] {%s} Finished installing component and dependencies", new Object[] { this.b.b, str });
    m.a(new b.5(this, str));
  }
  
  final void a(int paramInt)
  {
    Object localObject = this.b.b;
    localObject = this.a;
    int i1 = this.g;
    if (paramInt - this.g > 2)
    {
      int i2 = this.g;
      this.g = paramInt;
      localObject = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
      TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
      int i3 = localObject.length;
      i1 = 0;
      while (i1 < i3)
      {
        localObject[i1].onProgressChanged(i2, paramInt);
        i1 += 1;
      }
      i3 = arrayOfTBSOneCallback.length;
      i1 = 0;
      while (i1 < i3)
      {
        arrayOfTBSOneCallback[i1].onProgressChanged(i2, paramInt);
        i1 += 1;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    float f1 = paramInt2;
    a((int)(paramInt1 / 100.0F * (paramInt3 - paramInt2) + f1));
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    m.a(new b.4(this, paramInt, paramString, paramThrowable));
  }
  
  public final void a(Bundle paramBundle)
  {
    Object localObject1 = this.b.b;
    Object localObject2 = this.a;
    if (this.e)
    {
      f.a("[%s] {%s} Have started loading component", new Object[] { localObject1, localObject2 });
      return;
    }
    f.a("[%s] {%s} Loading DEPS", new Object[] { localObject1, localObject2 });
    this.e = true;
    localObject1 = this.b;
    localObject2 = new b.1(this, paramBundle);
    String str = ((com.tencent.tbs.one.impl.e.h)localObject1).b;
    f.a("[%s] Loading DEPS", new Object[] { str });
    if (((com.tencent.tbs.one.impl.e.h)localObject1).l != null)
    {
      f.a("[%s] Loaded DEPS#%d", new Object[] { str, Integer.valueOf(((com.tencent.tbs.one.impl.e.h)localObject1).l.a) });
      ((l)localObject2).a(((com.tencent.tbs.one.impl.e.h)localObject1).l);
      return;
    }
    if (((com.tencent.tbs.one.impl.e.h)localObject1).m == null) {
      ((com.tencent.tbs.one.impl.e.h)localObject1).m = new h.1((com.tencent.tbs.one.impl.e.h)localObject1, paramBundle);
    }
    ((com.tencent.tbs.one.impl.e.h)localObject1).m.a((l)localObject2);
  }
  
  public final void a(Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    if (this.k != null)
    {
      f.a("[%s] {%s} Installed component at %s", new Object[] { this.b.b, this.a, this.k });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(this.k);
      }
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, this.g);
      this.c.add(paramTBSOneCallback);
    }
    a(paramBundle);
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   4: getfield 58	com/tencent/tbs/one/impl/e/h:b	Ljava/lang/String;
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 47	com/tencent/tbs/one/impl/c/b:a	Ljava/lang/String;
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 60	com/tencent/tbs/one/impl/c/b:f	Lcom/tencent/tbs/one/impl/common/d$a;
    //   19: getfield 64	com/tencent/tbs/one/impl/common/d$a:c	I
    //   22: istore_2
    //   23: ldc_w 406
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload 7
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload 8
    //   39: aastore
    //   40: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 408	com/tencent/tbs/one/impl/c/a
    //   46: dup
    //   47: aload 8
    //   49: aload_0
    //   50: getfield 60	com/tencent/tbs/one/impl/c/b:f	Lcom/tencent/tbs/one/impl/common/d$a;
    //   53: getfield 409	com/tencent/tbs/one/impl/common/d$a:b	Ljava/lang/String;
    //   56: iload_2
    //   57: aload_0
    //   58: getfield 77	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   61: invokespecial 412	com/tencent/tbs/one/impl/c/a:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/io/File;)V
    //   64: astore 6
    //   66: aload_0
    //   67: ldc 135
    //   69: invokespecial 114	com/tencent/tbs/one/impl/c/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   72: astore 4
    //   74: aload 4
    //   76: invokevirtual 84	java/io/File:exists	()Z
    //   79: ifeq +907 -> 986
    //   82: ldc 137
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload 7
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload 8
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: aload 4
    //   102: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   105: aastore
    //   106: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: aload 4
    //   112: invokestatic 142	com/tencent/tbs/one/impl/common/e:a	(Ljava/io/File;)Lcom/tencent/tbs/one/impl/common/e;
    //   115: putfield 133	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   118: aload_0
    //   119: getfield 133	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   122: getfield 415	com/tencent/tbs/one/impl/common/e:f	[Landroid/util/Pair;
    //   125: astore 9
    //   127: aload 9
    //   129: ifnull +174 -> 303
    //   132: ldc_w 417
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload 7
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload 8
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: aload 9
    //   153: aastore
    //   154: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload 9
    //   159: arraylength
    //   160: istore_3
    //   161: iconst_0
    //   162: istore_1
    //   163: iload_1
    //   164: iload_3
    //   165: if_icmpge +158 -> 323
    //   168: aload 9
    //   170: iload_1
    //   171: aaload
    //   172: astore 4
    //   174: aload_0
    //   175: getfield 49	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   178: astore 10
    //   180: new 419	com/tencent/tbs/one/impl/common/g
    //   183: dup
    //   184: aload 8
    //   186: aload 4
    //   188: getfield 425	android/util/Pair:second	Ljava/lang/Object;
    //   191: checkcast 427	java/lang/String
    //   194: aload 4
    //   196: getfield 430	android/util/Pair:first	Ljava/lang/Object;
    //   199: checkcast 427	java/lang/String
    //   202: invokespecial 433	com/tencent/tbs/one/impl/common/g:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   205: astore 11
    //   207: aload 11
    //   209: getfield 435	com/tencent/tbs/one/impl/common/g:c	Ljava/lang/String;
    //   212: astore 12
    //   214: aload 10
    //   216: getfield 438	com/tencent/tbs/one/impl/e/h:o	Ljava/util/Map;
    //   219: aload 12
    //   221: invokeinterface 106 2 0
    //   226: checkcast 440	java/util/List
    //   229: astore 5
    //   231: aload 5
    //   233: astore 4
    //   235: aload 5
    //   237: ifnonnull +27 -> 264
    //   240: new 40	java/util/ArrayList
    //   243: dup
    //   244: invokespecial 41	java/util/ArrayList:<init>	()V
    //   247: astore 4
    //   249: aload 10
    //   251: getfield 438	com/tencent/tbs/one/impl/e/h:o	Ljava/util/Map;
    //   254: aload 12
    //   256: aload 4
    //   258: invokeinterface 189 3 0
    //   263: pop
    //   264: aload 4
    //   266: aload 11
    //   268: invokeinterface 441 2 0
    //   273: pop
    //   274: iload_1
    //   275: iconst_1
    //   276: iadd
    //   277: istore_1
    //   278: goto -115 -> 163
    //   281: astore 4
    //   283: aload_0
    //   284: aload 4
    //   286: invokevirtual 197	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   289: aload 4
    //   291: invokevirtual 200	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   294: aload 4
    //   296: invokevirtual 204	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   299: invokevirtual 207	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: return
    //   303: ldc_w 443
    //   306: iconst_2
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload 7
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload 8
    //   319: aastore
    //   320: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: aload_0
    //   324: getfield 49	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   327: getfield 235	com/tencent/tbs/one/impl/e/h:a	Landroid/content/Context;
    //   330: astore 5
    //   332: aload_0
    //   333: getfield 133	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   336: getfield 444	com/tencent/tbs/one/impl/common/e:b	Ljava/lang/String;
    //   339: astore 9
    //   341: aconst_null
    //   342: astore 4
    //   344: aload 9
    //   346: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   349: ifne +384 -> 733
    //   352: aload_0
    //   353: aload 9
    //   355: invokespecial 114	com/tencent/tbs/one/impl/c/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   358: astore 4
    //   360: ldc_w 446
    //   363: iconst_4
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload 7
    //   371: aastore
    //   372: dup
    //   373: iconst_1
    //   374: aload 8
    //   376: aastore
    //   377: dup
    //   378: iconst_2
    //   379: aload 9
    //   381: aastore
    //   382: dup
    //   383: iconst_3
    //   384: aload 4
    //   386: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   389: aastore
    //   390: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: aload 4
    //   395: invokevirtual 84	java/io/File:exists	()Z
    //   398: ifne +32 -> 430
    //   401: aload_0
    //   402: bipush 105
    //   404: new 116	java/lang/StringBuilder
    //   407: dup
    //   408: ldc_w 448
    //   411: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   414: aload 4
    //   416: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   419: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: aconst_null
    //   426: invokevirtual 207	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: return
    //   430: new 450	com/tencent/tbs/one/impl/c/b/b
    //   433: dup
    //   434: aload 5
    //   436: aload 4
    //   438: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   441: invokespecial 453	com/tencent/tbs/one/impl/c/b/b:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   444: astore 4
    //   446: aload 6
    //   448: aload 4
    //   450: putfield 454	com/tencent/tbs/one/impl/c/a:a	Landroid/content/Context;
    //   453: aload_0
    //   454: getfield 133	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   457: getfield 455	com/tencent/tbs/one/impl/common/e:c	Ljava/lang/String;
    //   460: astore 9
    //   462: aload 9
    //   464: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   467: ifne +496 -> 963
    //   470: aload_0
    //   471: aload 5
    //   473: aload 9
    //   475: invokespecial 222	com/tencent/tbs/one/impl/c/b:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   478: astore 11
    //   480: aload 6
    //   482: aload 11
    //   484: putfield 458	com/tencent/tbs/one/impl/c/a:b	Ljava/lang/ClassLoader;
    //   487: aload_0
    //   488: getfield 133	com/tencent/tbs/one/impl/c/b:m	Lcom/tencent/tbs/one/impl/common/e;
    //   491: getfield 460	com/tencent/tbs/one/impl/common/e:d	Ljava/lang/String;
    //   494: astore 10
    //   496: aload 10
    //   498: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   501: ifne +439 -> 940
    //   504: ldc_w 462
    //   507: iconst_3
    //   508: anewarray 4	java/lang/Object
    //   511: dup
    //   512: iconst_0
    //   513: aload 7
    //   515: aastore
    //   516: dup
    //   517: iconst_1
    //   518: aload 8
    //   520: aastore
    //   521: dup
    //   522: iconst_2
    //   523: aload 10
    //   525: aastore
    //   526: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   529: new 184	java/util/HashMap
    //   532: dup
    //   533: invokespecial 185	java/util/HashMap:<init>	()V
    //   536: astore 7
    //   538: aload 7
    //   540: ldc_w 464
    //   543: aload 5
    //   545: invokeinterface 189 3 0
    //   550: pop
    //   551: aload 4
    //   553: ifnull +26 -> 579
    //   556: aload 4
    //   558: getfield 467	com/tencent/tbs/one/impl/c/b/b:a	Lcom/tencent/tbs/one/impl/c/b/a;
    //   561: aload 11
    //   563: putfield 471	com/tencent/tbs/one/impl/c/b/a:a	Ljava/lang/ClassLoader;
    //   566: aload 7
    //   568: ldc_w 473
    //   571: aload 4
    //   573: invokeinterface 189 3 0
    //   578: pop
    //   579: aload 7
    //   581: ldc_w 475
    //   584: aload 11
    //   586: invokeinterface 189 3 0
    //   591: pop
    //   592: aload 7
    //   594: ldc_w 477
    //   597: aload_0
    //   598: getfield 77	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   601: invokeinterface 189 3 0
    //   606: pop
    //   607: aload 7
    //   609: ldc_w 479
    //   612: aload_0
    //   613: getfield 77	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   616: invokeinterface 189 3 0
    //   621: pop
    //   622: aload 7
    //   624: ldc_w 481
    //   627: aload_0
    //   628: aload 9
    //   630: invokespecial 156	com/tencent/tbs/one/impl/c/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   633: invokeinterface 189 3 0
    //   638: pop
    //   639: aload 7
    //   641: ldc_w 483
    //   644: aload_0
    //   645: getfield 60	com/tencent/tbs/one/impl/c/b:f	Lcom/tencent/tbs/one/impl/common/d$a;
    //   648: getfield 409	com/tencent/tbs/one/impl/common/d$a:b	Ljava/lang/String;
    //   651: invokeinterface 189 3 0
    //   656: pop
    //   657: aload 7
    //   659: ldc_w 485
    //   662: iload_2
    //   663: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   666: invokeinterface 189 3 0
    //   671: pop
    //   672: aload 7
    //   674: ldc_w 487
    //   677: aload_0
    //   678: getfield 49	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   681: getfield 491	com/tencent/tbs/one/impl/e/h:p	Lcom/tencent/tbs/one/impl/e/b;
    //   684: invokeinterface 189 3 0
    //   689: pop
    //   690: aload 6
    //   692: aload 11
    //   694: aload 10
    //   696: invokevirtual 495	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   699: iconst_1
    //   700: anewarray 497	java/lang/Class
    //   703: dup
    //   704: iconst_0
    //   705: ldc 102
    //   707: aastore
    //   708: invokevirtual 501	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   711: iconst_1
    //   712: anewarray 4	java/lang/Object
    //   715: dup
    //   716: iconst_0
    //   717: aload 7
    //   719: aastore
    //   720: invokevirtual 507	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   723: putfield 509	com/tencent/tbs/one/impl/c/a:c	Ljava/lang/Object;
    //   726: aload_0
    //   727: aload 6
    //   729: invokespecial 511	com/tencent/tbs/one/impl/c/b:a	(Lcom/tencent/tbs/one/impl/c/a;)V
    //   732: return
    //   733: ldc_w 513
    //   736: iconst_2
    //   737: anewarray 4	java/lang/Object
    //   740: dup
    //   741: iconst_0
    //   742: aload 7
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: aload 8
    //   749: aastore
    //   750: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   753: goto -300 -> 453
    //   756: astore 4
    //   758: aload_0
    //   759: aload 4
    //   761: invokevirtual 197	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   764: aload 4
    //   766: invokevirtual 200	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   769: aload 4
    //   771: invokevirtual 204	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   774: invokevirtual 207	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   777: return
    //   778: astore 4
    //   780: aload_0
    //   781: sipush 405
    //   784: new 116	java/lang/StringBuilder
    //   787: dup
    //   788: ldc_w 515
    //   791: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   794: aload 10
    //   796: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: ldc_w 517
    //   802: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: aload 9
    //   807: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: ldc_w 519
    //   813: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload 4
    //   818: invokestatic 525	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   821: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: aconst_null
    //   828: invokevirtual 207	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   831: return
    //   832: astore 4
    //   834: aload_0
    //   835: sipush 406
    //   838: new 116	java/lang/StringBuilder
    //   841: dup
    //   842: ldc_w 527
    //   845: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   848: aload 10
    //   850: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: ldc_w 529
    //   856: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 9
    //   861: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: ldc_w 519
    //   867: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload 4
    //   872: invokestatic 525	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   875: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: aconst_null
    //   882: invokevirtual 207	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   885: return
    //   886: astore 4
    //   888: aload_0
    //   889: sipush 407
    //   892: new 116	java/lang/StringBuilder
    //   895: dup
    //   896: ldc_w 531
    //   899: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   902: aload 10
    //   904: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: ldc_w 517
    //   910: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload 9
    //   915: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: ldc_w 519
    //   921: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload 4
    //   926: invokestatic 525	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   929: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: aconst_null
    //   936: invokevirtual 207	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   939: return
    //   940: ldc_w 533
    //   943: iconst_2
    //   944: anewarray 4	java/lang/Object
    //   947: dup
    //   948: iconst_0
    //   949: aload 7
    //   951: aastore
    //   952: dup
    //   953: iconst_1
    //   954: aload 8
    //   956: aastore
    //   957: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   960: goto -234 -> 726
    //   963: ldc_w 535
    //   966: iconst_2
    //   967: anewarray 4	java/lang/Object
    //   970: dup
    //   971: iconst_0
    //   972: aload 7
    //   974: aastore
    //   975: dup
    //   976: iconst_1
    //   977: aload 8
    //   979: aastore
    //   980: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   983: goto -257 -> 726
    //   986: ldc_w 537
    //   989: iconst_2
    //   990: anewarray 4	java/lang/Object
    //   993: dup
    //   994: iconst_0
    //   995: aload 7
    //   997: aastore
    //   998: dup
    //   999: iconst_1
    //   1000: aload 8
    //   1002: aastore
    //   1003: invokestatic 112	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1006: goto -280 -> 726
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1009	0	this	b
    //   162	116	1	i1	int
    //   22	641	2	i2	int
    //   160	6	3	i3	int
    //   72	193	4	localObject1	Object
    //   281	14	4	localTBSOneException1	TBSOneException
    //   342	230	4	localObject2	Object
    //   756	14	4	localTBSOneException2	TBSOneException
    //   778	39	4	localClassNotFoundException	java.lang.ClassNotFoundException
    //   832	39	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   886	39	4	localException	java.lang.Exception
    //   229	315	5	localObject3	Object
    //   64	664	6	locala	a
    //   7	989	7	localObject4	Object
    //   13	988	8	str1	String
    //   125	789	9	localObject5	Object
    //   178	725	10	localObject6	Object
    //   205	488	11	localObject7	Object
    //   212	43	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   109	118	281	com/tencent/tbs/one/TBSOneException
    //   470	480	756	com/tencent/tbs/one/TBSOneException
    //   690	726	778	java/lang/ClassNotFoundException
    //   690	726	832	java/lang/NoSuchMethodException
    //   690	726	886	java/lang/Exception
  }
  
  final void b(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i2 = -1;
    Object localObject = this.a;
    f.b("Failed to install or load component %s, error: [%d] %s", new Object[] { localObject, Integer.valueOf(paramInt), paramString });
    f.c("[%s] {%s} Failed to install or load component, error: [%d] %s", new Object[] { this.b.b, localObject, Integer.valueOf(paramInt), paramString, paramThrowable });
    d locald = this.b.l;
    if (locald != null) {}
    for (int i1 = locald.a;; i1 = -1)
    {
      if (this.f != null) {
        i2 = this.f.c;
      }
      com.tencent.tbs.one.impl.common.h.a(i1, (String)localObject, i2, paramInt, paramString, paramThrowable);
      this.b.j = true;
      this.b.k = true;
      this.b.e();
      this.i = paramInt;
      this.j = paramString;
      this.f = null;
      this.m = null;
      this.k = null;
      this.l = null;
      this.g = 0;
      this.e = false;
      paramThrowable = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
      this.c.clear();
      localObject = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
      this.d.clear();
      i2 = paramThrowable.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramThrowable[i1].onError(paramInt, paramString);
        i1 += 1;
      }
    }
    i2 = localObject.length;
    i1 = 0;
    while (i1 < i2)
    {
      localObject[i1].onError(paramInt, paramString);
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b
 * JD-Core Version:    0.7.0.1
 */