package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/ScreenTransform$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ScreenTransform$Companion$ADAPTER$1
  extends ProtoAdapter<ScreenTransform>
{
  ScreenTransform$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public ScreenTransform decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean1 = (Boolean)null;
    String str = (String)null;
    Rect localRect1 = (Rect)null;
    Vec2 localVec2 = (Vec2)null;
    Vec3 localVec31 = (Vec3)null;
    Quat localQuat = (Quat)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    Integer localInteger4 = localInteger3;
    Integer localInteger5 = localInteger4;
    Integer localInteger6 = localInteger5;
    Boolean localBoolean2 = localBoolean1;
    Boolean localBoolean3 = localBoolean2;
    Rect localRect2 = localRect1;
    Vec3 localVec32 = localVec31;
    Vec3 localVec33 = localVec32;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new ScreenTransform(localInteger1, localInteger2, localBoolean1, str, localRect1, localRect2, localVec2, localInteger3, localInteger4, localInteger5, localBoolean2, localVec31, localQuat, localVec32, localVec33, localBoolean3, localInteger6, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 17: 
        localInteger6 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 16: 
        localBoolean3 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 15: 
        localVec33 = (Vec3)Vec3.ADAPTER.decode(paramProtoReader);
        break;
      case 14: 
        localVec32 = (Vec3)Vec3.ADAPTER.decode(paramProtoReader);
        break;
      case 13: 
        localQuat = (Quat)Quat.ADAPTER.decode(paramProtoReader);
        break;
      case 12: 
        localVec31 = (Vec3)Vec3.ADAPTER.decode(paramProtoReader);
        break;
      case 11: 
        localBoolean2 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 10: 
        localInteger5 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 9: 
        localInteger4 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 8: 
        localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 7: 
        localVec2 = (Vec2)Vec2.ADAPTER.decode(paramProtoReader);
        break;
      case 6: 
        localRect2 = (Rect)Rect.ADAPTER.decode(paramProtoReader);
        break;
      case 5: 
        localRect1 = (Rect)Rect.ADAPTER.decode(paramProtoReader);
        break;
      case 4: 
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        localBoolean1 = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 2: 
        localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        break;
      case 1: 
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull ScreenTransform paramScreenTransform)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramScreenTransform.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramScreenTransform.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramScreenTransform.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramScreenTransform.type);
    Rect.ADAPTER.encodeWithTag(paramProtoWriter, 5, paramScreenTransform.anchor);
    Rect.ADAPTER.encodeWithTag(paramProtoWriter, 6, paramScreenTransform.offset);
    Vec2.ADAPTER.encodeWithTag(paramProtoWriter, 7, paramScreenTransform.pivot);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 8, paramScreenTransform.ePinToEdge);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 9, paramScreenTransform.eFixSize);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 10, paramScreenTransform.eEditingMode);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 11, paramScreenTransform.eKeepRatio);
    Vec3.ADAPTER.encodeWithTag(paramProtoWriter, 12, paramScreenTransform.position);
    Quat.ADAPTER.encodeWithTag(paramProtoWriter, 13, paramScreenTransform.rotation);
    Vec3.ADAPTER.encodeWithTag(paramProtoWriter, 14, paramScreenTransform.scale);
    Vec3.ADAPTER.encodeWithTag(paramProtoWriter, 15, paramScreenTransform.euler);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 16, paramScreenTransform.objectEnabled);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 17, paramScreenTransform.version);
    paramProtoWriter.writeBytes(paramScreenTransform.unknownFields());
  }
  
  public int encodedSize(@NotNull ScreenTransform paramScreenTransform)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramScreenTransform.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramScreenTransform.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramScreenTransform.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramScreenTransform.type) + Rect.ADAPTER.encodedSizeWithTag(5, paramScreenTransform.anchor) + Rect.ADAPTER.encodedSizeWithTag(6, paramScreenTransform.offset) + Vec2.ADAPTER.encodedSizeWithTag(7, paramScreenTransform.pivot) + ProtoAdapter.INT32.encodedSizeWithTag(8, paramScreenTransform.ePinToEdge) + ProtoAdapter.INT32.encodedSizeWithTag(9, paramScreenTransform.eFixSize) + ProtoAdapter.INT32.encodedSizeWithTag(10, paramScreenTransform.eEditingMode) + ProtoAdapter.BOOL.encodedSizeWithTag(11, paramScreenTransform.eKeepRatio) + Vec3.ADAPTER.encodedSizeWithTag(12, paramScreenTransform.position) + Quat.ADAPTER.encodedSizeWithTag(13, paramScreenTransform.rotation) + Vec3.ADAPTER.encodedSizeWithTag(14, paramScreenTransform.scale) + Vec3.ADAPTER.encodedSizeWithTag(15, paramScreenTransform.euler) + ProtoAdapter.BOOL.encodedSizeWithTag(16, paramScreenTransform.objectEnabled) + ProtoAdapter.INT32.encodedSizeWithTag(17, paramScreenTransform.version) + paramScreenTransform.unknownFields().size();
  }
  
  @NotNull
  public ScreenTransform redact(@NotNull ScreenTransform paramScreenTransform)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenTransform, "value");
    Rect localRect1 = paramScreenTransform.anchor;
    if (localRect1 != null) {
      localRect1 = (Rect)Rect.ADAPTER.redact(localRect1);
    } else {
      localRect1 = null;
    }
    Rect localRect2 = paramScreenTransform.offset;
    if (localRect2 != null) {
      localRect2 = (Rect)Rect.ADAPTER.redact(localRect2);
    } else {
      localRect2 = null;
    }
    Vec2 localVec2 = paramScreenTransform.pivot;
    if (localVec2 != null) {
      localVec2 = (Vec2)Vec2.ADAPTER.redact(localVec2);
    } else {
      localVec2 = null;
    }
    Vec3 localVec31 = paramScreenTransform.position;
    if (localVec31 != null) {
      localVec31 = (Vec3)Vec3.ADAPTER.redact(localVec31);
    } else {
      localVec31 = null;
    }
    Quat localQuat = paramScreenTransform.rotation;
    if (localQuat != null) {
      localQuat = (Quat)Quat.ADAPTER.redact(localQuat);
    } else {
      localQuat = null;
    }
    Vec3 localVec32 = paramScreenTransform.scale;
    if (localVec32 != null) {
      localVec32 = (Vec3)Vec3.ADAPTER.redact(localVec32);
    } else {
      localVec32 = null;
    }
    Vec3 localVec33 = paramScreenTransform.euler;
    if (localVec33 != null) {
      localVec33 = (Vec3)Vec3.ADAPTER.redact(localVec33);
    } else {
      localVec33 = null;
    }
    return ScreenTransform.copy$default(paramScreenTransform, null, null, null, null, localRect1, localRect2, localVec2, null, null, null, null, localVec31, localQuat, localVec32, localVec33, null, null, ByteString.EMPTY, 100239, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.ScreenTransform.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */