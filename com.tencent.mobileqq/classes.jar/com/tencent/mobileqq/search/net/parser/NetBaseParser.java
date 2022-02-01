package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBigImageItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateFriendUpdatesItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateQAItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateTitleItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import unite.DynamicSearch.ResultItem;
import unite.DynamicSearch.ResultItemGroup;

public class NetBaseParser
  implements INetSearchResultParser<ISearchResultGroupModel>
{
  public List<ISearchResultGroupModel> a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 3))
    {
      Object localObject2;
      if ((paramVarArgs[0] instanceof String)) {
        localObject2 = (String)paramVarArgs[0];
      } else {
        localObject2 = "";
      }
      if ((paramVarArgs[1] instanceof List)) {
        localObject1 = (List)paramVarArgs[1];
      } else {
        localObject1 = new ArrayList();
      }
      int j;
      if ((paramVarArgs[2] instanceof Integer)) {
        j = ((Integer)paramVarArgs[2]).intValue();
      } else {
        j = -1;
      }
      paramVarArgs = new ArrayList(((List)localObject1).size());
      Iterator localIterator = ((List)localObject1).iterator();
      Object localObject1 = paramVarArgs;
      paramVarArgs = (Object[])localObject2;
      while (localIterator.hasNext())
      {
        DynamicSearch.ResultItemGroup localResultItemGroup = (DynamicSearch.ResultItemGroup)localIterator.next();
        long l3 = localResultItemGroup.group_mask.get();
        String str1 = localResultItemGroup.group_name.get().toStringUtf8();
        localObject2 = localResultItemGroup.rpt_highlight_words.get();
        ArrayList localArrayList = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList.add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
        }
        Object localObject3 = localResultItemGroup.result_items.get();
        localObject2 = new ArrayList(((List)localObject3).size());
        boolean bool1;
        if (localResultItemGroup.hide_title.get() == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        String str2 = localResultItemGroup.group_footer_name.get().toStringUtf8();
        String str3 = localResultItemGroup.group_footer_jump_url.get().toStringUtf8();
        long l1 = ((List)localObject3).size();
        int i = 0;
        Object localObject4;
        boolean bool2;
        while (i < ((List)localObject3).size())
        {
          Object localObject5 = (DynamicSearch.ResultItem)((List)localObject3).get(i);
          Object localObject6 = ((DynamicSearch.ResultItem)localObject5).sub_result_items.get();
          int k = ((List)localObject6).size() + 1;
          localObject4 = new ArrayList(k);
          ((List)localObject4).add(localObject5);
          ((List)localObject4).addAll((Collection)localObject6);
          int m = 0;
          localObject5 = paramVarArgs;
          while (m < k)
          {
            localObject6 = (DynamicSearch.ResultItem)((List)localObject4).get(m);
            Object localObject7 = ((DynamicSearch.ResultItem)localObject6).result_id.get().toStringUtf8();
            bool2 = ((DynamicSearch.ResultItem)localObject6).layout_id.has();
            String str4 = ((DynamicSearch.ResultItem)localObject6).name.get().toStringUtf8();
            long l2;
            if (((DynamicSearch.ResultItem)localObject6).group_mask.has()) {
              l2 = ((DynamicSearch.ResultItem)localObject6).group_mask.get();
            } else {
              l2 = l3;
            }
            String str5 = ((DynamicSearch.ResultItem)localObject6).pic_url.get().toStringUtf8();
            String str6 = ((DynamicSearch.ResultItem)localObject6).jmp_url.get().toStringUtf8();
            String str7 = ((DynamicSearch.ResultItem)localObject6).extension.get().toStringUtf8();
            if (bool2)
            {
              switch (((DynamicSearch.ResultItem)localObject6).layout_id.get())
              {
              case 5: 
              case 10: 
              default: 
                paramVarArgs = null;
                break;
              case 16: 
                paramVarArgs = new NetSearchTemplateNetSeaEntranceItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 15: 
                paramVarArgs = new NetSearchTemplateQAItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 14: 
                paramVarArgs = new NetSearchTemplateTitleItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 13: 
                paramVarArgs = new NetSearchTemplateHorSlidingContainerItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 12: 
                paramVarArgs = new NetSearchTemplateBigImageItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 11: 
                paramVarArgs = new NetSearchTemplateFriendUpdatesItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 9: 
                paramVarArgs = new NetSearchTemplateSubItemTitle((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 8: 
                paramVarArgs = new NetSearchTemplateSubItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 7: 
                paramVarArgs = new NetSearchTemplateHorizontalContainerItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 6: 
                paramVarArgs = new NetSearchTemplateUniversalItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 4: 
                paramVarArgs = new NetSearchTemplateBannerTitleItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 3: 
                paramVarArgs = new NetSearchTemplateUpdatesItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
                break;
              case 2: 
                paramVarArgs = new NetSearchTemplateAvatarsItem((String)localObject5, l3, localArrayList, (DynamicSearch.ResultItem)localObject6, j);
              }
              if ((paramVarArgs != null) && (paramVarArgs.i()))
              {
                paramVarArgs.af = ((DynamicSearch.ResultItem)localObject6).seporator_type.get();
                paramVarArgs.r = bool1;
                ((List)localObject2).add(paramVarArgs);
              }
              else
              {
                l1 -= 1L;
              }
            }
            for (;;)
            {
              paramVarArgs = (Object[])localObject1;
              localObject1 = localObject2;
              break label1112;
              paramVarArgs = (Object[])localObject2;
              if (!SearchUtils.b(l2))
              {
                paramVarArgs = new StringBuilder();
                paramVarArgs.append("itemGroupMask is not valid. mask=");
                paramVarArgs.append(l2);
                QLog.e("Q.uniteSearch.NetBaseParser", 1, paramVarArgs.toString());
              }
              else
              {
                if (l2 != 2073745984L) {
                  break;
                }
                localObject7 = new SearchResultModelForEntrance((String)localObject5, str7, -4, str5);
                ((SearchResultModelForEntrance)localObject7).af = ((DynamicSearch.ResultItem)localObject6).seporator_type.get();
                paramVarArgs.add(localObject7);
              }
            }
            localObject2 = paramVarArgs;
            paramVarArgs = (Object[])localObject1;
            localObject1 = new GroupBaseNetSearchModelItem((String)localObject5, (String)localObject7, str4, str5, str6, str7, l2, localArrayList, j);
            ((GroupBaseNetSearchModelItem)localObject1).af = ((DynamicSearch.ResultItem)localObject6).seporator_type.get();
            ((GroupBaseNetSearchModelItem)localObject1).G = bool1;
            ((GroupBaseNetSearchModelItem)localObject1).L = i;
            ((GroupBaseNetSearchModelItem)localObject1).M = i;
            ((GroupBaseNetSearchModelItem)localObject1).m = j;
            ((List)localObject2).add(localObject1);
            localObject1 = localObject2;
            label1112:
            m += 1;
            localObject2 = localObject1;
            localObject1 = paramVarArgs;
          }
          i += 1;
          paramVarArgs = (Object[])localObject5;
        }
        if (l1 > 0L)
        {
          l1 = localResultItemGroup.total_result_count.get();
          localObject3 = localResultItemGroup.more_url.get().toStringUtf8();
          localObject4 = localResultItemGroup.more_name.get().toStringUtf8();
          if (localResultItemGroup.highlight_title_keyword.get() == 1) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          boolean bool3;
          if (localResultItemGroup.hide_title_blank_view.get() == 1) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          ((List)localObject1).add(new GroupBaseNetSearchModel(paramVarArgs, l3, str1, (List)localObject2, l1, (String)localObject3, (String)localObject4, localArrayList, bool1, bool2, bool3, str2, str3));
        }
      }
      return localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.NetBaseParser
 * JD-Core Version:    0.7.0.1
 */