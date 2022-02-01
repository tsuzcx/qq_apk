package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$VersionRequirement$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.VersionRequirement, Builder>
  implements ProtoBuf.VersionRequirementOrBuilder
{
  private int bitField0_;
  private int errorCode_;
  private ProtoBuf.VersionRequirement.Level level_ = ProtoBuf.VersionRequirement.Level.ERROR;
  private int message_;
  private int versionFull_;
  private ProtoBuf.VersionRequirement.VersionKind versionKind_ = ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
  private int version_;
  
  private ProtoBuf$VersionRequirement$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.VersionRequirement build()
  {
    ProtoBuf.VersionRequirement localVersionRequirement = buildPartial();
    if (localVersionRequirement.isInitialized()) {
      return localVersionRequirement;
    }
    throw newUninitializedMessageException(localVersionRequirement);
  }
  
  public ProtoBuf.VersionRequirement buildPartial()
  {
    ProtoBuf.VersionRequirement localVersionRequirement = new ProtoBuf.VersionRequirement(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.VersionRequirement.access$20002(localVersionRequirement, this.version_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.VersionRequirement.access$20102(localVersionRequirement, this.versionFull_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.VersionRequirement.access$20202(localVersionRequirement, this.level_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    ProtoBuf.VersionRequirement.access$20302(localVersionRequirement, this.errorCode_);
    j = i;
    if ((k & 0x10) == 16) {
      j = i | 0x10;
    }
    ProtoBuf.VersionRequirement.access$20402(localVersionRequirement, this.message_);
    i = j;
    if ((k & 0x20) == 32) {
      i = j | 0x20;
    }
    ProtoBuf.VersionRequirement.access$20502(localVersionRequirement, this.versionKind_);
    ProtoBuf.VersionRequirement.access$20602(localVersionRequirement, i);
    return localVersionRequirement;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.VersionRequirement getDefaultInstanceForType()
  {
    return ProtoBuf.VersionRequirement.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.VersionRequirement paramVersionRequirement)
  {
    if (paramVersionRequirement == ProtoBuf.VersionRequirement.getDefaultInstance()) {
      return this;
    }
    if (paramVersionRequirement.hasVersion()) {
      setVersion(paramVersionRequirement.getVersion());
    }
    if (paramVersionRequirement.hasVersionFull()) {
      setVersionFull(paramVersionRequirement.getVersionFull());
    }
    if (paramVersionRequirement.hasLevel()) {
      setLevel(paramVersionRequirement.getLevel());
    }
    if (paramVersionRequirement.hasErrorCode()) {
      setErrorCode(paramVersionRequirement.getErrorCode());
    }
    if (paramVersionRequirement.hasMessage()) {
      setMessage(paramVersionRequirement.getMessage());
    }
    if (paramVersionRequirement.hasVersionKind()) {
      setVersionKind(paramVersionRequirement.getVersionKind());
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.VersionRequirement.access$20700(paramVersionRequirement)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 202	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 208 3 0
    //   12: checkcast 52	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 108	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 211	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 52	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 108	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$Builder;
    //   55: pop
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	Builder
    //   0	58	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	58	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   1	29	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   35	43	28	finally
    //   2	16	34	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   43	45	45	finally
  }
  
  public Builder setErrorCode(int paramInt)
  {
    this.bitField0_ |= 0x8;
    this.errorCode_ = paramInt;
    return this;
  }
  
  public Builder setLevel(ProtoBuf.VersionRequirement.Level paramLevel)
  {
    if (paramLevel != null)
    {
      this.bitField0_ |= 0x4;
      this.level_ = paramLevel;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder setMessage(int paramInt)
  {
    this.bitField0_ |= 0x10;
    this.message_ = paramInt;
    return this;
  }
  
  public Builder setVersion(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.version_ = paramInt;
    return this;
  }
  
  public Builder setVersionFull(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.versionFull_ = paramInt;
    return this;
  }
  
  public Builder setVersionKind(ProtoBuf.VersionRequirement.VersionKind paramVersionKind)
  {
    if (paramVersionKind != null)
    {
      this.bitField0_ |= 0x20;
      this.versionKind_ = paramVersionKind;
      return this;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Builder
 * JD-Core Version:    0.7.0.1
 */