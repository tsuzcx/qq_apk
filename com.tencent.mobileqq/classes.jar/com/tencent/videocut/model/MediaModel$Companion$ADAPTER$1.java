package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.Companion;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/MediaModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/MediaModel;", "audiosAdapter", "", "", "Lcom/tencent/videocut/model/AudioModel;", "filterModelsAdapter", "Lcom/tencent/videocut/model/FilterModel;", "pipsAdapter", "Lcom/tencent/videocut/model/PipModel;", "specialEffectsAdapter", "Lcom/tencent/videocut/model/SpecialEffectModel;", "stickersAdapter", "Lcom/tencent/videocut/model/StickerModel;", "transitionsAdapter", "Lcom/tencent/videocut/model/TransitionModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaModel$Companion$ADAPTER$1
  extends ProtoAdapter<MediaModel>
{
  private final ProtoAdapter<Map<String, AudioModel>> a = ProtoAdapter.Companion.newMapAdapter(ProtoAdapter.STRING, AudioModel.ADAPTER);
  private final ProtoAdapter<Map<String, StickerModel>> b = ProtoAdapter.Companion.newMapAdapter(ProtoAdapter.STRING, StickerModel.ADAPTER);
  private final ProtoAdapter<Map<String, FilterModel>> c = ProtoAdapter.Companion.newMapAdapter(ProtoAdapter.STRING, FilterModel.ADAPTER);
  private final ProtoAdapter<Map<String, SpecialEffectModel>> d = ProtoAdapter.Companion.newMapAdapter(ProtoAdapter.STRING, SpecialEffectModel.ADAPTER);
  private final ProtoAdapter<Map<String, TransitionModel>> e = ProtoAdapter.Companion.newMapAdapter(ProtoAdapter.STRING, TransitionModel.ADAPTER);
  private final ProtoAdapter<Map<String, PipModel>> f = ProtoAdapter.Companion.newMapAdapter(ProtoAdapter.STRING, PipModel.ADAPTER);
  
  MediaModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramMediaModel.id) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramMediaModel.name) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramMediaModel.version) + ProtoAdapter.INT64.encodedSizeWithTag(4, paramMediaModel.createTime) + ProtoAdapter.INT64.encodedSizeWithTag(5, paramMediaModel.updateTime) + ProtoAdapter.INT64.encodedSizeWithTag(6, paramMediaModel.duration) + MediaClip.ADAPTER.asRepeated().encodedSizeWithTag(1001, paramMediaModel.videos) + this.a.encodedSizeWithTag(1002, paramMediaModel.audios) + this.b.encodedSizeWithTag(2001, paramMediaModel.stickers) + BackgroundModel.ADAPTER.encodedSizeWithTag(2002, paramMediaModel.backgroundModel) + this.c.encodedSizeWithTag(2003, paramMediaModel.filterModels) + this.d.encodedSizeWithTag(2004, paramMediaModel.specialEffects) + this.e.encodedSizeWithTag(2005, paramMediaModel.transitions) + TemplateModel.ADAPTER.encodedSizeWithTag(2006, paramMediaModel.templateModel) + this.f.encodedSizeWithTag(2007, paramMediaModel.pips) + CoverInfo.ADAPTER.encodedSizeWithTag(3001, paramMediaModel.coverInfo) + ExportSettingModel.ADAPTER.encodedSizeWithTag(4001, paramMediaModel.exportSetting) + paramMediaModel.unknownFields().size();
  }
  
  @NotNull
  public MediaModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    Object localObject2 = (Long)null;
    List localList = (List)new ArrayList();
    Map localMap5 = (Map)new LinkedHashMap();
    Map localMap6 = (Map)new LinkedHashMap();
    BackgroundModel localBackgroundModel = (BackgroundModel)null;
    Map localMap3 = (Map)new LinkedHashMap();
    Map localMap1 = (Map)new LinkedHashMap();
    Map localMap4 = (Map)new LinkedHashMap();
    TemplateModel localTemplateModel = (TemplateModel)null;
    Map localMap2 = (Map)new LinkedHashMap();
    CoverInfo localCoverInfo = (CoverInfo)null;
    ExportSettingModel localExportSettingModel = (ExportSettingModel)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    Object localObject1 = localObject2;
    Object localObject4 = localObject1;
    String str3 = str2;
    Object localObject3 = localObject2;
    localObject2 = localMap4;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new MediaModel(str2, str1, str3, (Long)localObject1, (Long)localObject4, (Long)localObject3, localList, localMap5, localMap6, localBackgroundModel, localMap3, localMap1, (Map)localObject2, localTemplateModel, localMap2, localCoverInfo, localExportSettingModel, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1001)
      {
        if (i != 1002)
        {
          if (i != 3001)
          {
            if (i != 4001) {
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  paramProtoReader.readUnknownField(i);
                  break;
                case 2007: 
                  localMap2.putAll((Map)this.f.decode(paramProtoReader));
                  break;
                case 2006: 
                  localTemplateModel = (TemplateModel)TemplateModel.ADAPTER.decode(paramProtoReader);
                  break;
                case 2005: 
                  ((Map)localObject2).putAll((Map)this.e.decode(paramProtoReader));
                  break;
                case 2004: 
                  localMap1.putAll((Map)this.d.decode(paramProtoReader));
                  break;
                case 2003: 
                  localMap3.putAll((Map)this.c.decode(paramProtoReader));
                  break;
                case 2002: 
                  localBackgroundModel = (BackgroundModel)BackgroundModel.ADAPTER.decode(paramProtoReader);
                  break;
                case 2001: 
                  localMap6.putAll((Map)this.b.decode(paramProtoReader));
                }
                break;
              case 6: 
                localObject3 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
                break;
              case 5: 
                localObject4 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
                break;
              case 4: 
                localObject1 = (Long)ProtoAdapter.INT64.decode(paramProtoReader);
                break;
              case 3: 
                str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
                break;
              case 2: 
                str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
                break;
              case 1: 
                str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
                break;
              }
            } else {
              localExportSettingModel = (ExportSettingModel)ExportSettingModel.ADAPTER.decode(paramProtoReader);
            }
          }
          else {
            localCoverInfo = (CoverInfo)CoverInfo.ADAPTER.decode(paramProtoReader);
          }
        }
        else {
          localMap5.putAll((Map)this.a.decode(paramProtoReader));
        }
      }
      else {
        localList.add(MediaClip.ADAPTER.decode(paramProtoReader));
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramMediaModel.id);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramMediaModel.name);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramMediaModel.version);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, paramMediaModel.createTime);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 5, paramMediaModel.updateTime);
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 6, paramMediaModel.duration);
    MediaClip.ADAPTER.asRepeated().encodeWithTag(paramProtoWriter, 1001, paramMediaModel.videos);
    this.a.encodeWithTag(paramProtoWriter, 1002, paramMediaModel.audios);
    this.b.encodeWithTag(paramProtoWriter, 2001, paramMediaModel.stickers);
    BackgroundModel.ADAPTER.encodeWithTag(paramProtoWriter, 2002, paramMediaModel.backgroundModel);
    this.c.encodeWithTag(paramProtoWriter, 2003, paramMediaModel.filterModels);
    this.d.encodeWithTag(paramProtoWriter, 2004, paramMediaModel.specialEffects);
    this.e.encodeWithTag(paramProtoWriter, 2005, paramMediaModel.transitions);
    TemplateModel.ADAPTER.encodeWithTag(paramProtoWriter, 2006, paramMediaModel.templateModel);
    this.f.encodeWithTag(paramProtoWriter, 2007, paramMediaModel.pips);
    CoverInfo.ADAPTER.encodeWithTag(paramProtoWriter, 3001, paramMediaModel.coverInfo);
    ExportSettingModel.ADAPTER.encodeWithTag(paramProtoWriter, 4001, paramMediaModel.exportSetting);
    paramProtoWriter.writeBytes(paramMediaModel.unknownFields());
  }
  
  @NotNull
  public MediaModel b(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "value");
    List localList = Internal.-redactElements(paramMediaModel.videos, MediaClip.ADAPTER);
    Map localMap1 = Internal.-redactElements(paramMediaModel.audios, AudioModel.ADAPTER);
    Map localMap2 = Internal.-redactElements(paramMediaModel.stickers, StickerModel.ADAPTER);
    BackgroundModel localBackgroundModel = paramMediaModel.backgroundModel;
    if (localBackgroundModel != null) {
      localBackgroundModel = (BackgroundModel)BackgroundModel.ADAPTER.redact(localBackgroundModel);
    } else {
      localBackgroundModel = null;
    }
    Map localMap3 = Internal.-redactElements(paramMediaModel.filterModels, FilterModel.ADAPTER);
    Map localMap4 = Internal.-redactElements(paramMediaModel.specialEffects, SpecialEffectModel.ADAPTER);
    Map localMap5 = Internal.-redactElements(paramMediaModel.transitions, TransitionModel.ADAPTER);
    TemplateModel localTemplateModel = paramMediaModel.templateModel;
    if (localTemplateModel != null) {
      localTemplateModel = (TemplateModel)TemplateModel.ADAPTER.redact(localTemplateModel);
    } else {
      localTemplateModel = null;
    }
    Map localMap6 = Internal.-redactElements(paramMediaModel.pips, PipModel.ADAPTER);
    CoverInfo localCoverInfo = paramMediaModel.coverInfo;
    if (localCoverInfo != null) {
      localCoverInfo = (CoverInfo)CoverInfo.ADAPTER.redact(localCoverInfo);
    } else {
      localCoverInfo = null;
    }
    ExportSettingModel localExportSettingModel = paramMediaModel.exportSetting;
    if (localExportSettingModel != null) {
      localExportSettingModel = (ExportSettingModel)ExportSettingModel.ADAPTER.redact(localExportSettingModel);
    } else {
      localExportSettingModel = null;
    }
    return MediaModel.copy$default(paramMediaModel, null, null, null, null, null, null, localList, localMap1, localMap2, localBackgroundModel, localMap3, localMap4, localMap5, localTemplateModel, localMap6, localCoverInfo, localExportSettingModel, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */