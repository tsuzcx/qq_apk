package dov.com.qq.im.ae.cmshow;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.protobuf.AEPbData.BlendItem;
import dov.com.qq.im.ae.protobuf.AEPbData.CartoonPtaResponse;
import dov.com.qq.im.ae.protobuf.AEPbData.ColorItem;
import dov.com.qq.im.ae.protobuf.AEPbData.Point3f;
import dov.com.qq.im.ae.protobuf.AEPbData.SkeletonItem;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AECMShowJsonModel
  implements Serializable
{
  private static final Type a = new AECMShowJsonModel.1().getType();
  public HashMap<String, Float> blendshape;
  public HashMap<String, AECMShowJsonModel.HSV> deltaHSV;
  public LinkedList<AECMShowJsonModel.Skeleton> skeleton;
  
  public static AECMShowJsonModel convertFromPbData(@NonNull AEPbData.CartoonPtaResponse paramCartoonPtaResponse)
  {
    AECMShowJsonModel localAECMShowJsonModel = new AECMShowJsonModel();
    Object localObject1 = new HashMap();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (!CollectionUtils.isEmpty(paramCartoonPtaResponse.deltaHSV.get()))
    {
      localObject2 = paramCartoonPtaResponse.deltaHSV.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AEPbData.ColorItem)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((AEPbData.ColorItem)localObject3).name.get())) && (((AEPbData.ColorItem)localObject3).hsv.get() != null))
        {
          localObject4 = new AECMShowJsonModel.HSV();
          ((AECMShowJsonModel.HSV)localObject4).H = ((AEPbData.ColorItem)localObject3).hsv.x.get();
          ((AECMShowJsonModel.HSV)localObject4).S = ((AEPbData.ColorItem)localObject3).hsv.y.get();
          ((AECMShowJsonModel.HSV)localObject4).V = ((AEPbData.ColorItem)localObject3).hsv.z.get();
          ((HashMap)localObject1).put(((AEPbData.ColorItem)localObject3).name.get(), localObject4);
        }
      }
    }
    localAECMShowJsonModel.deltaHSV = ((HashMap)localObject1);
    localObject1 = new LinkedList();
    if (!CollectionUtils.isEmpty(paramCartoonPtaResponse.skeleton.get()))
    {
      localObject2 = paramCartoonPtaResponse.skeleton.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AEPbData.SkeletonItem)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((AEPbData.SkeletonItem)localObject3).name.get())) && (((AEPbData.SkeletonItem)localObject3).scale.get() != null) && (((AEPbData.SkeletonItem)localObject3).position.get() != null))
        {
          localObject4 = new AECMShowJsonModel.Skeleton();
          ((AECMShowJsonModel.Skeleton)localObject4).name = ((AEPbData.SkeletonItem)localObject3).name.get();
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          localLinkedList1.add(Float.valueOf(((AEPbData.SkeletonItem)localObject3).scale.x.get()));
          localLinkedList1.add(Float.valueOf(((AEPbData.SkeletonItem)localObject3).scale.y.get()));
          localLinkedList1.add(Float.valueOf(((AEPbData.SkeletonItem)localObject3).scale.z.get()));
          ((AECMShowJsonModel.Skeleton)localObject4).scale = localLinkedList1;
          localLinkedList2.add(Float.valueOf(((AEPbData.SkeletonItem)localObject3).position.x.get()));
          localLinkedList2.add(Float.valueOf(((AEPbData.SkeletonItem)localObject3).position.y.get()));
          localLinkedList2.add(Float.valueOf(((AEPbData.SkeletonItem)localObject3).position.z.get()));
          ((AECMShowJsonModel.Skeleton)localObject4).position = localLinkedList2;
          ((LinkedList)localObject1).add(localObject4);
        }
      }
    }
    localAECMShowJsonModel.skeleton = ((LinkedList)localObject1);
    localObject1 = new HashMap();
    if (!CollectionUtils.isEmpty(paramCartoonPtaResponse.blendshape.get()))
    {
      paramCartoonPtaResponse = paramCartoonPtaResponse.blendshape.get().iterator();
      while (paramCartoonPtaResponse.hasNext())
      {
        localObject2 = (AEPbData.BlendItem)paramCartoonPtaResponse.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((AEPbData.BlendItem)localObject2).bs_key.get()))) {
          ((HashMap)localObject1).put(((AEPbData.BlendItem)localObject2).bs_key.get(), Float.valueOf(((AEPbData.BlendItem)localObject2).bs_value.get()));
        }
      }
    }
    localAECMShowJsonModel.blendshape = ((HashMap)localObject1);
    return localAECMShowJsonModel;
  }
  
  public static String convertModel2JsonString(@NonNull AECMShowJsonModel paramAECMShowJsonModel)
  {
    return GsonUtils.obj2Json(paramAECMShowJsonModel, a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowJsonModel
 * JD-Core Version:    0.7.0.1
 */