package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

public final class BuiltInsPackageFragmentImpl$Companion
{
  /* Error */
  @org.jetbrains.annotations.NotNull
  public final BuiltInsPackageFragmentImpl create(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.FqName paramFqName, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.storage.StorageManager paramStorageManager, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor paramModuleDescriptor, @org.jetbrains.annotations.NotNull java.io.InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 18
    //   3: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 26
    //   9: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: ldc 28
    //   15: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload 4
    //   20: ldc 30
    //   22: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   25: aload 4
    //   27: checkcast 32	java/io/Closeable
    //   30: astore 7
    //   32: aconst_null
    //   33: checkcast 16	java/lang/Throwable
    //   36: astore 6
    //   38: aload 6
    //   40: astore 4
    //   42: aload 7
    //   44: checkcast 34	java/io/InputStream
    //   47: astore 9
    //   49: aload 6
    //   51: astore 4
    //   53: getstatic 40	kotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion:Companion	Lkotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion$Companion;
    //   56: aload 9
    //   58: invokevirtual 46	kotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion$Companion:readFrom	(Ljava/io/InputStream;)Lkotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion;
    //   61: astore 8
    //   63: aload 8
    //   65: ifnonnull +12 -> 77
    //   68: aload 6
    //   70: astore 4
    //   72: ldc 48
    //   74: invokestatic 52	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
    //   77: aload 6
    //   79: astore 4
    //   81: aload 8
    //   83: invokevirtual 56	kotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion:isCompatible	()Z
    //   86: ifeq +52 -> 138
    //   89: aload 6
    //   91: astore 4
    //   93: aload 9
    //   95: getstatic 62	kotlin/reflect/jvm/internal/impl/serialization/deserialization/builtins/BuiltInSerializerProtocol:INSTANCE	Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/builtins/BuiltInSerializerProtocol;
    //   98: invokevirtual 66	kotlin/reflect/jvm/internal/impl/serialization/deserialization/builtins/BuiltInSerializerProtocol:getExtensionRegistry	()Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;
    //   101: invokestatic 72	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:parseFrom	(Ljava/io/InputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment;
    //   104: astore 9
    //   106: aload 7
    //   108: aload 6
    //   110: invokestatic 78	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   113: aload 9
    //   115: ldc 80
    //   117: invokestatic 83	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   120: new 85	kotlin/reflect/jvm/internal/impl/serialization/deserialization/builtins/BuiltInsPackageFragmentImpl
    //   123: dup
    //   124: aload_1
    //   125: aload_2
    //   126: aload_3
    //   127: aload 9
    //   129: aload 8
    //   131: iload 5
    //   133: aconst_null
    //   134: invokespecial 88	kotlin/reflect/jvm/internal/impl/serialization/deserialization/builtins/BuiltInsPackageFragmentImpl:<init>	(Lkotlin/reflect/jvm/internal/impl/name/FqName;Lkotlin/reflect/jvm/internal/impl/storage/StorageManager;Lkotlin/reflect/jvm/internal/impl/descriptors/ModuleDescriptor;Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment;Lkotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   137: areturn
    //   138: aload 6
    //   140: astore 4
    //   142: new 90	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   149: astore_1
    //   150: aload 6
    //   152: astore 4
    //   154: aload_1
    //   155: ldc 93
    //   157: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 6
    //   163: astore 4
    //   165: aload_1
    //   166: ldc 99
    //   168: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 6
    //   174: astore 4
    //   176: aload_1
    //   177: getstatic 102	kotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion:INSTANCE	Lkotlin/reflect/jvm/internal/impl/metadata/builtins/BuiltInsBinaryVersion;
    //   180: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 6
    //   186: astore 4
    //   188: aload_1
    //   189: ldc 107
    //   191: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 6
    //   197: astore 4
    //   199: aload_1
    //   200: aload 8
    //   202: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: astore 4
    //   210: aload_1
    //   211: ldc 109
    //   213: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 6
    //   219: astore 4
    //   221: aload_1
    //   222: ldc 111
    //   224: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 6
    //   230: astore 4
    //   232: new 113	java/lang/UnsupportedOperationException
    //   235: dup
    //   236: aload_1
    //   237: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokespecial 119	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   243: checkcast 16	java/lang/Throwable
    //   246: athrow
    //   247: astore_1
    //   248: goto +9 -> 257
    //   251: astore_1
    //   252: aload_1
    //   253: astore 4
    //   255: aload_1
    //   256: athrow
    //   257: aload 7
    //   259: aload 4
    //   261: invokestatic 78	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   264: aload_1
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	Companion
    //   0	266	1	paramFqName	kotlin.reflect.jvm.internal.impl.name.FqName
    //   0	266	2	paramStorageManager	kotlin.reflect.jvm.internal.impl.storage.StorageManager
    //   0	266	3	paramModuleDescriptor	kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    //   0	266	4	paramInputStream	java.io.InputStream
    //   0	266	5	paramBoolean	boolean
    //   36	193	6	localThrowable	java.lang.Throwable
    //   30	228	7	localCloseable	java.io.Closeable
    //   61	140	8	localBuiltInsBinaryVersion	kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion
    //   47	81	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	49	247	finally
    //   53	63	247	finally
    //   72	77	247	finally
    //   81	89	247	finally
    //   93	106	247	finally
    //   142	150	247	finally
    //   154	161	247	finally
    //   165	172	247	finally
    //   176	184	247	finally
    //   188	195	247	finally
    //   199	206	247	finally
    //   210	217	247	finally
    //   221	228	247	finally
    //   232	247	247	finally
    //   255	257	247	finally
    //   42	49	251	java/lang/Throwable
    //   53	63	251	java/lang/Throwable
    //   72	77	251	java/lang/Throwable
    //   81	89	251	java/lang/Throwable
    //   93	106	251	java/lang/Throwable
    //   142	150	251	java/lang/Throwable
    //   154	161	251	java/lang/Throwable
    //   165	172	251	java/lang/Throwable
    //   176	184	251	java/lang/Throwable
    //   188	195	251	java/lang/Throwable
    //   199	206	251	java/lang/Throwable
    //   210	217	251	java/lang/Throwable
    //   221	228	251	java/lang/Throwable
    //   232	247	251	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl.Companion
 * JD-Core Version:    0.7.0.1
 */