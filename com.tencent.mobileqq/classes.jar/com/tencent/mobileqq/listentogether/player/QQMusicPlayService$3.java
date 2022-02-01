package com.tencent.mobileqq.listentogether.player;

final class QQMusicPlayService$3
  implements Runnable
{
  public void run()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfInt[0] = QQMusicPlayService.b();
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.3
 * JD-Core Version:    0.7.0.1
 */