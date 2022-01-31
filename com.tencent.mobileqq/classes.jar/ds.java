import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;

class ds
  implements View.OnClickListener
{
  ds(dr paramdr) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {}
    do
    {
      return;
      this.a.a();
      paramView = (ed)paramView.getTag();
      localObject2 = paramView.a();
      localObject1 = ((DataLineMsgSet)localObject2).getFirstItem();
      if (!((DataLineMsgSet)localObject2).isSingle()) {
        break;
      }
    } while (-1000 == ((DataLineMsgRecord)localObject1).msgtype);
    FileManagerEntity localFileManagerEntity = apck.a((DataLineMsgRecord)localObject1);
    if ((((DataLineMsgRecord)localObject1).nOpType == 31) || (apck.d(localFileManagerEntity)))
    {
      dr.a(this.a, (DataLineMsgRecord)localObject1);
      return;
    }
    if (((DataLineMsgRecord)localObject1).nOpType == 29)
    {
      dr.b(this.a, (DataLineMsgRecord)localObject1);
      return;
    }
    Object localObject2 = new aowr(this.a.jdField_a_of_type_AndroidContentContext, localFileManagerEntity);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity.nFileType == 0)
    {
      Iterator localIterator = dr.a(this.a).iterator();
      label304:
      while (localIterator.hasNext())
      {
        Object localObject3 = (DataLineMsgSet)localIterator.next();
        if (((DataLineMsgSet)localObject3).isSingle())
        {
          localObject3 = ((DataLineMsgSet)localObject3).values().iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label304;
            }
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
            int j = apck.a(localDataLineMsgRecord.filename);
            int i = j;
            if (j == -1)
            {
              i = j;
              if (localDataLineMsgRecord.msgtype == -2000) {
                i = 0;
              }
            }
            if (i != localFileManagerEntity.nFileType) {
              break;
            }
            if (localDataLineMsgRecord != localObject1) {
              localArrayList.add(String.valueOf(apck.a(localDataLineMsgRecord).nSessionId));
            } else {
              localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
            }
          }
        }
      }
      if (localArrayList.size() == 0) {
        localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      }
      ((aowr)localObject2).a(localArrayList);
    }
    paramView = apdq.a(paramView.a().a, localFileManagerEntity.fileName);
    Object localObject1 = new aows(this.a.jdField_a_of_type_AndroidContentContext, (aowv)localObject2);
    ((aows)localObject1).a(11);
    ((aows)localObject1).a(paramView);
    ((aows)localObject1).a();
    return;
    if (((DataLineMsgSet)localObject2).getGroupType() == -2000)
    {
      paramView = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, LiteMutiPicViewerActivity.class);
      paramView.putExtra("dataline_group_id", ((DataLineMsgSet)localObject2).getGroupId());
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity, DLFilesViewerActivity.class);
    paramView.putExtra("dl_files_groupid", ((DataLineMsgSet)localObject2).getGroupId());
    this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ds
 * JD-Core Version:    0.7.0.1
 */