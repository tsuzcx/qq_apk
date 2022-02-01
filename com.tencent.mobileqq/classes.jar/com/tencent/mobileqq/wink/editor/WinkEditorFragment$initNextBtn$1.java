package com.tencent.mobileqq.wink.editor;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra;
import com.tencent.mobileqq.wink.editor.export.WinkExportViewModel;
import com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel;
import com.tencent.mobileqq.wink.editor.text.TextMetaMaterialKt;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$initNextBtn$1
  implements View.OnClickListener
{
  WinkEditorFragment$initNextBtn$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void onClick(View paramView)
  {
    Object localObject3 = WinkEditorFragment.c(this.a).h();
    int i = WinkEditorFragment.c(this.a).q();
    Object localObject4 = WinkEditorFragment.c(this.a).g();
    int j = WinkEditorFragment.c(this.a).t();
    Object localObject1 = WinkEditorFragment.d(this.a);
    Object localObject5 = null;
    if (localObject1 != null) {
      localObject1 = ((WinkTavCutDelegate)localObject1).i();
    } else {
      localObject1 = null;
    }
    Object localObject2 = WinkEditorFragment.d(this.a);
    long l;
    if (localObject2 != null) {
      l = ((WinkTavCutDelegate)localObject2).e();
    } else {
      l = 0L;
    }
    boolean bool = WinkEditorFragment.c(this.a).l();
    localObject2 = WinkEditorFragment.e(this.a);
    if (localObject2 != null)
    {
      localObject2 = ((MusicSourceViewModel)localObject2).h();
      if (localObject2 != null)
      {
        localObject2 = ((WinkEditorMusicInfo)localObject2).c();
        break label158;
      }
    }
    localObject2 = null;
    label158:
    WinkEditDataWrapper localWinkEditDataWrapper = new WinkEditDataWrapper((String)localObject3, Integer.valueOf(i), null, (ArrayList)localObject4, (String)localObject1, Integer.valueOf(j), null, l, bool, (String)localObject2, 68, null);
    localObject1 = WinkEditorFragment.d(this.a);
    Object localObject7;
    Object localObject6;
    if (localObject1 != null)
    {
      localObject1 = ((WinkTavCutDelegate)localObject1).j();
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WinkEditData)((Iterator)localObject1).next();
          localObject3 = (Map)new LinkedHashMap();
          localObject4 = ((WinkEditData)localObject2).getStickerModelMap();
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject7 = (Map.Entry)((Iterator)localObject4).next();
              localObject6 = (String)((Map.Entry)localObject7).getKey();
              localObject7 = (WinkStickerModel)((Map.Entry)localObject7).getValue();
              ((Map)localObject3).put(localObject6, new WinkStickerModelExtra(((WinkStickerModel)localObject7).getInitStickerScale(), ((WinkStickerModel)localObject7).getDownScaleRecord(), ((WinkStickerModel)localObject7).getOriginPointInView(), ((WinkStickerModel)localObject7).getSizeInView(), ((WinkStickerModel)localObject7).getCenterInView(), ((WinkStickerModel)localObject7).getLeftTopInView(), ((WinkStickerModel)localObject7).getRightBottomInView(), ((WinkStickerModel)localObject7).getMaterial(), ((WinkStickerModel)localObject7).getLastDownScale(), ((WinkStickerModel)localObject7).getLastDownScale()));
            }
          }
          ((WinkEditData)localObject2).setStickerExtraMap((Map)localObject3);
          localWinkEditDataWrapper.getEditDatas().add(localObject2);
        }
      }
    }
    WinkDatongCurrentParams.paramsForPublish.clear();
    localObject1 = WinkEditorFragment.d(this.a);
    localObject2 = "";
    if (localObject1 != null)
    {
      localObject1 = ((WinkTavCutDelegate)localObject1).j();
      if (localObject1 != null)
      {
        localObject6 = ((Iterable)localObject1).iterator();
        localObject1 = "";
        do
        {
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject3 = ((WinkEditData)((Iterator)localObject6).next()).getStickerModelMap();
        } while (localObject3 == null);
        localObject7 = ((Map)localObject3).entrySet().iterator();
        localObject4 = localObject1;
        localObject3 = localObject2;
        for (;;)
        {
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (!((Iterator)localObject7).hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)((Iterator)localObject7).next();
          localObject2 = ((WinkStickerModel)((Map.Entry)localObject1).getValue()).getMaterial();
          if ((localObject2 != null) && (TextMetaMaterialKt.a((MetaMaterial)localObject2) == true))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject4);
            localObject1 = ((WinkStickerModel)((Map.Entry)localObject1).getValue()).getMaterial();
            if (localObject1 != null) {
              localObject1 = ((MetaMaterial)localObject1).id;
            } else {
              localObject1 = null;
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",");
            localObject4 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject3);
            localObject1 = ((WinkStickerModel)((Map.Entry)localObject1).getValue()).getMaterial();
            if (localObject1 != null) {
              localObject1 = ((MetaMaterial)localObject1).id;
            } else {
              localObject1 = null;
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",");
            localObject3 = ((StringBuilder)localObject2).toString();
          }
        }
      }
    }
    localObject3 = "";
    localObject4 = localObject2;
    localObject1 = localObject4;
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      i = ((String)localObject4).length();
      if (localObject4 != null)
      {
        localObject1 = ((String)localObject4).substring(0, i - 1);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      i = ((String)localObject3).length();
      if (localObject3 != null)
      {
        localObject2 = ((String)localObject3).substring(0, i - 1);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    localObject3 = WinkDatongCurrentParams.paramsForPublish;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "WinkDatongCurrentParams.paramsForPublish");
    ((Map)localObject3).put("publish_sticker_id", localObject1);
    localObject1 = WinkDatongCurrentParams.paramsForPublish;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.paramsForPublish");
    ((Map)localObject1).put("publish_text_id", localObject2);
    localObject1 = WinkEditorFragment.f(this.a);
    localObject2 = this.a;
    ((WinkExportViewModel)localObject1).a((WinkEditorFragment)localObject2, WinkEditorFragment.d((WinkEditorFragment)localObject2), localWinkEditDataWrapper);
    ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).report(WinkEditorFragment.g(this.a), ((IPeakIpcModuleServer)QRoute.api(IPeakIpcModuleServer.class)).ACTION_QCIRCLE_PICKER_EXIT_NORMAL());
    localObject2 = (Map)new HashMap();
    localObject1 = WinkEditorFragment.h(this.a).e();
    if (localObject1 != null)
    {
      ((Map)localObject2).put("xsj_filter_name", MetaMaterialKt.b((MetaMaterial)localObject1));
      localObject3 = WinkDatongCurrentParams.paramsForPublish;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "WinkDatongCurrentParams.paramsForPublish");
      ((Map)localObject3).put("publish_filter_id", ((MetaMaterial)localObject1).id);
    }
    localObject1 = WinkDatongCurrentParams.paramsForPublish;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.paramsForPublish");
    localObject3 = (Map)localObject1;
    localObject1 = WinkEditorFragment.e(this.a);
    if (localObject1 != null)
    {
      localObject1 = ((MusicSourceViewModel)localObject1).h();
      if (localObject1 != null)
      {
        localObject1 = ((WinkEditorMusicInfo)localObject1).c();
        break label1136;
      }
    }
    localObject1 = null;
    label1136:
    ((Map)localObject3).put("publish_music_id", localObject1);
    localObject1 = WinkDatongCurrentParams.paramsForPublish;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.paramsForPublish");
    localObject3 = (Map)localObject1;
    localObject1 = WinkEditorFragment.i(this.a);
    if (localObject1 != null) {
      localObject1 = ((WinkEditorTemplateViewModel)localObject1).e();
    } else {
      localObject1 = null;
    }
    ((Map)localObject3).put("publish_template_id", localObject1);
    localObject3 = WinkEditorFragment.d(this.a);
    localObject1 = localObject5;
    if (localObject3 != null) {
      localObject1 = ((WinkTavCutDelegate)localObject3).f();
    }
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (WinkStickerModel)((Iterator)localObject1).next();
        if ((((WinkStickerModel)localObject3).getMaterial() != null) && (TextMetaMaterialKt.a(((WinkStickerModel)localObject3).getMaterial()))) {
          ((Map)localObject2).put("xsj_paste_name", MetaMaterialKt.b(((WinkStickerModel)localObject3).getMaterial()));
        }
      }
    }
    localObject1 = WinkDatongCurrentParams.get("xsj_template_name");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…ramKey.XSJ_TEMPLATE_NAME)");
    ((Map)localObject2).put("xsj_template_name", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_char_form_name");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…amKey.XSJ_CHAR_FORM_NAME)");
    ((Map)localObject2).put("xsj_char_form_name", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_char_pattern_name");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…ey.XSJ_CHAR_PATTERN_NAME)");
    ((Map)localObject2).put("xsj_char_pattern_name", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_char_art_name");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…ramKey.XSJ_CHAR_ART_NAME)");
    ((Map)localObject2).put("xsj_char_art_name", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_music_id");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…entParamKey.XSJ_MUSIC_ID)");
    ((Map)localObject2).put("xsj_music_id", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_music_name");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…tParamKey.XSJ_MUSIC_NAME)");
    ((Map)localObject2).put("xsj_music_name", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_music_is_default");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…Key.XSJ_MUSIC_IS_DEFAULT)");
    ((Map)localObject2).put("xsj_music_is_default", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_music_from");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…tParamKey.XSJ_MUSIC_FROM)");
    ((Map)localObject2).put("xsj_music_from", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_music_volume_value");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…y.XSJ_MUSIC_VOLUME_VALUE)");
    ((Map)localObject2).put("xsj_music_volume_value", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_original_volume_value");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…SJ_ORIGINAL_VOLUME_VALUE)");
    ((Map)localObject2).put("xsj_original_volume_value", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_music_is_cut");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…aramKey.XSJ_MUSIC_IS_CUT)");
    ((Map)localObject2).put("xsj_music_is_cut", localObject1);
    localObject1 = WinkDatongCurrentParams.get("xsj_paste_name");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "WinkDatongCurrentParams.…tParamKey.XSJ_PASTE_NAME)");
    ((Map)localObject2).put("xsj_paste_name", localObject1);
    localObject1 = this.a;
    WinkEditorFragment.a((WinkEditorFragment)localObject1, (View)WinkEditorFragment.j((WinkEditorFragment)localObject1), "em_xsj_next_button", "ev_xsj_camera_action", (Map)localObject2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.initNextBtn.1
 * JD-Core Version:    0.7.0.1
 */