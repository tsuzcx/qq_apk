package com.tencent.mobileqq.search.net.parser;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBigImageItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateFriendUpdatesItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateQAItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unify.search.UnifySearchCommon.ResultItemGroup;

public class TabNetBaseParser
  implements INetSearchResultParser<ISearchResultGroupModel>
{
  private boolean a = false;
  
  public List<ISearchResultGroupModel> a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 3)) {
      return null;
    }
    String str2 = "";
    if ((paramVarArgs[0] instanceof String)) {
      str2 = (String)paramVarArgs[0];
    }
    if ((paramVarArgs[1] instanceof List)) {}
    int k;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    UnifySearchCommon.ResultItemGroup localResultItemGroup;
    long l3;
    String str5;
    ArrayList localArrayList3;
    for (Object localObject1 = (List)paramVarArgs[1];; localObject1 = new ArrayList())
    {
      k = -1;
      if ((paramVarArgs[2] instanceof Integer)) {
        k = ((Integer)paramVarArgs[2]).intValue();
      }
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList(((List)localObject1).size());
      Iterator localIterator = ((List)localObject1).iterator();
      localObject1 = null;
      if (!localIterator.hasNext()) {
        break label1849;
      }
      localResultItemGroup = (UnifySearchCommon.ResultItemGroup)localIterator.next();
      l3 = localResultItemGroup.group_mask.get();
      str5 = localResultItemGroup.group_name.get().toStringUtf8();
      paramVarArgs = localResultItemGroup.rpt_highlight_words.get();
      localArrayList3 = new ArrayList(paramVarArgs.size());
      paramVarArgs = paramVarArgs.iterator();
      while (paramVarArgs.hasNext()) {
        localArrayList3.add(((ByteStringMicro)paramVarArgs.next()).toStringUtf8());
      }
    }
    List localList = localResultItemGroup.result_items.get();
    ArrayList localArrayList4 = new ArrayList(localList.size());
    boolean bool1;
    if (localResultItemGroup.hide_title.get() == 1)
    {
      bool1 = true;
      label271:
      if (!this.a) {
        break label1988;
      }
      bool1 = true;
    }
    label320:
    label1988:
    for (;;)
    {
      String str6 = localResultItemGroup.group_footer_name.get().toStringUtf8();
      String str7 = localResultItemGroup.group_footer_jump_url.get().toStringUtf8();
      long l1 = localList.size();
      int m = 0;
      Object localObject2;
      int n;
      UnifySearchCommon.ResultItem localResultItem;
      String str9;
      boolean bool2;
      String str8;
      long l2;
      label476:
      String str10;
      String str11;
      String str12;
      int i2;
      String str1;
      String str4;
      int i1;
      int j;
      int i;
      if (m < localList.size())
      {
        paramVarArgs = (UnifySearchCommon.ResultItem)localList.get(m);
        localObject2 = paramVarArgs.sub_result_items.get();
        int i3 = ((List)localObject2).size() + 1;
        ArrayList localArrayList5 = new ArrayList(i3);
        localArrayList5.add(paramVarArgs);
        localArrayList5.addAll((Collection)localObject2);
        n = 0;
        if (n < i3)
        {
          localResultItem = (UnifySearchCommon.ResultItem)localArrayList5.get(n);
          str9 = localResultItem.result_id.get().toStringUtf8();
          bool2 = localResultItem.layout_id.has();
          str8 = localResultItem.name.get().toStringUtf8();
          if (localResultItem.group_mask.has())
          {
            l2 = localResultItem.group_mask.get();
            str10 = localResultItem.pic_url.get().toStringUtf8();
            str11 = localResultItem.jmp_url.get().toStringUtf8();
            str12 = localResultItem.extension.get().toStringUtf8();
            paramVarArgs = "";
            localObject2 = "";
            i2 = 0;
            str1 = "";
            str4 = "";
            i1 = 0;
            j = 0;
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.NetBaseParser", 2, "exhibition Result" + str12);
            }
            i = i1;
            if (l2 != 1001L) {
              break label1014;
            }
            i = i1;
            if (TextUtils.isEmpty(str12)) {
              break label1014;
            }
            i = j;
          }
        }
      }
      for (;;)
      {
        label1014:
        Object localObject4;
        for (;;)
        {
          String str3;
          Object localObject5;
          Object localObject9;
          try
          {
            localObject3 = new JSONObject(str12);
            i = j;
            j = ((JSONObject)localObject3).optInt("is_qid_no");
            i = j;
            str3 = ((JSONObject)localObject3).optString("qid");
            i1 = j;
            if ((l2 != 8001L) || (str12.equals(""))) {
              break label1964;
            }
            localObject8 = str1;
            i = i2;
            localObject5 = localObject2;
            localObject3 = paramVarArgs;
          }
          catch (Exception localException)
          {
            Object localObject3;
            JSONObject localJSONObject;
            localException.printStackTrace();
          }
          try
          {
            localJSONObject = new JSONObject(str12);
            localObject8 = str1;
            i = i2;
            localObject5 = localObject2;
            localObject3 = paramVarArgs;
            localObject9 = new JSONObject(localJSONObject.optJSONArray("attribute").get(0).toString());
            localObject8 = str1;
            i = i2;
            localObject5 = localObject2;
            localObject3 = paramVarArgs;
            paramVarArgs = ((JSONObject)localObject9).optString("exhibition_type");
            localObject8 = str1;
            i = i2;
            localObject5 = localObject2;
            localObject3 = paramVarArgs;
            localObject2 = ((JSONObject)localObject9).optString("exhibition_name");
            localObject8 = str1;
            i = i2;
            localObject5 = localObject2;
            localObject3 = paramVarArgs;
            j = ((JSONObject)localObject9).optInt("count");
            localObject8 = str1;
            i = j;
            localObject5 = localObject2;
            localObject3 = paramVarArgs;
            str1 = ((JSONObject)localObject9).optString("color");
            localObject8 = str1;
            i = j;
            localObject5 = localObject2;
            localObject3 = paramVarArgs;
            localObject9 = ((JSONObject)localObject9).optString("exhibition_msg");
            localObject3 = localObject9;
          }
          catch (JSONException localJSONException2)
          {
            localObject9 = "";
            localObject2 = localObject5;
            paramVarArgs = localException;
            localObject4 = localObject8;
            localObject5 = localObject9;
          }
          try
          {
            localObject5 = localJSONObject.optString("jumpPath");
            i = j;
            localObject8 = localObject5;
            localObject5 = localObject3;
            localObject3 = str1;
            if (!bool2) {
              break label1338;
            }
            localObject2 = null;
            paramVarArgs = (Object[])localObject2;
            switch (localResultItem.layout_id.get())
            {
            default: 
              paramVarArgs = (Object[])localObject2;
            case 5: 
            case 10: 
              if ((paramVarArgs == null) || (!paramVarArgs.b())) {
                break label1329;
              }
              paramVarArgs.u = localResultItem.seporator_type.get();
              paramVarArgs.a = bool1;
              localArrayList4.add(paramVarArgs);
              n += 1;
            }
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              boolean bool3;
              localObject8 = localJSONException2;
              i = j;
              Object localObject7 = localJSONException1;
              localObject6 = localObject4;
              localObject4 = localObject8;
              continue;
              paramVarArgs = (Object[])localObject1;
            }
          }
        }
        bool1 = false;
        break label271;
        l2 = l3;
        break label476;
        str3 = null;
        i1 = i;
        continue;
        localJSONException2.printStackTrace();
        Object localObject8 = str4;
        continue;
        paramVarArgs = new NetSearchTemplateAvatarsItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateUpdatesItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateBannerTitleItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateHorizontalContainerItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateUniversalItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateSubItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateSubItemTitle(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateFriendUpdatesItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateBigImageItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateHorSlidingContainerItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateTitleItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateQAItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        paramVarArgs = new NetSearchTemplateNetSeaEntranceItem(str2, l3, localArrayList3, localResultItem, k);
        continue;
        l1 -= 1L;
        continue;
        if (!SearchUtils.b(l2))
        {
          QLog.e("Q.uniteSearch.NetBaseParser", 1, "itemGroupMask is not valid. mask=" + l2);
        }
        else if (l2 == 2073745984L)
        {
          paramVarArgs = new SearchResultModelForEntrance(str2, str12, -4, str10);
          paramVarArgs.u = localResultItem.seporator_type.get();
          localArrayList4.add(paramVarArgs);
        }
        else
        {
          paramVarArgs = new GroupBaseNetSearchModelItem(str2, str9, str8, str10, str11, str12, l2, localArrayList3, k, paramVarArgs, (String)localObject2, i, (String)localObject4, (String)localObject5, (String)localObject8);
          paramVarArgs.u = localResultItem.seporator_type.get();
          paramVarArgs.c = bool1;
          paramVarArgs.j = m;
          paramVarArgs.k = m;
          paramVarArgs.a = k;
          if ((i1 == 1) && (l2 == 1001L))
          {
            paramVarArgs.h = str3;
            localArrayList1.add(paramVarArgs);
            l2 = l1 - 1L;
            l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.uniteSearch.NetBaseParser", 2, "QID_LOG,search_has," + str2 + "," + str8);
              l1 = l2;
            }
          }
          else
          {
            localArrayList4.add(paramVarArgs);
            continue;
            m += 1;
            break label320;
            if (l3 == 1001L)
            {
              paramVarArgs = localResultItemGroup.more_url.get().toStringUtf8();
              localObject1 = localResultItemGroup.more_name.get().toStringUtf8();
              if (localResultItemGroup.highlight_title_keyword.get() == 1)
              {
                bool2 = true;
                label1658:
                if (localResultItemGroup.hide_title_blank_view.get() != 1) {
                  break label1831;
                }
                bool3 = true;
                paramVarArgs = new GroupBaseNetSearchModel(str2, l3, "QID", null, 0L, paramVarArgs, (String)localObject1, localArrayList3, bool1, bool2, bool3, str6, str7);
                if (l1 > 0L)
                {
                  l1 = localResultItemGroup.total_result_count.get();
                  localObject1 = localResultItemGroup.more_url.get().toStringUtf8();
                  localObject2 = localResultItemGroup.more_name.get().toStringUtf8();
                  if (localResultItemGroup.highlight_title_keyword.get() != 1) {
                    break label1837;
                  }
                  bool2 = true;
                  label1763:
                  if (localResultItemGroup.hide_title_blank_view.get() != 1) {
                    break label1843;
                  }
                }
              }
              for (bool3 = true;; bool3 = false)
              {
                localArrayList2.add(new GroupBaseNetSearchModel(str2, l3, str5, localArrayList4, l1, (String)localObject1, (String)localObject2, localArrayList3, bool1, bool2, bool3, str6, str7));
                localObject1 = paramVarArgs;
                break;
                bool2 = false;
                break label1658;
                bool3 = false;
                break label1673;
                bool2 = false;
                break label1763;
              }
              if ((localObject1 != null) && (!localArrayList1.isEmpty()))
              {
                ((GroupBaseNetSearchModel)localObject1).a(localArrayList1);
                ((GroupBaseNetSearchModel)localObject1).a(localArrayList1.size());
                localArrayList2.add(0, localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.uniteSearch.NetBaseParser", 2, "QID_LOG,search_add," + localArrayList1.size());
                }
              }
              return localArrayList2;
            }
            Object localObject6 = "";
            localObject4 = "";
            i = 0;
            localObject2 = "";
            paramVarArgs = "";
            localObject8 = str4;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.TabNetBaseParser
 * JD-Core Version:    0.7.0.1
 */