package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateAvatarsItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBannerTitleItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUpdatesItem;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import pb.unite.search.DynamicSearch.ResultItem;
import pb.unite.search.DynamicSearch.ResultItemGroup;

public class NetBaseParser
  implements INetSearchResultParser
{
  public List a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 3)) {
      return null;
    }
    String str1 = "";
    if ((paramVarArgs[0] instanceof String)) {
      str1 = (String)paramVarArgs[0];
    }
    Object localObject;
    int i;
    ArrayList localArrayList1;
    Iterator localIterator;
    if ((paramVarArgs[1] instanceof List))
    {
      localObject = (List)paramVarArgs[1];
      i = -1;
      if ((paramVarArgs[2] instanceof Integer)) {
        i = ((Integer)paramVarArgs[2]).intValue();
      }
      localArrayList1 = new ArrayList(((List)localObject).size());
      localIterator = ((List)localObject).iterator();
    }
    for (;;)
    {
      label792:
      label1073:
      if (localIterator.hasNext())
      {
        DynamicSearch.ResultItemGroup localResultItemGroup = (DynamicSearch.ResultItemGroup)localIterator.next();
        long l3 = localResultItemGroup.group_mask.get();
        String str2 = localResultItemGroup.group_name.get().toStringUtf8();
        paramVarArgs = localResultItemGroup.rpt_highlight_words.get();
        ArrayList localArrayList2 = new ArrayList(paramVarArgs.size());
        paramVarArgs = paramVarArgs.iterator();
        for (;;)
        {
          if (paramVarArgs.hasNext())
          {
            localArrayList2.add(((ByteStringMicro)paramVarArgs.next()).toStringUtf8());
            continue;
            localObject = new ArrayList();
            break;
          }
        }
        List localList1 = localResultItemGroup.result_items.get();
        ArrayList localArrayList3 = new ArrayList(localList1.size());
        boolean bool1;
        String str3;
        String str4;
        long l1;
        int j;
        if (localResultItemGroup.hide_title.get() == 1)
        {
          bool1 = true;
          str3 = localResultItemGroup.group_footer_name.get().toStringUtf8();
          str4 = localResultItemGroup.group_footer_jump_url.get().toStringUtf8();
          l1 = localList1.size();
          j = 0;
        }
        label371:
        boolean bool2;
        for (;;)
        {
          if (j >= localList1.size()) {
            break label952;
          }
          paramVarArgs = (DynamicSearch.ResultItem)localList1.get(j);
          localObject = paramVarArgs.sub_result_items.get();
          int m = ((List)localObject).size() + 1;
          ArrayList localArrayList4 = new ArrayList(m);
          localArrayList4.add(paramVarArgs);
          localArrayList4.addAll((Collection)localObject);
          int k = 0;
          if (k < m)
          {
            DynamicSearch.ResultItem localResultItem = (DynamicSearch.ResultItem)localArrayList4.get(k);
            localResultItem.sub_item_list.set(null);
            paramVarArgs = localResultItem.result_id.get().toStringUtf8();
            bool2 = localResultItem.layout_id.has();
            localObject = localResultItem.name.get().toStringUtf8();
            long l2;
            label457:
            String str5;
            String str6;
            String str7;
            List localList2;
            if (localResultItem.group_mask.has())
            {
              l2 = localResultItem.group_mask.get();
              str5 = localResultItem.pic_url.get().toStringUtf8();
              str6 = localResultItem.jmp_url.get().toStringUtf8();
              str7 = localResultItem.extension.get().toStringUtf8();
              localList2 = localResultItem.sub_item_list.get();
              if (!bool2) {
                break label792;
              }
              localObject = null;
              paramVarArgs = (Object[])localObject;
              switch (localResultItem.layout_id.get())
              {
              default: 
                paramVarArgs = (Object[])localObject;
              case 5: 
                label575:
                if ((paramVarArgs != null) && (paramVarArgs.b()))
                {
                  paramVarArgs.c = localResultItem.seporator_type.get();
                  paramVarArgs.a = bool1;
                  localArrayList3.add(paramVarArgs);
                  l2 = l1;
                }
                break;
              }
            }
            for (;;)
            {
              k += 1;
              l1 = l2;
              break label371;
              bool1 = false;
              break;
              l2 = l3;
              break label457;
              paramVarArgs = new NetSearchTemplateAvatarsItem(str1, l3, localArrayList2, localResultItem, i);
              break label575;
              paramVarArgs = new NetSearchTemplateUpdatesItem(str1, l3, localArrayList2, localResultItem, i);
              break label575;
              paramVarArgs = new NetSearchTemplateBannerTitleItem(str1, l3, localArrayList2, localResultItem, i);
              break label575;
              paramVarArgs = new NetSearchTemplateHorizontalContainerItem(str1, l3, localArrayList2, localResultItem, i);
              break label575;
              paramVarArgs = new NetSearchTemplateUniversalItem(str1, l3, localArrayList2, localResultItem, i);
              break label575;
              paramVarArgs = new NetSearchTemplateSubItem(str1, l3, localArrayList2, localResultItem, i);
              break label575;
              paramVarArgs = new NetSearchTemplateSubItemTitle(str1, l3, localArrayList2, localResultItem, i);
              break label575;
              l2 = l1 - 1L;
              continue;
              if (!SearchUtils.b(l2))
              {
                QLog.e("Q.uniteSearch.NetBaseParser", 1, "itemGroupMask is not valid. mask=" + l2);
                l2 = l1;
              }
              else if (l2 == 2073745984L)
              {
                localArrayList3.add(new SearchResultModelForEntrance(str1, str7, -4, str5, localList2));
                l2 = l1;
              }
              else
              {
                paramVarArgs = new GroupBaseNetSearchModelItem(str1, paramVarArgs, (String)localObject, str5, str6, str7, l2, localArrayList2, localList2);
                l2 = l1;
                if (paramVarArgs != null)
                {
                  l2 = l1;
                  if (paramVarArgs.b())
                  {
                    paramVarArgs.c = bool1;
                    paramVarArgs.g = j;
                    localArrayList3.add(paramVarArgs);
                    l2 = l1;
                  }
                }
              }
            }
          }
          j += 1;
        }
        label952:
        if (l1 > 0L)
        {
          l1 = localResultItemGroup.total_result_count.get();
          paramVarArgs = localResultItemGroup.more_url.get().toStringUtf8();
          localObject = localResultItemGroup.more_name.get().toStringUtf8();
          if (localResultItemGroup.highlight_title_keyword.get() == 1)
          {
            bool2 = true;
            label1009:
            if (localResultItemGroup.hide_title_blank_view.get() != 1) {
              break label1073;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            localArrayList1.add(new GroupBaseNetSearchModel(str1, l3, str2, localArrayList3, l1, paramVarArgs, (String)localObject, localArrayList2, bool1, bool2, bool3, str3, str4));
            break;
            bool2 = false;
            break label1009;
          }
        }
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.NetBaseParser
 * JD-Core Version:    0.7.0.1
 */