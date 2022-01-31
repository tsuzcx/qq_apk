package dov.com.tencent.biz.qqstory.takevideo.tag;

import android.support.annotation.Nullable;
import aoeu;
import aoew;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetTagListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoTag.EditBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class EditVideoTagPresenter
{
  private final int jdField_a_of_type_Int = 20;
  private TagItem jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EditVideoTag.EditBehavior jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag$EditBehavior;
  private final IEditVideoTagView jdField_a_of_type_DovComTencentBizQqstoryTakevideoTagIEditVideoTagView;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b = 1;
  
  public EditVideoTagPresenter(IEditVideoTagView paramIEditVideoTagView, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoTagIEditVideoTagView = paramIEditVideoTagView;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public static List a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new TagItem((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List paramList)
  {
    try
    {
      Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramEntityManager.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramEntityManager.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramEntityManager.b(((TagItem)paramList.next()).a());
    }
    paramEntityManager.a().c();
    paramEntityManager.a().b();
  }
  
  @Nullable
  public TagItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag$EditBehavior = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem = null;
  }
  
  public void a(TagItem paramTagItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem = paramTagItem;
  }
  
  public void a(@Nonnull EditVideoTag.EditBehavior paramEditBehavior)
  {
    SLog.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramEditBehavior);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag$EditBehavior = paramEditBehavior;
    if (paramEditBehavior.jdField_a_of_type_Boolean) {}
    for (paramEditBehavior = new GetTagListRequest(paramEditBehavior.jdField_a_of_type_Int, paramEditBehavior.jdField_a_of_type_Long, "", 20);; paramEditBehavior = new GetTagListRequest("", 20))
    {
      CmdTaskManger.a().a(paramEditBehavior, new aoeu(this));
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(EditVideoTag.EditBehavior paramEditBehavior)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag$EditBehavior != null) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag$EditBehavior.equals(paramEditBehavior)) {}
    }
    while (paramEditBehavior != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull EditVideoTag.EditBehavior paramEditBehavior)
  {
    SLog.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramEditBehavior);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag$EditBehavior = paramEditBehavior;
    if (paramEditBehavior.jdField_a_of_type_Boolean) {}
    for (paramEditBehavior = new GetTagListRequest(paramEditBehavior.jdField_a_of_type_Int, paramEditBehavior.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramEditBehavior = new GetTagListRequest(this.jdField_a_of_type_JavaLangString, 20))
    {
      CmdTaskManger.a().a(paramEditBehavior, new aoew(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter
 * JD-Core Version:    0.7.0.1
 */