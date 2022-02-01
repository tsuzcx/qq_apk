package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.util.Log;

public class RSACrypt
{
  protected static final String DEFAULT_PRIV_KEY = "3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9";
  public static final String DEFAULT_PUB_KEY = "30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001";
  private Context _context;
  private byte[] _priv_key = new byte[0];
  private byte[] _pub_key = new byte[0];
  
  public RSACrypt(Context paramContext)
  {
    this._context = paramContext;
    try
    {
      util.loadLibrary("wtecdh", this._context);
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  private native byte[] decryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native byte[] encryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native int genrsakey();
  
  public byte[] DecryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject2 = null;
    if (paramArrayOfByte2 == null)
    {
      util.LOGI("DecryptData data is null", "");
      return null;
    }
    Object localObject1 = paramArrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = util.get_rsa_privkey(this._context);
      if (paramArrayOfByte1 != null)
      {
        localObject1 = paramArrayOfByte1;
        if (paramArrayOfByte1.length != 0) {}
      }
      else
      {
        localObject1 = util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9");
      }
    }
    try
    {
      localObject3 = decryptdata((byte[])localObject1, paramArrayOfByte2);
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        paramArrayOfByte1 = (byte[])localObject3;
        if (localObject3.length != 0) {}
      }
      else
      {
        localObject2 = localObject3;
        paramArrayOfByte1 = decryptdata(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9"), paramArrayOfByte2);
      }
    }
    catch (UnsatisfiedLinkError paramArrayOfByte1)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("DecryptData UnsatisfiedLinkError ");
      ((StringBuilder)localObject3).append(Log.getStackTraceString(paramArrayOfByte1));
      util.LOGI(((StringBuilder)localObject3).toString(), "");
      paramArrayOfByte1 = (byte[])localObject2;
    }
    localObject2 = paramArrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      try
      {
        localObject1 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI((byte[])localObject1));
        paramArrayOfByte1 = (byte[])localObject1;
        try
        {
          localObject2 = new StringBuilder();
          paramArrayOfByte1 = (byte[])localObject1;
          ((StringBuilder)localObject2).append("dedata first:");
          int j = 0;
          int i;
          if (localObject1 == null)
          {
            i = 0;
          }
          else
          {
            paramArrayOfByte1 = (byte[])localObject1;
            i = localObject1.length;
          }
          paramArrayOfByte1 = (byte[])localObject1;
          ((StringBuilder)localObject2).append(i);
          paramArrayOfByte1 = (byte[])localObject1;
          util.LOGI(((StringBuilder)localObject2).toString(), "");
          if (localObject1 != null)
          {
            paramArrayOfByte1 = (byte[])localObject1;
            localObject2 = localObject1;
            if (localObject1.length != 0) {
              break label369;
            }
          }
          paramArrayOfByte1 = (byte[])localObject1;
          localObject2 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9")));
          paramArrayOfByte1 = (byte[])localObject2;
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte1 = (byte[])localObject2;
          paramArrayOfByte2.append("dedata second:");
          if (localObject2 == null)
          {
            i = j;
          }
          else
          {
            paramArrayOfByte1 = (byte[])localObject2;
            i = localObject2.length;
          }
          paramArrayOfByte1 = (byte[])localObject2;
          paramArrayOfByte2.append(i);
          paramArrayOfByte1 = (byte[])localObject2;
          util.LOGI(paramArrayOfByte2.toString(), "");
        }
        catch (Exception paramArrayOfByte2) {}
        localObject1 = new StringBuilder();
      }
      catch (Exception paramArrayOfByte2) {}
      ((StringBuilder)localObject1).append("DecryptData java decrypt exception ");
      ((StringBuilder)localObject1).append(paramArrayOfByte2.toString());
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      localObject2 = paramArrayOfByte1;
    }
    else
    {
      return localObject2;
    }
    label369:
    return localObject2;
  }
  
  public byte[] EncryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramArrayOfByte1 != null) {
      if (paramArrayOfByte2 == null) {
        return null;
      }
    }
    try
    {
      localObject1 = encryptdata(paramArrayOfByte1, paramArrayOfByte2);
      localObject2 = localObject1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label25:
      break label25;
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = util.RSAEncrypt(paramArrayOfByte2, util.RSAPubKeyFromJNI(paramArrayOfByte1));
    }
    return localObject1;
  }
  
  /* Error */
  public int GenRSAKey()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   4: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   13: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   16: astore 6
    //   18: iconst_0
    //   19: istore_2
    //   20: iconst_0
    //   21: istore_3
    //   22: iconst_0
    //   23: istore 4
    //   25: iconst_0
    //   26: istore_1
    //   27: aload 5
    //   29: ifnull +46 -> 75
    //   32: aload 5
    //   34: arraylength
    //   35: ifle +40 -> 75
    //   38: aload 6
    //   40: ifnull +35 -> 75
    //   43: aload 6
    //   45: arraylength
    //   46: ifle +29 -> 75
    //   49: aload_0
    //   50: aload 5
    //   52: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   55: checkcast 115	[B
    //   58: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   67: checkcast 115	[B
    //   70: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   73: iconst_0
    //   74: ireturn
    //   75: ldc 2
    //   77: monitorenter
    //   78: aload_0
    //   79: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   82: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   91: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   94: astore 6
    //   96: aload 5
    //   98: ifnull +56 -> 154
    //   101: aload 5
    //   103: arraylength
    //   104: ifle +50 -> 154
    //   107: aload 6
    //   109: ifnull +45 -> 154
    //   112: aload 6
    //   114: arraylength
    //   115: ifle +39 -> 154
    //   118: aload_0
    //   119: aload 5
    //   121: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   124: checkcast 115	[B
    //   127: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   130: aload_0
    //   131: aload 6
    //   133: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   136: checkcast 115	[B
    //   139: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   142: ldc 121
    //   144: ldc 50
    //   146: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iconst_1
    //   150: istore_2
    //   151: goto +51 -> 202
    //   154: ldc 123
    //   156: ldc 50
    //   158: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: invokespecial 125	oicq/wlogin_sdk/tools/RSACrypt:genrsakey	()I
    //   165: istore_1
    //   166: new 66	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   173: astore 5
    //   175: aload 5
    //   177: ldc 127
    //   179: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: iload_1
    //   186: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 5
    //   192: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: ldc 50
    //   197: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iconst_0
    //   201: istore_2
    //   202: ldc 2
    //   204: monitorexit
    //   205: iload_2
    //   206: ifeq +5 -> 211
    //   209: iload_1
    //   210: ireturn
    //   211: ldc 2
    //   213: monitorenter
    //   214: aload_0
    //   215: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   218: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   227: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   230: astore 6
    //   232: aload 5
    //   234: ifnull +54 -> 288
    //   237: aload 5
    //   239: arraylength
    //   240: ifle +48 -> 288
    //   243: aload 6
    //   245: ifnull +43 -> 288
    //   248: aload 6
    //   250: arraylength
    //   251: ifle +37 -> 288
    //   254: aload_0
    //   255: aload 5
    //   257: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   260: checkcast 115	[B
    //   263: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   266: aload_0
    //   267: aload 6
    //   269: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   272: checkcast 115	[B
    //   275: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   278: ldc 129
    //   280: ldc 50
    //   282: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto +39 -> 324
    //   288: ldc 131
    //   290: ldc 50
    //   292: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   299: aload_0
    //   300: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   303: invokestatic 135	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   306: aload_0
    //   307: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   310: aload_0
    //   311: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   314: invokestatic 138	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   317: ldc 140
    //   319: ldc 50
    //   321: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: ldc 2
    //   326: monitorexit
    //   327: iload_1
    //   328: ireturn
    //   329: astore 5
    //   331: ldc 2
    //   333: monitorexit
    //   334: aload 5
    //   336: athrow
    //   337: astore 5
    //   339: goto +12 -> 351
    //   342: astore 5
    //   344: goto +7 -> 351
    //   347: astore 5
    //   349: iconst_0
    //   350: istore_1
    //   351: ldc 2
    //   353: monitorexit
    //   354: iload_2
    //   355: istore_3
    //   356: iload_1
    //   357: istore 4
    //   359: aload 5
    //   361: athrow
    //   362: astore 5
    //   364: goto -13 -> 351
    //   367: astore 5
    //   369: iconst_0
    //   370: istore_1
    //   371: iload 4
    //   373: istore_3
    //   374: iload_1
    //   375: istore 4
    //   377: goto +200 -> 577
    //   380: iconst_0
    //   381: istore_1
    //   382: iload_3
    //   383: istore_2
    //   384: iload_2
    //   385: istore_3
    //   386: iload_1
    //   387: istore 4
    //   389: invokestatic 144	oicq/wlogin_sdk/tools/util:generateRSAKeyPair	()Ljava/security/KeyPair;
    //   392: astore 5
    //   394: aload 5
    //   396: ifnull +47 -> 443
    //   399: iload_2
    //   400: istore_3
    //   401: iload_1
    //   402: istore 4
    //   404: aload_0
    //   405: aload 5
    //   407: invokevirtual 150	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   410: invokeinterface 156 1 0
    //   415: invokestatic 160	oicq/wlogin_sdk/tools/util:RSAPubKeyFromJava	([B)[B
    //   418: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   421: iload_2
    //   422: istore_3
    //   423: iload_1
    //   424: istore 4
    //   426: aload_0
    //   427: aload 5
    //   429: invokevirtual 164	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   432: invokeinterface 167 1 0
    //   437: invokestatic 170	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJava	([B)[B
    //   440: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   443: iload_2
    //   444: ifeq +5 -> 449
    //   447: iload_1
    //   448: ireturn
    //   449: ldc 2
    //   451: monitorenter
    //   452: aload_0
    //   453: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   456: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   459: astore 5
    //   461: aload_0
    //   462: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   465: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   468: astore 6
    //   470: aload 5
    //   472: ifnull +54 -> 526
    //   475: aload 5
    //   477: arraylength
    //   478: ifle +48 -> 526
    //   481: aload 6
    //   483: ifnull +43 -> 526
    //   486: aload 6
    //   488: arraylength
    //   489: ifle +37 -> 526
    //   492: aload_0
    //   493: aload 5
    //   495: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   498: checkcast 115	[B
    //   501: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   504: aload_0
    //   505: aload 6
    //   507: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   510: checkcast 115	[B
    //   513: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   516: ldc 129
    //   518: ldc 50
    //   520: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: goto +39 -> 562
    //   526: ldc 131
    //   528: ldc 50
    //   530: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   537: aload_0
    //   538: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   541: invokestatic 135	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   544: aload_0
    //   545: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   548: aload_0
    //   549: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   552: invokestatic 138	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   555: ldc 140
    //   557: ldc 50
    //   559: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: ldc 2
    //   564: monitorexit
    //   565: iload_1
    //   566: ireturn
    //   567: astore 5
    //   569: ldc 2
    //   571: monitorexit
    //   572: aload 5
    //   574: athrow
    //   575: astore 5
    //   577: iload_3
    //   578: ifeq +6 -> 584
    //   581: iload 4
    //   583: ireturn
    //   584: ldc 2
    //   586: monitorenter
    //   587: aload_0
    //   588: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   591: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   594: astore 6
    //   596: aload_0
    //   597: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   600: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   603: astore 7
    //   605: aload 6
    //   607: ifnull +54 -> 661
    //   610: aload 6
    //   612: arraylength
    //   613: ifle +48 -> 661
    //   616: aload 7
    //   618: ifnull +43 -> 661
    //   621: aload 7
    //   623: arraylength
    //   624: ifle +37 -> 661
    //   627: aload_0
    //   628: aload 6
    //   630: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   633: checkcast 115	[B
    //   636: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   639: aload_0
    //   640: aload 7
    //   642: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   645: checkcast 115	[B
    //   648: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   651: ldc 129
    //   653: ldc 50
    //   655: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: goto +39 -> 697
    //   661: ldc 131
    //   663: ldc 50
    //   665: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload_0
    //   669: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   672: aload_0
    //   673: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   676: invokestatic 135	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   679: aload_0
    //   680: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   683: aload_0
    //   684: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   687: invokestatic 138	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   690: ldc 140
    //   692: ldc 50
    //   694: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: ldc 2
    //   699: monitorexit
    //   700: aload 5
    //   702: athrow
    //   703: astore 5
    //   705: ldc 2
    //   707: monitorexit
    //   708: goto +6 -> 714
    //   711: aload 5
    //   713: athrow
    //   714: goto -3 -> 711
    //   717: astore 5
    //   719: goto -339 -> 380
    //   722: astore 5
    //   724: goto -340 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	this	RSACrypt
    //   26	540	1	i	int
    //   19	425	2	j	int
    //   21	557	3	k	int
    //   23	559	4	m	int
    //   7	249	5	localObject1	Object
    //   329	6	5	localObject2	Object
    //   337	1	5	localObject3	Object
    //   342	1	5	localObject4	Object
    //   347	13	5	localObject5	Object
    //   362	1	5	localObject6	Object
    //   367	1	5	localObject7	Object
    //   392	102	5	localObject8	Object
    //   567	6	5	localObject9	Object
    //   575	126	5	localObject10	Object
    //   703	9	5	localObject11	Object
    //   717	1	5	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   722	1	5	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   16	613	6	arrayOfByte1	byte[]
    //   603	38	7	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   214	232	329	finally
    //   237	243	329	finally
    //   248	285	329	finally
    //   288	324	329	finally
    //   324	327	329	finally
    //   331	334	329	finally
    //   202	205	337	finally
    //   166	200	342	finally
    //   78	96	347	finally
    //   101	107	347	finally
    //   112	149	347	finally
    //   154	166	347	finally
    //   351	354	362	finally
    //   75	78	367	finally
    //   452	470	567	finally
    //   475	481	567	finally
    //   486	523	567	finally
    //   526	562	567	finally
    //   562	565	567	finally
    //   569	572	567	finally
    //   359	362	575	finally
    //   389	394	575	finally
    //   404	421	575	finally
    //   426	443	575	finally
    //   587	605	703	finally
    //   610	616	703	finally
    //   621	658	703	finally
    //   661	697	703	finally
    //   697	700	703	finally
    //   705	708	703	finally
    //   75	78	717	java/lang/UnsatisfiedLinkError
    //   359	362	722	java/lang/UnsatisfiedLinkError
  }
  
  public byte[] get_priv_key()
  {
    return this._priv_key;
  }
  
  public byte[] get_pub_key()
  {
    return this._pub_key;
  }
  
  public void set_priv_key(byte[] paramArrayOfByte)
  {
    this._priv_key = paramArrayOfByte;
  }
  
  public void set_pub_key(byte[] paramArrayOfByte)
  {
    this._pub_key = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.RSACrypt
 * JD-Core Version:    0.7.0.1
 */