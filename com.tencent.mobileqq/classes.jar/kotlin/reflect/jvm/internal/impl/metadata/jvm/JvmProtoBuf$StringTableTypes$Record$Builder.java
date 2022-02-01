package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class JvmProtoBuf$StringTableTypes$Record$Builder
  extends GeneratedMessageLite.Builder<JvmProtoBuf.StringTableTypes.Record, Builder>
  implements JvmProtoBuf.StringTableTypes.RecordOrBuilder
{
  private int bitField0_;
  private JvmProtoBuf.StringTableTypes.Record.Operation operation_ = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
  private int predefinedIndex_;
  private int range_ = 1;
  private List<Integer> replaceChar_ = Collections.emptyList();
  private Object string_ = "";
  private List<Integer> substringIndex_ = Collections.emptyList();
  
  private JvmProtoBuf$StringTableTypes$Record$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureReplaceCharIsMutable()
  {
    if ((this.bitField0_ & 0x20) != 32)
    {
      this.replaceChar_ = new ArrayList(this.replaceChar_);
      this.bitField0_ |= 0x20;
    }
  }
  
  private void ensureSubstringIndexIsMutable()
  {
    if ((this.bitField0_ & 0x10) != 16)
    {
      this.substringIndex_ = new ArrayList(this.substringIndex_);
      this.bitField0_ |= 0x10;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public JvmProtoBuf.StringTableTypes.Record build()
  {
    JvmProtoBuf.StringTableTypes.Record localRecord = buildPartial();
    if (localRecord.isInitialized()) {
      return localRecord;
    }
    throw newUninitializedMessageException(localRecord);
  }
  
  public JvmProtoBuf.StringTableTypes.Record buildPartial()
  {
    JvmProtoBuf.StringTableTypes.Record localRecord = new JvmProtoBuf.StringTableTypes.Record(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    JvmProtoBuf.StringTableTypes.Record.access$402(localRecord, this.range_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    JvmProtoBuf.StringTableTypes.Record.access$502(localRecord, this.predefinedIndex_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    JvmProtoBuf.StringTableTypes.Record.access$602(localRecord, this.string_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    JvmProtoBuf.StringTableTypes.Record.access$702(localRecord, this.operation_);
    if ((this.bitField0_ & 0x10) == 16)
    {
      this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
      this.bitField0_ &= 0xFFFFFFEF;
    }
    JvmProtoBuf.StringTableTypes.Record.access$802(localRecord, this.substringIndex_);
    if ((this.bitField0_ & 0x20) == 32)
    {
      this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
      this.bitField0_ &= 0xFFFFFFDF;
    }
    JvmProtoBuf.StringTableTypes.Record.access$902(localRecord, this.replaceChar_);
    JvmProtoBuf.StringTableTypes.Record.access$1002(localRecord, i);
    return localRecord;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public JvmProtoBuf.StringTableTypes.Record getDefaultInstanceForType()
  {
    return JvmProtoBuf.StringTableTypes.Record.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(JvmProtoBuf.StringTableTypes.Record paramRecord)
  {
    if (paramRecord == JvmProtoBuf.StringTableTypes.Record.getDefaultInstance()) {
      return this;
    }
    if (paramRecord.hasRange()) {
      setRange(paramRecord.getRange());
    }
    if (paramRecord.hasPredefinedIndex()) {
      setPredefinedIndex(paramRecord.getPredefinedIndex());
    }
    if (paramRecord.hasString())
    {
      this.bitField0_ |= 0x4;
      this.string_ = JvmProtoBuf.StringTableTypes.Record.access$600(paramRecord);
    }
    if (paramRecord.hasOperation()) {
      setOperation(paramRecord.getOperation());
    }
    if (!JvmProtoBuf.StringTableTypes.Record.access$800(paramRecord).isEmpty()) {
      if (this.substringIndex_.isEmpty())
      {
        this.substringIndex_ = JvmProtoBuf.StringTableTypes.Record.access$800(paramRecord);
        this.bitField0_ &= 0xFFFFFFEF;
      }
      else
      {
        ensureSubstringIndexIsMutable();
        this.substringIndex_.addAll(JvmProtoBuf.StringTableTypes.Record.access$800(paramRecord));
      }
    }
    if (!JvmProtoBuf.StringTableTypes.Record.access$900(paramRecord).isEmpty()) {
      if (this.replaceChar_.isEmpty())
      {
        this.replaceChar_ = JvmProtoBuf.StringTableTypes.Record.access$900(paramRecord);
        this.bitField0_ &= 0xFFFFFFDF;
      }
      else
      {
        ensureReplaceCharIsMutable();
        this.replaceChar_.addAll(JvmProtoBuf.StringTableTypes.Record.access$900(paramRecord));
      }
    }
    setUnknownFields(getUnknownFields().concat(JvmProtoBuf.StringTableTypes.Record.access$1100(paramRecord)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 217	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 223 3 0
    //   12: checkcast 72	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 125	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 226	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 72	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 125	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Builder;
    //   55: pop
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	Builder
    //   0	58	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	58	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   1	29	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   35	43	28	finally
    //   2	16	34	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   43	45	45	finally
  }
  
  public Builder setOperation(JvmProtoBuf.StringTableTypes.Record.Operation paramOperation)
  {
    if (paramOperation != null)
    {
      this.bitField0_ |= 0x8;
      this.operation_ = paramOperation;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder setPredefinedIndex(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.predefinedIndex_ = paramInt;
    return this;
  }
  
  public Builder setRange(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.range_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Builder
 * JD-Core Version:    0.7.0.1
 */