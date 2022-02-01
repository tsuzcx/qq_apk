package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.util.SparseArray;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;

public class FastWebDataInsertUtils
{
  private static int a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, List<BaseData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return -1;
      }
      int n = 0;
      if (paramBoolean1) {
        j = 0;
      } else {
        j = paramList.size() - 1;
      }
      int m = 1;
      int i;
      int k;
      do
      {
        Object localObject = (BaseData)paramList.get(j);
        i = m;
        if ((localObject instanceof ProteusItemData))
        {
          localObject = (ProteusItemData)localObject;
          i = m;
          if (((ProteusItemData)localObject).bf == 1) {
            if (((ProteusItemData)localObject).be != paramInt2)
            {
              i = m;
              if (paramInt2 != 0) {}
            }
            else
            {
              if (paramInt1 == m)
              {
                if (!paramBoolean2) {
                  j += 1;
                }
                paramInt1 = 1;
                break label188;
              }
              i = m + 1;
            }
          }
        }
        if (paramBoolean1) {
          k = j + 1;
        } else {
          k = j - 1;
        }
        if (k < 0) {
          break;
        }
        j = k;
        m = i;
      } while (k < paramList.size());
      int j = i;
      paramInt1 = n;
      label188:
      if (paramInt1 == 0) {
        return -1;
      }
      return j;
    }
    return -1;
  }
  
  public static void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, List<BaseData> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1, SparseArray<Float> paramSparseArray)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      if (b(paramList))
      {
        QLog.d("FastWeb0xc6dDataUtils", 1, "has inserted text cards!");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("insertTextCards:");
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_cmd0xe7e.TextCardInfo)localIterator.next();
        try
        {
          int i = ((oidb_cmd0xe7e.TextCardInfo)localObject).uint32_disable_scene.get();
          if ((i & paramInt) != 0)
          {
            paramList1 = new StringBuilder();
            paramList1.append("insertTextCards: disableScene ");
            paramList1.append(i);
            paramList1.append(" give up ! data : ");
            paramList1.append(((oidb_cmd0xe7e.TextCardInfo)localObject).bytes_card_json.get().toStringUtf8());
            QLog.d("FastWeb0xc6dDataUtils", 1, paramList1.toString());
            continue;
          }
          JSONObject localJSONObject = new JSONObject(((oidb_cmd0xe7e.TextCardInfo)localObject).bytes_card_json.get().toStringUtf8());
          if (FastWebPtsLiteDataUtil.a(localJSONObject))
          {
            if (!PTSLiteSwitchManager.a().b())
            {
              paramList1 = new StringBuilder();
              paramList1.append("insertTextCards give up for pts lite engine not ready ! data : ");
              paramList1.append(((oidb_cmd0xe7e.TextCardInfo)localObject).bytes_card_json.get().toStringUtf8());
              QLog.d("FastWeb0xc6dDataUtils", 1, paramList1.toString());
              continue;
            }
            paramList1 = FastWebPtsLiteDataUtil.b(localJSONObject);
            break label265;
          }
          try
          {
            paramList1 = FastWebPTSDataConverter.a(localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
            paramList1.bf = 1;
            paramList1.be = -1;
            label265:
            paramList1.aV = FastWebPTSDataConverter.a(paramSparseArray);
            a(((oidb_cmd0xe7e.TextCardInfo)localObject).enum_indexing_type.get(), ((oidb_cmd0xe7e.TextCardInfo)localObject).bool_locate_forwards.get(), ((oidb_cmd0xe7e.TextCardInfo)localObject).uint32_location.get(), ((oidb_cmd0xe7e.TextCardInfo)localObject).bool_insert_forwards.get(), paramList, paramList1);
            localStringBuilder.append("\n[data : ");
            localStringBuilder.append(localJSONObject.toString());
            localStringBuilder.append("，type : ");
            localStringBuilder.append(((oidb_cmd0xe7e.TextCardInfo)localObject).enum_indexing_type.get());
            localStringBuilder.append(", locate_forwards : ");
            localStringBuilder.append(((oidb_cmd0xe7e.TextCardInfo)localObject).bool_locate_forwards.get());
            localStringBuilder.append(", location :");
            localStringBuilder.append(((oidb_cmd0xe7e.TextCardInfo)localObject).uint32_location.get());
            localStringBuilder.append(", insert_forward : ");
            localStringBuilder.append(((oidb_cmd0xe7e.TextCardInfo)localObject).bool_insert_forwards.get());
            localStringBuilder.append(", disable_scene : ");
            localStringBuilder.append(((oidb_cmd0xe7e.TextCardInfo)localObject).uint32_disable_scene.get());
            localStringBuilder.append("]");
          }
          catch (Exception paramList1) {}
          localObject = new StringBuilder();
        }
        catch (Exception paramList1) {}
        ((StringBuilder)localObject).append("insertTextCards error! msg=");
        ((StringBuilder)localObject).append(paramList1);
        QLog.d("FastWeb0xc6dDataUtils", 1, ((StringBuilder)localObject).toString());
      }
      QLog.d("FastWeb0xc6dDataUtils", 1, localStringBuilder.toString());
    }
  }
  
  private static void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, List<BaseData> paramList, BaseData paramBaseData)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramInt1 = a(paramBoolean1, paramInt2, paramBoolean2, paramInt1, paramList);
      if (paramInt1 != -1)
      {
        if ((paramInt1 >= 0) && (paramInt1 < paramList.size()))
        {
          paramList.add(paramInt1, paramBaseData);
          return;
        }
        if (paramInt1 >= paramList.size()) {
          paramList.add(paramBaseData);
        }
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, List<BaseData> paramList, List<oidb_cmd0xe7e.ModuleInfo> paramList1, SparseArray<Float> paramSparseArray)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      if (a(paramList))
      {
        QLog.d("FastWeb0xc6dDataUtils", 1, "has inserted module!");
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramSparseArray = (oidb_cmd0xe7e.ModuleInfo)paramList1.next();
        try
        {
          localObject = FastWebPTSDataConverter.a(new JSONObject(paramSparseArray.bytes_json.get().toStringUtf8()), paramAbsBaseArticleInfo, paramFastWebArticleInfo);
          ((ProteusItemData)localObject).bf = -99;
          ((ProteusItemData)localObject).aV = paramSparseArray.bytes_weight.get();
          ItemDatasListUtils.a(paramList, (BaseData)localObject);
        }
        catch (Exception paramSparseArray)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("insertModules error! msg=");
          ((StringBuilder)localObject).append(paramSparseArray);
          QLog.d("FastWeb0xc6dDataUtils", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private static boolean a(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if (((localBaseData instanceof ProteusItemData)) && (((ProteusItemData)localBaseData).bf == -99)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if (((localBaseData instanceof ProteusItemData)) && (((ProteusItemData)localBaseData).be == -1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDataInsertUtils
 * JD-Core Version:    0.7.0.1
 */